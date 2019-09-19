package com.c_SpliderWechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.basicUtil.a_DBUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static com.b_util.HttpClientHelper.*;
import static com.b_util.basicUtil.b_PropertiesLoadUtil.loadPropertiesGetSetciontoMap;

public class zghjjczz_Wechat implements Splider {
    @Override
    public void startSplider() {
        JSONArray ja = execute("http://123.127.175.45:8082/ajax/GwtWaterHandler.ashx");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(new Date());
        resultToMysql(dateStr, ja);
    }

    @Override
    public JSONArray execute(String urlname) {
        Map<String, String> requestHeaders = loadPropertiesGetSetciontoMap("config.properties", "requestheader");
        Map<String, String> params = new HashMap<>();
        params.put("Method", "SelectRealData");
        String resultUrl = sendPost(urlname, requestHeaders, params);

        JSONArray jsonArray = JSON.parseArray(resultUrl);

        return jsonArray;
    }

    @Override
    public void resultToMysql(String datatime, JSONArray htmlstr) {
        Connection conn = a_DBUtil.getConnection();
        try {
            Statement deleteStatement = conn.createStatement();
            conn.setAutoCommit(false);

            String sql = "INSERT INTO zghjjczz "
                    + "(collectiontime,siteName,dateTime,pH,DO,NH4,CODMn,TOC,level,attribute,status) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (Object i : htmlstr) {
                JSONObject jsonObject = (JSONObject) i;
                ps.setString(1, datatime);
                ps.setString(2, jsonObject.getString("siteName"));
                ps.setString(3, jsonObject.getString("dateTime"));
                ps.setString(4, jsonObject.getString("pH"));
                ps.setString(5, jsonObject.getString("DO"));
                ps.setString(6, jsonObject.getString("NH4"));
                ps.setString(7, jsonObject.getString("CODMn"));
                ps.setString(8, jsonObject.getString("TOC"));
                ps.setString(9, jsonObject.getString("level"));
                ps.setString(10, jsonObject.getString("attribute"));
                ps.setString(11, jsonObject.getString("status"));
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
        zghjjczz_Wechat a = new zghjjczz_Wechat();
        SimpleDateFormat sdf = null;
        Date startdate = null;
        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startdate = sdf.parse("2019-06-10 08:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                a.startSplider();
                System.out.println("等待下一次抓取");
            }
        }, startdate, 4 * 60 * 60 * 1000);
    }
}
