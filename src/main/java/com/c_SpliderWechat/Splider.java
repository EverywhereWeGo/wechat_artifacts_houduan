package com.c_SpliderWechat;

import com.alibaba.fastjson.JSONObject;

public interface Splider {
    void startSplider();
    JSONObject execute(String urlname);
    void resultToMysql(String datasource, JSONObject htmlstr);
}
