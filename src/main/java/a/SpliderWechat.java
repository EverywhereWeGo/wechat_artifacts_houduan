package a;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpliderWechat {

    public static String sendRequest(String urlParam, String requestType) {

        HttpURLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL(urlParam);
            //得到连接对象
            con = (HttpURLConnection) url.openConnection();
            //设置请求类型
            con.setRequestMethod(requestType);
            //设置请求需要返回的数据类型和字符集类型
            con.setRequestProperty("Content-Type", "application/json;charset=GBK");
            //允许写出
            con.setDoOutput(true);
            //允许读入
            con.setDoInput(true);
            //不使用缓存
            con.setUseCaches(false);
            //得到响应码
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("asdfasf");
                //得到响应流
                InputStream inputStream = con.getInputStream();
                //将响应流转换成字符串
                resultBuffer = new StringBuffer();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while ((line = buffer.readLine()) != null) {
                    resultBuffer.append(line);
                }
                return resultBuffer.toString();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static List<JSONObject> getInfoList(String msgList) throws SQLException {
        List<JSONObject> resultlist = new LinkedList<JSONObject>();
        JSONArray jsonArray = JSON.parseArray(msgList);
        Map<String, String> resultMap = new HashMap<String, String>();
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

    public static void listToMysql(String datasource, List<JSONObject> needlist) throws SQLException {
        Connection conn = DBUtil.getConnection();
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

        int[] data2 = ps.executeBatch();
        conn.commit();
        System.out.println(data2.length);
        for (int i = 0; i < data2.length; i++) {
            System.out.println(data2[i]);
        }
        System.out.println("入库完毕");
    }


    public static void main(String[] args) throws SQLException, URISyntaxException {
        String myneed[] = {
                "https://weixin.sogou.com/weixin?type=1&s_from=input&query=码农翻身&ie=utf8&_sug_=n&_sug_type_=&w=01019900&sut=6532&sst0=1559045167494&lkt=0%2C0%2C0",
                "https://weixin.sogou.com/weixin?type=1&s_from=input&query=程序员小灰&ie=utf8&_sug_=n&_sug_type_=&w=01019900&sut=6532&sst0=1559045167494&lkt=0%2C0%2C0"
        };
        for (int i = 0; i < myneed.length; i++) {
            String url = myneed[i];
            String result = SelnuimUtil.getNeedString(url);
            String msgList = result.substring(result.indexOf("var msgList = ") + 22, result.indexOf("seajs.use") - 11);
            List<JSONObject> needlist = getInfoList(msgList);
            listToMysql(String.valueOf(i), needlist);

        }

    }
}