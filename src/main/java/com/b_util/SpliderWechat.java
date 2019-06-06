package com.b_util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SpliderWechat {
    public static void picToLocal(String result) {
        JSONArray jsonArray = JSON.parseArray(result);
        for (int j = 0; j < jsonArray.size(); j++) {
            String cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getString("cover");
            String id = jsonArray.getJSONObject(j).getJSONObject("comm_msg_info").getString("id");
            String is_multi = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getString("is_multi");
            if ("1".equals(is_multi)) {
                cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getJSONArray("multi_app_msg_item_list").getJSONObject(0).getString("cover");
            }
            System.out.println("cover:" + cover);
            System.out.println("id:" + id);
            GetUrlPic.getpic(cover, id);
        }


    }


    public static List<JSONObject> getInfoList(String msgList) {
        List<JSONObject> resultlist = new LinkedList<JSONObject>();
        JSONArray jsonArray = JSON.parseArray(msgList);
        for (int i = 0; i < 3; i++) {
            JSONObject resultjson = new JSONObject();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String datetime = jsonObject.getJSONObject("comm_msg_info").getString("datetime");
            resultjson.put("datetime", datetime);
            resultjson.put("jsonarray", jsonObject.toString());
            resultlist.add(resultjson);
        }
        return resultlist;

    }

    public static void listToMysql(String datasource, List<JSONObject> needlist) {
        Connection conn = DBUtil.getConnection();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO jsonarray_data "
                    + "(id,article_date,article_source,article_jsonarray) "
                    + "VALUES "
                    + "(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < needlist.size(); i++) {
                String id = "1";
                String article_date = needlist.get(i).getString("datetime");
                String article_source = datasource;
                String article_jsonarray = needlist.get(i).getString("jsonarray");
                ps.setString(1, id);
                ps.setString(2, article_date);
                ps.setString(3, article_source);
                ps.setString(4, article_jsonarray);
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


//    public static void asdfasdfasd() {
//        String urls[] = {
//                "程序员小灰",
//                "码农翻身",
//                "码农有道"
//        };
//        System.out.println("urls.length:" + urls.length);
//        for (int i = 0; i < urls.length; i++) {
//            String url = urls[i];
//            String result = SelnuimUtil.getNeedString("https://weixin.sogou.com/weixin?type=1&s_from=input&query=" + url);
//            List<JSONObject> needlist = getInfoList(result);
//            listToMysql(String.valueOf(i), needlist);
//
//
//            JSONArray jsonArray = JSON.parseArray(result);
//            for (int j = 0; j < jsonArray.size(); j++) {
//                String cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getString("cover");
//                String id = jsonArray.getJSONObject(j).getJSONObject("comm_msg_info").getString("id");
//                String is_multi = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getString("is_multi");
//                if ("1".equals(is_multi)) {
//                    cover = jsonArray.getJSONObject(j).getJSONObject("app_msg_ext_info").getJSONArray("multi_app_msg_item_list").getJSONObject(0).getString("cover");
//                }
//                System.out.println("cover:" + cover);
//                System.out.println("id:" + id);
//                GetUrlPic.getpic(cover, id);
//            }
//        }
//    }

    public String asasdf() throws SQLException, URISyntaxException, IOException {
        String resultstr = "";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        String sql = "Select * from jsonarray_data";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String author = rs.getString(2);
            author = author + ",";
            resultstr += author;
        }
        resultstr = resultstr.substring(0, resultstr.length() - 1);
        System.out.println(resultstr);
        return "[" + resultstr + "]";

    }

//    public static void main(String args[]) {
//        String urls[] = {
//                "程序员小灰",
//                "码农翻身",
//                "码农有道"
//        };
//        System.out.println("urls.length:" + urls.length);
//        for (int i = 0; i < urls.length; i++) {
//            String url = urls[i];
//            String result = SelnuimUtil.getNeedString("https://weixin.sogou.com/weixin?type=1&s_from=input&query=" + url);
//            List<JSONObject> needlist = getInfoList(result);
//            listToMysql(String.valueOf(i), needlist);
//            picToLocal(result);
//        }
//
//
//    }

    public static void main(String args[]) throws IOException {
        String urls[] = {
                "程序员小灰",
                "码农翻身",
                "码农有道"
        };
        System.out.println("urls.length:" + urls.length);
        for (int i = 0; i < urls.length; i++) {
            String url = urls[i];
            String result = HttpClientHelper.asdfasdfsfasdfa(url);
            List<JSONObject> needlist = getInfoList(result);
            listToMysql(String.valueOf(i), needlist);
            picToLocal(result);
        }


    }

    public static void asdfasdfasd() throws IOException, InterruptedException {
        String urls[] = {
                "程序员小灰",
                "码农翻身",
                "码农有道"
        };
        System.out.println("urls.length:" + urls.length);
        for (int i = 0; i < urls.length; i++) {
            String url = urls[i];
            String result = HttpClientHelper.asdfasdfsfasdfa(url);
            List<JSONObject> needlist = getInfoList(result);
            listToMysql(String.valueOf(i), needlist);
            picToLocal(result);
            Thread.sleep(6000000);
        }
    }


}