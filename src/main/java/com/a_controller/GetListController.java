package com.a_controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.basicUtil.a_DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class GetListController {

    @RequestMapping("/getList")
    public JSONArray getList() {
        JSONArray array = new JSONArray();
        try {
            Connection conn = a_DBUtil.getConnection();
            String sql = "Select * from article_info_v2 order by article_source";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String trueurl = rs.getString("trueurl");
                String datasource = rs.getString("article_source");
                String picurl = rs.getString("picurl");
                String abstrac = rs.getString("abstract");
                JSONObject obj = new JSONObject();
                obj.put("title", title);
                obj.put("trueurl", trueurl);
                obj.put("datasource", datasource);
                obj.put("picurl", picurl);
                obj.put("abstract", abstrac);
                array.add(obj);
            }
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    @RequestMapping("/collect")
    public void collect(String picnum) {
        System.out.println(picnum);

        Connection conn = a_DBUtil.getConnection();
        try {
            Statement statement = conn.createStatement();
            String sql = "select * from article_info_v2 where picurl=\"" + picnum + "\"";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            String title = "";
            String trueurl = "";
            String datasource = "";
            String picurl = "";
            String abstrac = "";
            while (rs.next()) {
                title = rs.getString("title");
                trueurl = rs.getString("trueurl");
                datasource = rs.getString("article_source");
                picurl = rs.getString("picurl");
                abstrac = rs.getString("abstract");
            }
            if (!"".equals(title)) {
                conn.setAutoCommit(false);
                String insertSql = "INSERT INTO collection (title,source,url,picurl,abstract) VALUES (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(insertSql);
                ps.setString(1, title);
                ps.setString(2, datasource);
                ps.setString(3, trueurl);
                ps.setString(4, picurl);
                ps.setString(5, abstrac);
                ps.addBatch();
                ps.executeBatch();
                conn.commit();
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
    }

    @RequestMapping("/getcollect")
    public JSONArray getCollect(String a) {
        System.out.println(a);
        JSONArray array = new JSONArray();
        try {
            Connection conn = a_DBUtil.getConnection();
            String sql = "Select * from collection order by collecttime desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String trueurl = rs.getString("url");
                String datasource = rs.getString("source");
                String picurl = rs.getString("picurl");
                String abstrac = rs.getString("abstract");
                JSONObject obj = new JSONObject();
                obj.put("title", title);
                obj.put("trueurl", trueurl);
                obj.put("datasource", datasource);
                obj.put("picurl", picurl);
                obj.put("abstract", abstrac);
                array.add(obj);
            }
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }
}