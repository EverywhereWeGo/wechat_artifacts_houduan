package a;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpURLConnectionHelper {

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

    public static String a(String urlParam, String requestType) {
        return "profile_history.js\":\"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/history/profile_history4576f8.js\",\"sougou/profile.js\":\"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/sougou/profile42f400.js\"};</script><script type=\"text/javascript\">window.__wxgspeeds={}; window.__wxgspeeds.moonloadtime=+new Date()</script><script  type=\"text/javascript\" src=\"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/moon42f400.js\"></script><script type=\"text/javascript\">        var biz = \"MzA3MjMzODExOA==\" || \"\";    var src = \"3\" ;     var ver = \"1\" ;     var timestamp = \"1559025173\" ;     var signature = \"FIycc4ngtmB2HLX2h1HqBu5oBTwmndp0itghW7lq9bgQHSy3grSKbcEDnNGkLtximArxmbLmasnaVOnBAnfvww==\" ;     var name=\"CoderJob\"||\"程序员求职面试\";        var msgList = {\"list\":[{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"只爱羽毛球的程序\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgTP9Dv*iOkgdAwE0sjNMzD-zADlQUY8JHIZb7A5ahSQCJ69FWSeE2e-4UtIoeQQjYJP-dkbLmVIuNa8UgffSM50=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/hbTNOSuicwls10NiaMEJFq1U8bwaZ0BzQZEKiaJFic3ohhUjf5SeSqcI1QljzxQrpCdPOEYn2PjNCc0iaCR7s8SMzkw/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"美团Java实习面试经历（拿到Offer）\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"https://blog.csdn.net/csuliyajin2012/article/details/49430659\",\"subtype\":9,\"title\":\"一位程序员妹纸讲述她是如何拿到美团offer的？\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558955880,\"fakeid\":\"3072338118\",\"id\":1000000236,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"Kenber\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgfP78jda1msTot6nXcRxXXnD1tm8*DPE5TqP-3xo6gNoFXCB3ZtbpZlR96C2y8O70UWq5xfYdxl9G6REKahfYj8=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/ruluqgBFV0a7eCmABUI31XfBmrfiabX3nib2MHkBNG2L8DRDaHtC6A3RhC2rHQ0QOwiaiaT0TtuYhsq4picMibzsoyHA/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"字节跳动 Android 高工面试记。\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"https://www.jianshu.com/p/73e539f0d6e4\",\"subtype\":9,\"title\":\"字节跳动 Android 高工面试记\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558696680,\"fakeid\":\"3072338118\",\"id\":1000000235,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"ITSTAR\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgR9zt0Iwqr5Yhmh8rSC5F8ipOdYFgn9zK10BBpty7aKadcgyke-kvPy6d2O535EyMqD269MbquQUT5UkJHbO7YU=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/0icfwEYjetmUSqt3NvBn6dLtMtdm9FfuRMdgnrLGYPicOz8y32OcDsa5iaDpuTeBMHHO6lAxEkOiceR3pEDeicky9QQ/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"在这个时代，你的工作会背叛你，你的行业会背叛你，你的专业会背叛你，唯一不能背叛你的，是你的认知和你的能力！\",\"duration\":0,\"fileid\":0,\"is_multi\":1,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[{\"audio_fileid\":0,\"author\":\"MageekChiu\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgR9zt0Iwqr5Yhmh8rSC5F8gI3CDjVvVToTmeXRBaH98dhMsxL5KmLpp**KVb9TcF6vqNnZ*WHi4ozAo-1QVRxpQ=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/vpWlcHcJUIBoIPWo5vlplvNOVtDy9ZThCxdr8icqia4DXicE9icfsC6yyeXr6OY9dkvHkVd0iaxWgcn5unm4RnzWLxQ/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"面试官说：基础不牢，走不了多长远的~\",\"duration\":0,\"fileid\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"play_url\":\"\",\"source_url\":\"\",\"title\":\"面试大厂回来，我狠补了一把算法和数据结构\"}],\"play_url\":\"\",\"source_url\":\"\",\"subtype\":9,\"title\":\"只能帮到这儿！精心整理面试、转型全套学习资料+源码！\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558585080,\"fakeid\":\"3072338118\",\"id\":1000000234,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgUuwuSwiUH3NhB8NWhHwfucKdFum9LwAN3Qd7AcPSaH1yhkVZi4XbVJKyWYcRbnb4yOI9RRw7hXWmVMdgBFbUBM=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/O0xtFGCiaLmvPOfXYTic3OBtUq1GFiatstgNfMxVpA4D8dxb6eVITWBkAYNrExCO1Q5LO3iabFupD2pxbibWYSgGXNQ/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"这真是一次愉快的面试\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"\",\"subtype\":9,\"title\":\"这真是一次愉快的面试\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558523880,\"fakeid\":\"3072338118\",\"id\":1000000233,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"念人远乡\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgTHidBV8khiiXw-jcxhRctEgVnpx-rohTyFVYI5Pkizafey3l9BdGgUeWFOBwjbAXEASi*WFBsiPvDuunbScGBI=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/ruluqgBFV0aoKT3ibL5zfbyPnDnuB5uAibQZibXdfyOR6TuDrEOPjYMtNYfhwTF6uiaxgWxkyuZelCSuOrQlWzdz3Q/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"Android 实习僧面试经历记录。\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"https://www.jianshu.com/p/3cd5ef51eed5\",\"subtype\":9,\"title\":\"Android 实习生面试经历记录\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558437480,\"fakeid\":\"3072338118\",\"id\":1000000232,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgbtSTAwGJmhIFS34oZh4uIZlHoMUCyBaKn32uk5GXdk7wIGDHZf6rSC-AztoX02VgjezV2EoYi0F1GcwVWJtfRc=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/KSFIvW4ibNQLXbNbvficiawl0VjEQuBnKHjeO8J5q4icH4ibeMZPQfltTqBVuJAbnE4uB1SpEMQTKH2gvMTwM4IECNg/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"程序员：年初拒了70k/月，30w股份，现公司上市，后悔！\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"\",\"subtype\":9,\"title\":\"程序员：年初拒了70k/月，30w股份，现公司上市，后悔！\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558351080,\"fakeid\":\"3072338118\",\"id\":1000000231,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgSjNePwUhjxe3gnGEPDWolkoYP-tnFIR9r3AE8U5nSpigzMJcwx1kmML1Z9*tfLfEQhFQDqG2aVmfNKLALkUliw=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/FAANicPx1jQZbJRefTwyicdJodAyCdmwicr67iaWuicD60YVDV57fnf0BQR1hy9FLsRw6RcNA26eEyphjClWiaB1fj2w/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"腾讯第一季度财报：公司每天赚9.5亿，养5.46万人\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"\",\"subtype\":9,\"title\":\"鹅厂员工平均月薪7万刷屏！公司每天赚9.5亿，养5.46万人\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558091880,\"fakeid\":\"3072338118\",\"id\":1000000230,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgR1V2jVUlZ79FeAPSETu8isV*gDtbvTbdUgG99SND58WHLnrJuRw0QT8HcTd7sw9iC0CuFw-nXFGnRFBM13YzLA=\",\"copyright_stat\":100,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/NGEiao2Vd8N6NovkR1VVgObuxcSTicDSLNGDTbLA9uKFwSPoJZtdzMVvqzzfEicdicsmiauUndccib5VTRdpuAEVOgBA/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"国家统计局发布了2018年平均工资主要数据，相关话题迅速冲上微博热搜。IT业平均工资水平连续第3年继续力压金融业。\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"\",\"subtype\":9,\"title\":\"官宣！ IT业平均工资高于金融业，连续三年第一！\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1558005480,\"fakeid\":\"3072338118\",\"id\":1000000229,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"陆小凤\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgSNtBTlA6ZtLLbilyEMEWUSbuEvORWn8yc58rQgMWR*vpAFV*4mycynCXyKZ3qkLS3sXfYR8*3jQD4TdNAmep3o=\",\"copyright_stat\":101,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/XHh0SksQZPNF22ickMOlDaYsDzcTQ9KrYNGo80xWYSLl5PVKA415xkVSRfrUB8uy0ByErIGYc8LN3ict5jHHFyhA/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"这是一篇万字长文，不仅有面经干货，也有学习心得和成长感悟。仅以此文，献给自己，以及各位在求职路上的的朋友们。不忘初心，方得始终。\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"https://mp.weixin.qq.com/mp/homepage?__biz=MzUyMDc5MTYxNA==&amp;hid=6&amp;sn=47babe76cc2405566ffb860cd2fb4e11#rd\",\"subtype\":9,\"title\":\"从Java小白到收获BAT等offer，分享我这两年的经验和感悟\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1557919080,\"fakeid\":\"3072338118\",\"id\":1000000228,\"status\":2,\"type\":49}},{\"app_msg_ext_info\":{\"audio_fileid\":0,\"author\":\"程序员小吴\",\"content\":\"\",\"content_url\":\"/s?timestamp=1559027905&amp;src=3&amp;ver=1&amp;signature=Q2KDH5IOoAh*T6F1*j7iwCU3u6l2NIEJ0JWjHw7ztlRPHPHJ0VaiWmhih0O-vECFT6iWJ-l8-aO15V1qf90cgRGdc-q*ZcBqHrmGQw4HUFCs-1sNnJACRj-M96GHwpGs2sgXvjXoNqvIJLve-2s8lZVvX4TE6aTVuokgouUzUYE=\",\"copyright_stat\":101,\"cover\":\"http://mmbiz.qpic.cn/mmbiz_jpg/D67peceibeIRdwqSFsETSBrhuiaWFmjgrs8JoZGgk1eNe9CAcqqSU3TbCz2kbOtkzic0wKhuicvjFnLuDsWf50kn4g/0?wx_fmt=jpeg\",\"del_flag\":1,\"digest\":\"双非普本拿到腾讯 offer 的经历~\",\"duration\":0,\"fileid\":0,\"is_multi\":0,\"item_show_type\":0,\"malicious_content_type\":0,\"malicious_title_reason_id\":0,\"multi_app_msg_item_list\":[],\"play_url\":\"\",\"source_url\":\"\",\"subtype\":9,\"title\":\"昨天，终于拿到了腾讯 offer\"},\"comm_msg_info\":{\"content\":\"\",\"datetime\":1557832680,\"fakeid\":\"3072338118\",\"id\":1000000227,\"status\":2,\"type\":49}}]};        seajs.use(\"sougou/profile.js\");</script>    </body></html>\n";

    }




    public static Map<String, String> getMap(String msgList) throws SQLException {
        JSONArray jsonArray = JSON.parseArray(msgList);
        Map<String, String> resultMap = new HashMap<String, String>();
        for (int i = 0; i < 3; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String datetime = jsonObject.getJSONObject("comm_msg_info").getString("datetime");
            System.out.println(datetime);
            resultMap.put("url1", jsonArray.toString());
        }
        return resultMap;

    }

    public static String map2Mysql(Map<String, String> resultMap) throws SQLException {
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        String sql = "INSERT INTO userinfo_wangchong "
                + "(id,username,password,nickname,account) "
                + "VALUES "
                + "(seq_userinfo_id_wangchong.NEXTVAL,?,'123','t','5000')";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0, count = 0; i < 100; i++) {
            ps.setString(1, "test" + i);
            ps.addBatch();
            if (count++ % 50 == 0) {
                ps.executeBatch();
                ps.clearBatch();
            }

        }

        int[] data2 = ps.executeBatch();
        conn.commit();
        System.out.println(data2.length);
        for (int i = 0; i < data2.length; i++) {
            System.out.println(data2[i]);
        }
        System.out.println("操作完毕");


    }


    public static void main(String[] args) throws SQLException {
        String urls[] = {
                "http://mp.weixin.qq.com/profile?src=3&timestamp=1559025173&ver=1&signature=FIycc4ngtmB2HLX2h1HqBu5oBTwmndp0itghW7lq9bgQHSy3grSKbcEDnNGkLtximArxmbLmasnaVOnBAnfvww==",
                "http://mp.weixin.qq.com/profile?src=3&timestamp=1559014028&ver=1&signature=0NPCb51SzGU07WDQFwcr2FA1T2Oh3K1oBt*e8ds1nQ*hp4Y*ipoAqQC4chmnMSls4FW0JgZWLX4IS8JHq7sGvw==",
                "http://mp.weixin.qq.com/profile?src=3&timestamp=1559028407&ver=1&signature=FIycc4ngtmB2HLX2h1HqBu5oBTwmndp0itghW7lq9bgQHSy3grSKbcEDnNGkLtxiB9jAdFP7fVjbgsV2yiXxIA=="
        };
        int a = (int) (new Date().getTime() % urls.length);
        System.out.println("a:" + a);
        String url = urls[a];
        String result = a(url, "POST");
        String msgList = result.substring(result.indexOf("var msgList = ") + 22, result.indexOf("seajs.use") - 10);
        Map<String, String> resultMap = getMap(msgList);
        map2Mysql(resultMap);

    }
}