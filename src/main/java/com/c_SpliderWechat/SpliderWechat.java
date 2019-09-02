package com.c_SpliderWechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.basicUtil.a_DBUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.*;
import java.util.Date;
import java.util.*;

import static com.b_util.HttpClientHelper.*;
import static com.b_util.basicUtil.b_PropertiesLoadUtil.loadProperties;

public class SpliderWechat implements Splider {
    private Properties prop = loadProperties("config.properties");
    private String savePicpathPrefxi = prop.getProperty("savepicpath_prefxi");


    public void getMoreInfo(String article, Map<String, String> requestHeaders) {
        try {
            article = URLEncoder.encode(article, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String t = "https://weixin.sogou.com/weixin?type=2&s_from=input&query=" + article;
        System.out.println(t);
        Map<String, String> resultUrl2 = sendGet(t, requestHeaders);
        String spliturlr = resultUrl2.get("responseContext");
        System.out.println(spliturlr);

        Document doc = Jsoup.parse(spliturlr);
        String pichref = doc.getElementById("sogou_vr_11002601_img_0").getElementsByTag("img").first().attr("src");
        System.out.println(pichref);
        Element eleText = doc.getElementById("sogou_vr_11002601_summary_0");
        String text = eleText.text();
        System.out.println(text);

    }

    public String getPictureAndUrl(String picsrc, String i) {
        String picurl = "img/wechat/" + i + ".jpg";
        sendGetToGetPicture(picsrc, null, savePicpathPrefxi + picurl);
        return picurl;
    }

    public void picToLocal(String result) {
        JSONArray jsonArray = JSON.parseArray(result);
        for (int j = 0; j < jsonArray.size(); j++) {
            String cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getString("cover");
            String id = jsonArray.getJSONObject(j).getJSONObject("comm_msg_info").getString("id");
            if (null == cover) {
                cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getJSONArray("multi_app_msg_item_list").getJSONObject(0).getString("cover");
            }
            sendGetToGetPicture(cover, null, savePicpathPrefxi + "/img/wechat/" + id + ".jpg");
        }
        System.out.println("图片下载完毕");
    }

    public List<String> getLasttimeArticleTitle() {
        List<String> alltitles = new LinkedList();
        Connection conn = a_DBUtil.getConnection();
        try {
            String sql = "select title from article_info";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                alltitles.add(title);
                System.out.println(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return alltitles;
    }

    public static void inputVerificationCode() {
        double cert = (new Date()).getTime() + Math.random();
        String url = "http://mp.weixin.qq.com/mp/verifycode?cert=" + cert;
        System.out.println(url);

        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Connection", "keep-alive");
        requestHeaders.put("Host", "weixin.sogou.com");
        requestHeaders.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        requestHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");

        Map<String, String> resultUrl4 = sendGetToGetPicture(url, requestHeaders, "yanzhenma");
        String cookie = resultUrl4.get("responseCookie");
        try {
            //等待3分钟手工输入
            Thread.sleep(3 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();
        try {
//            prop.load(new FileInputStream("C:\\Users\\Administrator\\Desktop\\shuru.txt"));
            prop.load(new FileInputStream("/opt/yanzhenma.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String input = prop.getProperty("a");
        System.out.println(input);
        String url2 = "http://mp.weixin.qq.com/mp/verifycode";
        System.out.println(url2);

        requestHeaders.put("Cookie", cookie);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("cert", cert + "");
        params.put("input", input);
        params.put("appmsg_token", "");

        String htmlstr = sendPost(url2, requestHeaders, params);
        System.out.println(htmlstr);
    }


    @Override
    public void resultToMysql(String datasource, JSONArray htmlstr) {
        Connection conn = a_DBUtil.getConnection();
        try {
            Statement deleteStatement = conn.createStatement();
            String deleteSql = "DELETE FROM article_info_v2 WHERE article_source= \"" + datasource + "\"";
            deleteStatement.execute(deleteSql);

            conn.setAutoCommit(false);
            String sql = "INSERT INTO article_info_v2 "
                    + "(article_source,title,trueurl,picurl,abstract) "
                    + "VALUES "
                    + "(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (Object i : htmlstr) {
                JSONObject jsonObject = (JSONObject) i;
                ps.setString(1, datasource);
                ps.setString(2, jsonObject.getString("article"));
                ps.setString(3, jsonObject.getString("trueurl"));
                ps.setString(4, jsonObject.getString("picpath"));
                ps.setString(5, jsonObject.getString("introduction"));
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("入库完毕");
    }

    @Override
    public JSONArray execute(String urlname) {
        JSONArray jsonArray = new JSONArray();
        String urls = null;
        try {
            urls = URLEncoder.encode(urlname, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url1 = "https://weixin.sogou.com/weixin?type=1&s_from=input&query=" + urls;
        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Connection", "keep-alive");
        requestHeaders.put("Host", "weixin.sogou.com");
        requestHeaders.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        requestHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");

        //第一次访问获取cookie以及url
        Map<String, String> resultUrl1 = sendGet(url1, requestHeaders);
        String responseContext = resultUrl1.get("responseContext");
        String cookie = resultUrl1.get("responseCookie");
//        System.out.println("responseContext:" + responseContext);
//        System.out.println(cookie);

        Document doc = Jsoup.parse(responseContext);
        Element ele = doc.getElementById("sogou_vr_11002301_box_0");
        Elements eles = ele.getElementsByTag("a");
        String linkUrl = eles.last().attr("href");
        String article = eles.last().text();
        linkUrl = linkUrl.replace("&amp;", "&");
//        System.out.println("article:" + article);
//        System.out.println("linkUrl:" + linkUrl);

        int a = linkUrl.indexOf("url=");
        int c = linkUrl.indexOf("&k=");
        int b = (int) Math.random() * 100;
        if (-1 != a && -1 == c) {
            String check = linkUrl.substring(a + 4 + 21 + b, a + 4 + 21 + b + 1);
            linkUrl = linkUrl + "&k=" + b + "&h=" + check;
        }
        linkUrl = "https://weixin.sogou.com" + linkUrl;
//        System.out.println("linkUrl:" + linkUrl);

        requestHeaders.put("Cookie", cookie);
        requestHeaders.put("Referer", url1);

        //第二次带cookie访问
        Map<String, String> resultUrl2 = sendGet(linkUrl, requestHeaders);
        String spliturlr = resultUrl2.get("responseContext");
//        System.out.println(spliturlr);
        String trueUrl = "";
        String[] spsstr = spliturlr.split(";");
        for (int i = 1; i < spsstr.length - 2; i++) {
            trueUrl = trueUrl + spsstr[i].substring(spsstr[i].indexOf("'") + 1, spsstr[i].lastIndexOf("'"));
        }
//        System.out.println("trueUrl:" + trueUrl);

        //第三次通过搜索的方式获取更多信息
        String title = "";
        try {
            title = URLEncoder.encode(article, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String t = "https://weixin.sogou.com/weixin?type=2&s_from=input&query=" + title;
        Map<String, String> resultUrl3 = sendGet(t, requestHeaders);
        String searchInfo = resultUrl3.get("responseContext");

        Document doc3 = Jsoup.parse(searchInfo);
        String pichref = "http:" + doc3.getElementById("sogou_vr_11002601_img_0").getElementsByTag("img").first().attr("src");
//        System.out.println(pichref);
        String picpath = getPictureAndUrl(pichref, System.currentTimeMillis() + "");

        String introduction = doc3.getElementById("sogou_vr_11002601_summary_0").text();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("picpath", picpath);
        jsonObject.put("introduction", introduction);
        jsonObject.put("article", article);
        jsonObject.put("trueurl", trueUrl);
        jsonArray.add(jsonObject);

        return jsonArray;
    }


    @Override
    public void startSplider() {
        Properties prop = loadProperties("config.properties");
        String allArticle = prop.getProperty("all_article");
        String[] wechatNames = allArticle.split(",");
        for (int i = 0; i < wechatNames.length; i++) {
            String wechatName = wechatNames[i];
            System.out.println(wechatName);
            JSONArray result = execute(wechatName);
            try {
                Thread.sleep(6 * 5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ("".equals(result)) {
                System.out.println(wechatName + "抓取失败");
                continue;
            }
            resultToMysql(wechatName, result);
        }
    }


    public static void main(String[] args) {
        SpliderWechat sw = new SpliderWechat();
        sw.startSplider();
    }
}