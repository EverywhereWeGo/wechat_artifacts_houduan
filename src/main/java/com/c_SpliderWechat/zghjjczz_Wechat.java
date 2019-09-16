package com.c_SpliderWechat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.b_util.basicUtil.a_DBUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.*;

import static com.b_util.HttpClientHelper.*;
import static com.b_util.basicUtil.b_PropertiesLoadUtil.loadProperties;
import static com.b_util.basicUtil.b_PropertiesLoadUtil.loadPropertiesGetSetciontoMap;

public class zghjjczz_Wechat {
    public void execute(String urlname) {
        String url1 = "http://123.127.175.45:8082/ajax/GwtWaterHandler.ashx";
        Map<String, String> requestHeaders = loadPropertiesGetSetciontoMap("config.properties", "requestheader");
        Map<String, String> params = new HashMap<>();
        params.put("Method", "SelectRealData");
        String resultUrl = sendPost(url1, requestHeaders, params);

        System.out.println(resultUrl);
    }


    public static void main(String[] args) {
        zghjjczz_Wechat sw = new zghjjczz_Wechat();
        sw.execute("");
    }

}
