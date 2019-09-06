package com.c_SpliderWechat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.basicUtil.a_DBUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static com.b_util.HttpClientHelper.sendGet;
import static com.b_util.basicUtil.b_PropertiesLoadUtil.loadPropertiesGetSetciontoMap;

//定时更新收藏表中的url
public class SpliderCollection {
    //第三次通过搜索的方式获取更多信息
    public void execute(String url) {
        Connection conn = a_DBUtil.getConnection();
        try {
            Statement statement = conn.createStatement();

            String sql = "select * from collection order by collecttime desc limit 1";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            String title = "";
            while (rs.next()) {
                title = rs.getString("title");
            }

            String titleCode = URLEncoder.encode(title, "utf-8");

            Map<String, String> requestHeaders = loadPropertiesGetSetciontoMap("config.properties", "basic-requestheader");

            String t = "https://weixin.sogou.com/weixin?type=2&s_from=input&query=" + titleCode;
            Map<String, String> resultUrl3 = sendGet(t, requestHeaders);
            String searchInfo = resultUrl3.get("responseContext");

            Document doc3 = Jsoup.parse(searchInfo);
            String newurl = "" + doc3.getElementById("sogou_vr_11002601_box_0").getElementsByTag("h3").first().getElementsByTag("a").first().attr("data-share");
            System.out.println(newurl);
            sql = "update collection set url = \"" + newurl + "\" ,  collecttime = \"" + System.currentTimeMillis() + "\" where title=\"" + title + "\" ";
            System.out.println(sql);
            statement.executeUpdate(sql);

        } catch (SQLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        SpliderCollection a = new SpliderCollection();
        a.execute("");

    }
}
