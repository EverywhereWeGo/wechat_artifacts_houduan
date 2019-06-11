package com.c_SpliderWechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.DBUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.*;
import java.util.Date;
import java.util.*;

import static com.b_util.HttpClientHelper.*;

public class SpliderWechat {
    public static void picToLocal(String result) {
        JSONArray jsonArray = JSON.parseArray(result);
        for (int j = 0; j < jsonArray.size(); j++) {
            String cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getString("cover");
            String id = jsonArray.getJSONObject(j).getJSONObject("comm_msg_info").getString("id");
            if (null == cover) {
                cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getJSONArray("multi_app_msg_item_list").getJSONObject(0).getString("cover");
            }
            sendGetToGetPicture(cover, null, id);
        }
        System.out.println("图片下载完毕");
    }


    public static void listToMysql(String datasource, List<JSONObject> needlist) {
        Connection conn = DBUtil.getConnection();
        try {
            Statement deleteStatement = conn.createStatement();
            String deleteSql = "DELETE FROM article_info WHERE article_source= \"" + datasource + "\"";
            System.out.println(deleteSql);
            deleteStatement.execute(deleteSql);


            conn.setAutoCommit(false);
            String sql = "INSERT INTO article_info "
                    + "(id,article_date,article_source,article_jsonarray,title) "
                    + "VALUES "
                    + "(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < needlist.size(); i++) {
                String id = "1";
                String article_date = needlist.get(i).getString("datetime");
                String article_source = datasource;
                String article_jsonarray = needlist.get(i).getString("jsonarray");
                String title = needlist.get(i).getString("title");
                ps.setString(1, id);
                ps.setString(2, article_date);
                ps.setString(3, article_source);
                ps.setString(4, article_jsonarray);
                ps.setString(5, title);
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

    public static List<JSONObject> getInfoList(String msgList) {
        List<JSONObject> resultlist = new LinkedList<JSONObject>();
        JSONArray jsonArray = JSON.parseArray(msgList);
        for (int i = 0; i < 3; i++) {
            JSONObject resultjson = new JSONObject();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String title = jsonObject.getJSONObject("app_msg_ext_info").getString("title");
            String datetime = jsonObject.getJSONObject("comm_msg_info").getString("datetime");
            resultjson.put("title", title);
            resultjson.put("datetime", datetime);
            resultjson.put("jsonarray", jsonObject.toString());
            resultlist.add(resultjson);
        }
        return resultlist;

    }

    public static List<String> getLasttimeArticleTitle() {
        List<String> alltitles = new LinkedList();
        Connection conn = DBUtil.getConnection();
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


    public static void resultStrToMysql(String datasource, String htmlstr) {
//        List<String> alltitles = getLasttimeArticleTitle();
        List<JSONObject> infolist = getInfoList(htmlstr);
        listToMysql(datasource, infolist);
    }

    public static String startThreeTimeAccess(String urlname) {
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
        String begstr = "<a target=\"_blank\" uigs=\"account_name_0\" href=\"";
        String endstr = "\"><em><!--red_beg-->" + urlname + "<!--red_end--></em></a>";
        String linkUrl = responseContext.substring(responseContext.indexOf(begstr) + begstr.length(), responseContext.indexOf(endstr)).replace("&amp;", "&");
        //这一段由前端js得出，做了验证，拼接了url
        int a = linkUrl.indexOf("url=");
        int c = linkUrl.indexOf("&k=");
        int b = (int) Math.random() * 100;
        if (-1 != a && -1 == c) {
            String check = linkUrl.substring(a + 4 + 26 + b, a + 4 + 26 + b + 1);
            linkUrl = linkUrl + "&k=" + b + "&h=" + check;
        }
        linkUrl = "https://weixin.sogou.com" + linkUrl;
        System.out.println("linkUrl：" + linkUrl);
        String cookie = resultUrl1.get("responseCookie");
        requestHeaders.put("Cookie", cookie);
        requestHeaders.put("Referer", url1);


        //第二次带cookie访问
        Map<String, String> resultUrl2 = sendGet(linkUrl, requestHeaders);
        String spliturlr = resultUrl2.get("responseContext");
        String trueUrl = "";
        String[] spsstr = spliturlr.split(";");
        for (int i = 1; i < spsstr.length - 2; i++) {
            trueUrl = trueUrl + spsstr[i].substring(spsstr[i].indexOf("'") + 1, spsstr[i].lastIndexOf("'"));
        }
        System.out.println("trueUrl:" + trueUrl);

        //第三次访问真正的url
        Map<String, String> resultUrl3 = sendGet(trueUrl, null);
        String htmlstr = resultUrl3.get("responseContext");
        String resultStr = "";
        if (htmlstr.contains("为了保护你的网络安全，请输入验证码")) {
            inputVerificationCode();
            //输入验证码之后再次访问
            resultUrl3 = sendGet(trueUrl, null);
            htmlstr = resultUrl3.get("responseContext");
            resultStr = htmlstr.substring(htmlstr.indexOf("var msgList = ") + 22, htmlstr.indexOf("seajs.use") - 11);
        } else {
            resultStr = htmlstr.substring(htmlstr.indexOf("var msgList = ") + 22, htmlstr.indexOf("seajs.use") - 11);
        }
        return resultStr;

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
            //等待一分钟输入
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


    public static void startSplider() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("/opt/wechat_article/houduan/config.properties"));
//            prop.load(new FileInputStream("C:\\Users\\Administrator\\Desktop\\我的代码\\wechat_artifacts_houtai\\src\\main\\resources\\config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String all_article = prop.getProperty("all_article");
        String wechatNames[] = all_article.split(",");
        for (int i = 0; i < wechatNames.length; i++) {
            String wechatName = wechatNames[i];
            System.out.println(wechatName);
            String result = startThreeTimeAccess(wechatName);
            try {
                //每次间隔10min
                Thread.sleep(6 * 5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ("".equals(result)) {
                System.out.println(wechatName + "抓取失败");
                continue;
            }
            resultStrToMysql(wechatName, result);
            picToLocal(result);

        }
    }
}