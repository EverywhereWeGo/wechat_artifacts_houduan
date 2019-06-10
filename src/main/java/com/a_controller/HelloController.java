package com.a_controller;

import com.b_util.DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class HelloController {

    @RequestMapping("/getList")
    public String index() {
        String resultstr = "";
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "Select * from article_info order by article_date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String article_jsonarray = rs.getString("article_jsonarray");
                article_jsonarray = article_jsonarray + ",";
                resultstr += article_jsonarray;
            }
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resultstr = resultstr.substring(0, resultstr.length() - 1);
        return "[" + resultstr + "]";

    }

}