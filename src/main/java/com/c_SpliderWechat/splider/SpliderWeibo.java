package com.c_SpliderWechat.splider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.c_SpliderWechat.Splider;

import java.util.Map;
import java.util.Properties;

import static com.b_util.basicUtil.a_PropertiesLoadUtil.loadProperties;
import static com.b_util.basicUtil.a_PropertiesLoadUtil.loadPropertiesGetSetciontoMap;
import static com.b_util.projectUtil.HttpClientHelper.*;

public class SpliderWeibo implements Splider {
    private Properties prop = loadProperties("config.properties");
    private String savePicpathPrefxi = prop.getProperty("savepicpath_prefxi");

    @Override
    public JSONArray execute(String url) {
        JSONArray jsonArray = new JSONArray();

        Map<String, String> requestHeaders = loadPropertiesGetSetciontoMap("config.properties", "weibo-requestheader");
        System.out.println(requestHeaders);

        Map<String, String> resultUrl1 = sendGet(url, requestHeaders);
        String responseContext = resultUrl1.get("responseContext");
        String cookie = resultUrl1.get("responseCookie");
        System.out.println(responseContext);


//        System.out.println(re);
        JSONObject jsonObject = JSON.parseObject(responseContext);
        JSONArray ja = jsonObject.getJSONObject("data").getJSONArray("statuses");
        String id;
        String text;
        for (int i = 0; i < ja.size(); i++) {
            id = ja.getJSONObject(i).getString("id");
            text = ja.getJSONObject(i).getString("text");
            System.out.println(id + ":" + text);
//            System.out.println(ja.getJSONObject(i));
        }


        return jsonArray;
    }

    @Override
    public void resultToMysql(String datasource, JSONArray htmlstr) {
    }

    @Override
    public void startSplider() {
//        JSONArray a = execute("https://m.weibo.cn/profile/info?uid=5035522040");
        JSONArray a = execute("https://m.weibo.cn/profile/info?uid=7136225579");
//        JSONArray a = execute("https://m.weibo.cn/profile/info?uid=3687300407");
//        JSONArray a = execute("https://m.weibo.cn/profile/info?uid=5556273965");


    }

    public static void main(String[] args) {
        Splider a = new SpliderWeibo();
        a.startSplider();

    }
}

