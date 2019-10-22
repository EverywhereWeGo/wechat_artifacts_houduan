package com.c_Splider;

import com.alibaba.fastjson.JSONArray;

public interface Splider {
    void startSplider();

    JSONArray execute(String urlname);

    void resultToMysql(String datasource, JSONArray htmlstr);
}
