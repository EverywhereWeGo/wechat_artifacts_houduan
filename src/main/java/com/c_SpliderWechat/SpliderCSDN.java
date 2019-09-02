package com.c_SpliderWechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.basicUtil.a_DBUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.font.ImageGraphicAttribute;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.*;
import java.util.Date;
import java.util.*;

import static com.b_util.HttpClientHelper.*;
import static com.b_util.basicUtil.b_PropertiesLoadUtil.loadProperties;

public class SpliderCSDN implements Splider {
    private Properties prop = loadProperties("config.properties");
    private String savePicpathPrefxi = prop.getProperty("savepicpath_prefxi");

    public String getPictureAndUrl(String picsrc, int i) {
        String picurl = "img/csdn/" + i + ".jpg";
        sendGetToGetPicture(picsrc, null, savePicpathPrefxi + picurl);
        return picurl;
    }

    @Override
    public void startSplider() {
        JSONArray a = execute("");
        resultToMysql("CSDN", a);
    }

    @Override
    public JSONArray execute(String urlname) {
        JSONArray jsonArray = new JSONArray();
        String url = "https://www.csdn.net/";

        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Connection", "keep-alive");
        requestHeaders.put("Host", "weixin.sogou.com");
        requestHeaders.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        requestHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");

        Map<String, String> resultUrl1 = sendGet(url, requestHeaders);
        String responseContext = resultUrl1.get("responseContext");
        String cookie = resultUrl1.get("responseCookie");
//        System.out.println(responseContext);

        Document doc = Jsoup.parse(responseContext);
        Element ele = doc.getElementsByClass("company_list").first();
        Elements lis = ele.getElementsByTag("li");
        for (Element i : lis) {
            String picsrc = i.getElementsByClass("img_box").first().getElementsByTag("img").first().attr("src");
            String picurl = getPictureAndUrl(picsrc, i.siblingIndex());
            String title = i.getElementsByClass("content").first().getElementsByTag("a").first().attr("title");
            String href = i.getElementsByClass("content").first().getElementsByTag("a").first().attr("href");


            JSONObject jsonObject = new JSONObject();
            jsonObject.put("picurl", picurl);
            jsonObject.put("title", title);
            jsonObject.put("href", href);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        return jsonArray;
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
                    + "(article_source,title,trueurl,picurl) "
                    + "VALUES "
                    + "(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (Object i : htmlstr) {
                JSONObject jsonObject = (JSONObject) i;
                ps.setString(1, datasource);
                ps.setString(2, jsonObject.getString("title"));
                ps.setString(3, jsonObject.getString("href"));
                ps.setString(4, jsonObject.getString("picurl"));
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

    public static void main(String[] args) {
        Splider a = new SpliderCSDN();
        a.startSplider();
    }
}