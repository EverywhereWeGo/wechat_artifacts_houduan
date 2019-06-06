package com.b_util;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpClientHelper {

    public static Map<String, String> sendGet(String url, Map<String, String> requestHeaders) {

        Map<String, String> responseMap = new HashMap<String, String>();
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod(url);
        if (!(null == requestHeaders)) {
            for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                getMethod.addRequestHeader(entry.getKey(), entry.getValue());
            }
        }
        Header[] asdf = getMethod.getRequestHeaders();
        for (int i = 0; i < asdf.length; i++) {
            System.out.println(asdf[i]);
        }

        try {
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            httpClient.executeMethod(getMethod);

            String cookiestr = "";
            Cookie[] cookies = httpClient.getState().getCookies();
            if (cookies.length == 0) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies.length; i++) {
                    cookiestr = cookiestr + cookies[i].toString() + ";";
                }
                cookiestr = cookiestr.substring(0, cookiestr.length() - 1);
            }

            String result = getMethod.getResponseBodyAsString();
            responseMap.put("responseCookie", cookiestr);
            responseMap.put("responseContext", result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMethod.releaseConnection();

        return responseMap;
    }

    public static String asdfasdfsfasdfa(String urlname) throws HttpException, IOException {
        String urls = URLEncoder.encode(urlname, "utf-8");
        System.out.println(urls);
        String url1 = "https://weixin.sogou.com/weixin?type=1&s_from=input&query=" + urls;
        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Connection", "keep-alive");
        requestHeaders.put("Host", "weixin.sogou.com");
        requestHeaders.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        requestHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");

        //第一次访问获取cookie以及url
        Map<String, String> resultUrl1 = sendGet(url1, requestHeaders);
        String responseContext = resultUrl1.get("responseContext");
        System.out.println(responseContext);
        String begstr = "<a target=\"_blank\" uigs=\"account_name_0\" href=\"";
        String endstr = "\"><em><!--red_beg-->" + urlname + "<!--red_end--></em></a>";
        String linkUrl = responseContext.substring(responseContext.indexOf(begstr) + begstr.length(), responseContext.indexOf(endstr)).replace("&amp;", "&");
        //这一段由前端js得出，做了验证，拼接了url
        int a = linkUrl.indexOf("url=");
        int c = linkUrl.indexOf("&k=");
        int b = (int) Math.random() * 100;
        if (-1 != a && -1 == c) {
            String check = linkUrl.substring(a + 4 + 26 + b, a + 4 + 26 + b + 1);
            linkUrl = linkUrl + "&k=" + b + "&h=" + check;
        }

        String cookie = resultUrl1.get("responseCookie");
        requestHeaders.put("Cookie", cookie);
        requestHeaders.put("Referer", "https://weixin.sogou.com/weixin?type=1&s_from=input&query=" + urls);
        //第二次带cookie访问
        Map<String, String> resultUrl2 = sendGet("https://weixin.sogou.com" + linkUrl, requestHeaders);
        String spliturlr = resultUrl2.get("responseContext");
        System.out.println(spliturlr);
        String trueUrl = "";
        String[] spsstr = spliturlr.split(";");
        for (int i = 1; i < spsstr.length - 2; i++) {
            System.out.println(i + ":" + spsstr[i]);
            trueUrl = trueUrl + spsstr[i].substring(spsstr[i].indexOf("'") + 1, spsstr[i].lastIndexOf("'"));
        }
        System.out.println(trueUrl);

        Map<String, String> resultUrl3 = sendGet(trueUrl, requestHeaders);
        String htmlstr = resultUrl3.get("responseContext");

        System.out.println("htmlstr:" + htmlstr);
        String resultStr = htmlstr.substring(htmlstr.indexOf("var msgList = ") + 22, htmlstr.indexOf("seajs.use") - 11);
        System.out.println("htmlstr:" + resultStr);
        return resultStr;

    }


    public static void main(String args[]) throws IOException {
        asdfasdfsfasdfa("网络大数据");
    }
}
