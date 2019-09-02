package com.a_controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.basicUtil.a_DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class GetListController {

    @RequestMapping("/getList")
    public JSONArray index() {
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
                JSONObject obj = new JSONObject();
                obj.put("title", title);
                obj.put("trueurl", trueurl);
                obj.put("datasource", datasource);
                obj.put("picurl", picurl);
                array.add(obj);
            }
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    @RequestMapping("/favourate")
    public void index(String title, String source) {
    }

}