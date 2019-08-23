package com.b_util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class HTMLHelper {
    public static void main(String args[]) {
        String a = "" +
                "<html>\n" +
                "<head>\n" +
                "    <link rel=\"shortcut icon\" href=\"//www.sogou.com/images/logo/new/favicon.ico?v=4\" type=\"image/x-icon\">\n" +
                "    <link href=\"//dlweb.sogoucdn.com/logo/images/2018/apple-touch-icon.png\" id=\"apple-touch-icon\" rel=\"apple-touch-icon-precomposed\"/>\n" +
                "    <link href=\"//www.sogou.com/sug/css/m3.min.v.7.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "    <link href=\"/new/pc/css/weixin-public-new.min.css?v=20190822\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "    \n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "    <meta http-equiv=\"Access-Control-Allow-Origin\" content=\"*\">\n" +
                "    <meta content=\"width=device-width,initial-scale=1.0\" id=\"vp\" name=\"viewport\">\n" +
                "    <title>码农翻身的相关微信公众号 – 搜狗微信搜索</title>\n" +
                "    \n" +
                "    <script>\n" +
                "        var sst = {h_s :(new Date()).getTime()};\n" +
                "        var newpage = 1;\n" +
                "        var passportUserId = \"\";\n" +
                "        var oldQuery = \"码农翻身\";\n" +
                "        var gbkQuery = \"%C2%EB%C5%A9%B7%AD%C9%ED\";\n" +
                "        var uuid = \"ee563dbf-f464-4c2b-b53b-e00f4b5f601b\";\n" +
                "        var keywords_string = \"码农翻身\";\n" +
                "        var sab = \"7\";\n" +
                "        var keywords = oldQuery.split(' ');\n" +
                "        var now = 1566548547132;\n" +
                "        var idc = \"sjs\";\n" +
                "        var clientIp = \"119.61.6.108\";\n" +
                "        var isIpad = false;\n" +
                "        //var article_anti_url = \"\";\n" +
                "    </script>\n" +
                "    <script>\n" +
                "        //以下为动态的全局 js，防止外部网站通过 window.opener.location 篡改我们的页面，以后不要通过 window.location 获取当前地址，只能用 document.location\n" +
                "        \n" +
                "    </script>\n" +
                "    <script src=\"/js/jquery-1.11.0.min.js\" charset=\"gbk\"></script>\n" +
                "    <script src=\"/new/pc/js/https_util.min.js?v=20180607\"></script>\n" +
                "    <script src=\"/js/lib/juicer-min.js\"></script>\n" +
                "    <script src=\"/new/weixin/js/common.min.js?v=20180607\"></script>\n" +
                "    <script src=\"/new/pc/js/common.min.js?v=20180607\"></script>\n" +
                "    \n" +
                "    <script>\n" +
                "        var uigs_para = {\n" +
                "            \"uigs_t\": \"1566548547132\",\n" +
                "            \"uigs_productid\": \"vs_web\",\n" +
                "            \"terminal\"      : \"web\",\n" +
                "            \"vstype\"        : \"weixin\",\n" +
                "            \"pagetype\"      : \"result\",\n" +
                "            \"channel\"       : \"result_account\",\n" +
                "            \"s_from\"        : \"input\",\n" +
                "            \"sourceid\"      : \"\",\n" +
                "            \"type\"          : \"weixin_search_pc\",\n" +
                "            \"uigs_cookie\"   : \"SUID,sct\",\n" +
                "            \"uuid\"          : \"ee563dbf-f464-4c2b-b53b-e00f4b5f601b\",\n" +
                "            \"query\"         : \"码农翻身\",\n" +
                "            \"weixintype\"    : \"1\",\n" +
                "            \"exp_status\"    : \"-1\",\n" +
                "            \"exp_id_list\"   : \"0_0\",\n" +
                "            \"wuid\"          : \"\",\n" +
                "            \"snuid\"         : \"771D216B1B1E8BD89DB0E9321CB33107\",\n" +
                "            \"rn\"            : 1,\n" +
                "            \"login\"         : passportUserId ? \"1\" : \"0\",\n" +
                "            \"uphint\"        : 0,\n" +
                "            \"bottomhint\"    : 0,\n" +
                "            \"page\"          : \"1\"\n" +
                "        };\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                "\n" +
                "<!--start header-->\n" +
                "<div class=\"header-box\">\n" +
                "    \n" +
                "    <div class=\"login-info\">\n" +
                "        <a id=\"top_login\" href=\"javascript:void(0);\" uigs=\"home_login_top\">登录</a>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"header\" id=\"scroll-header\">\n" +
                "        <a title=\"回到搜狗首页\" href=\"/\" name=\"scroll-nav\" class=\"logo\" uigs=\"home\"></a>\n" +
                "        <ul class=\"searchnav\" name=\"scroll-nav\">\n" +
                "            <li><a id=\"sogou_xinwen\" href=\"http://news.sogou.com/news?ie=utf8&p=40230447&query=码农翻身\" onclick=\"navBar(this,'query=');\" uigs=\"nav_xinwen\">新闻</a></li>\n" +
                "            <li><a id=\"sogou_wangye\" href=\"http://www.sogou.com/web?ie=utf8&query=码农翻身\" onclick=\"navBar(this,'query=');\" uigs=\"nav_wangye\">网页</a></li>\n" +
                "            <li class=\"cur\"><a href=\"javascript:void(0)\">微信</a></li>\n" +
                "            <li><a id=\"sogou_zhihu\" href=\"http://zhihu.sogou.com/zhihu?ie=utf8&p=73351201&query=码农翻身\" onclick=\"navBar(this,'query=')\" uigs=\"nav_zhihu\">知乎</a></li>\n" +
                "            <li><a id=\"sogou_tupian\" href=\"http://pic.sogou.com/pics?ie=utf8&p=40230504&query=码农翻身\" onclick=\"navBar(this,'query=')\" uigs=\"nav_tupian\">图片</a></li>\n" +
                "            <li><a id=\"sogou_shipin\" href=\"https://v.sogou.com/v?ie=utf8&p=40230608&query=码农翻身\" onclick=\"navBar(this,'query=')\" uigs=\"nav_shipin\">视频</a></li>\n" +
                "            <li><a id=\"sogou_mingyi\" href=\"https://www.sogou.com/web?m2web=mingyi.sogou.com&ie=utf8&query=码农翻身\" onclick=\"navBar(this,'query=')\" uigs=\"nav_mingyi\">明医</a></li>\n" +
                "            <li><a id=\"sogou_yingwen\" href=\"http://english.sogou.com/english?b_o_e=1&ie=utf8&query=码农翻身\" onclick=\"navBar(this,'query=')\" uigs=\"nav_yingwen\">英文</a></li>\n" +
                "            <li><a id=\"sogou_wenwen\" href=\"http://wenwen.sogou.com/s/?ch=weixinsearch&w=码农翻身\" data-index=\"http://wenwen.sogou.com/?ch=weixinsearch\" onclick=\"navBar(this,'w=')\" uigs=\"nav_wenwen\">问问</a></li>\n" +
                "            <li><a id=\"sogou_xueshu\" href=\"http://scholar.sogou.com/xueshu?ie=utf-8&query=码农翻身\" onclick=\"navBar(this,'query=')\" uigs=\"nav_xueshu\">学术</a></li>\n" +
                "            <li><a id=\"top_more\" href=\"http://www.sogou.com/docs/more.htm?v=1\" target=\"_blank\" uigs=\"nav_more\">更多>></a></li>\n" +
                "        </ul>\n" +
                "        \n" +
                "\n" +
                "<form name=\"searchForm\" action=\"/weixin\">\n" +
                "    <div class=\"querybox\">\n" +
                "        <div class=\"qborder\">\n" +
                "            <div class=\"qborder2\">\n" +
                "                <input type=\"hidden\" name=\"type\" value=\"1\"/>\n" +
                "                <input type=\"hidden\" name=\"s_from\" value=\"input\"/>\n" +
                "                <input type=\"text\" class=\"query\" name=\"query\" id=\"query\" ov=\"码农翻身\" value=\"码农翻身\" autocomplete=\"off\"/>\n" +
                "                \n" +
                "                    <input type=\"hidden\" name=\"ie\" value=\"utf8\"/>\n" +
                "                \n" +
                "                <a href=\"javascript:void(0)\" class=\"qreset2\" name=\"reset\" uigs=\"search_reset\"></a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <input type=\"button\" value=\"搜文章\" class=\"swz\" onclick=\"search(this,2)\" uigs=\"search_article\"/>\n" +
                "        <input type=\"button\" value=\"搜公众号\" class=\"swz2\" onclick=\"search(this,1)\" uigs=\"search_account\"/>\n" +
                "        <input type=\"hidden\" name=\"_sug_\" value=\"n\"/>\n" +
                "        <input type=\"hidden\" name=\"_sug_type_\" value=\"\"/>\n" +
                "    </div>\n" +
                "</form>\n" +
                "        \n" +
                "    </div>\n" +
                "</div>\n" +
                "<!--end header-->\n" +
                "    \n" +
                "    <div class=\"wrapper\" id=\"wrapper\">\n" +
                "        <div class=\"main-left\" id=\"main\">\n" +
                "            \n" +
                "<div class=\"dy-pop2 dy-pop5 float\" id=\"share_box\" style=\"display: none\">\n" +
                "    <a href=\"javascript:void(0)\" class=\"close\" data-except=\"1\" uigs=\"other_float_share_close\"></a>\n" +
                "    <div class=\"fxico-box\">\n" +
                "        <a href=\"javascript:void(0)\" class=\"sina\" data-except=\"1\" uigs=\"other_float_share_sina\"></a>\n" +
                "        <a href=\"javascript:void(0)\" class=\"renren\" target=\"_blank\" data-except=\"1\" uigs=\"other_float_share_renren\"></a>\n" +
                "        <a href=\"javascript:void(0)\" class=\"douban\" target=\"_blank\" data-except=\"1\" uigs=\"other_float_share_douban\"></a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div class=\"dy-pop2 dy-pop5 float\" id=\"erweima_box\" style=\"display: none\"></div>\n" +
                "<script type=\"text/template\" id=\"erweima_tpl\">\n" +
                "    <a href=\"javascript:void(0)\" class=\"close\" data-except=\"1\" uigs=\"other_float_weixin_close\"></a>\n" +
                "    <div class=\"fxico-box2\">微信扫一扫关注<br/><img width=\"104\" height=\"104\" src=\"${imgsrc}\"/></div>\n" +
                "</script>\n" +
                "            \n" +
                "\n" +
                "<script>\n" +
                "    //高级工具参数对象\n" +
                "    var toolParas = {\n" +
                "        tsn : '0',\n" +
                "        ft : '',\n" +
                "        et : '',\n" +
                "        interation : '',\n" +
                "        wxid : '',\n" +
                "        usip : ''\n" +
                "    };\n" +
                "    var from_tool = '0';\n" +
                "</script>\n" +
                "<div class=\"wx-topbox\">\n" +
                "    <div class=\"all-time\">\n" +
                "        <div class=\"all-time-y2 \">\n" +
                "            <div class=\"all-time-y all-time-y-v1\" id=\"text\">\n" +
                "                以下内容来自微信公众号\n" +
                "            </div>\n" +
                "            \n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div class=\"news-box\">\n" +
                "    \n" +
                "<ul class=\"news-list2\">\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_0\" d=\"oIWsFt3dwC6PSZmWkUr1X07NIaCg\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_0\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzhOKcd82GDnKhwwvZGYLy_Is7jkHOGhdqF9M1sC9CaJQUbdOjHZKa1Kcy8xzYmjbHil5elFs_ujLn-CSCnEDd58_7aKGUzyHyM9kG_6ijpC4kArLLktHp66UiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt3dwC6PSZmWkUr1X07NIaCg\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_0\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzhOKcd82GDnKhwwvZGYLy_Is7jkHOGhdqF9M1sC9CaJQUbdOjHZKa1Kcy8xzYmjbHil5elFs_ujLn-CSCnEDd58_7aKGUzyHyM9kG_6ijpC4kArLLktHp66UiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->码农翻身<!--red_end--></em></a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">coderising</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzhOKcd82GDnKhwwvZGYLy_Is7jkHOGhdqF9M1sC9CaJQUbdOjHZKa1Kcy8xzYmjbHil5elFs_ujLn-CSCnEDd58_7aKGUzyHyM9kG_6ijpC4kArLLktHp66UiiWOv1GPM&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img02.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3DtPk0b-feNhHGAnycbubttmQ8fopJ0aLaWS5TZg*0aqb*MvTKYyLdS8SXdhlPIhDDA2jKXzv3I5k4-aVUsas6m-kDKJcjzm-aSJPUh4sobxA%3D&appid=200580\" data-id=\"oIWsFt3dwC6PSZmWkUr1X07NIaCg\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=tPk0b-feNhHGAnycbubttmQ8fopJ0aLaWS5TZg*0aqb*MvTKYyLdS8SXdhlPIhDDA2jKXzv3I5k4-aVUsas6m-kDKJcjzm-aSJPUh4sobxA=',4,'oIWsFt3dwC6PSZmWkUr1X07NIaCg')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt3dwC6PSZmWkUr1X07NIaCg\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>工作15年的前IBM架构师分享好玩有趣的编程知识和职场的经验教训, 不容错过.</dd>\n" +
                "</dl>\n" +
                "<dl>\n" +
                "<dt>最近文章：</dt>\n" +
                "<dd>\n" +
                "<a target=\"_blank\" uigs=\"account_article_0\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6cwJThYulHEtVjXrGTiVgSwfUO-jSquQmN3udWWdQLw6Kv--4f7jF9lqXa8Fplpd9eO6jy0FxkgL1mzaUQek4ZQoPXS5IILKBC4suFzkuEBJ03nH8ZGY4qBn7HH3mno-KwSCq1DeHHX5cdYwClO7xOCqVvHCMISawVQM1KO0QQg2Q3BrYAtRtYfMJJVJytlK9k576Nz0h3WQynvvCWW5lfnGesbOAXI01C_iKxsmIZbLdrgozfSg6bw..&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\">华少、蓝盈莹都叫他老师,他的英语课5000元/小时,现在,你可以免...</a><span><script>document.write(timeConvert('1566520248'))</script></span>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_1\" d=\"oIWsFt0i-S7j0klcD34MkLpH7SoY\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_1\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzBu02gpFScxjUm-KPR66qBUf3t6bQ1CIQjDqrO1GfQ-UNqBfEbqEmk4-9qBjbT5zb8itD1NCICoyJNX3VV4KHhOkoU_fZvuymirlzUalvUYymXOJJ87wQ0eO00efWrWmm&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt0i-S7j0klcD34MkLpH7SoY\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_1\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzBu02gpFScxjUm-KPR66qBUf3t6bQ1CIQjDqrO1GfQ-UNqBfEbqEmk4-9qBjbT5zb8itD1NCICoyJNX3VV4KHhOkoU_fZvuymirlzUalvUYymXOJJ87wQ0eO00efWrWmm&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->码农<!--red_end--></em>要<em><!--red_beg-->翻身<!--red_end--></em></a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">ithumans</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzBu02gpFScxjUm-KPR66qBUf3t6bQ1CIQjDqrO1GfQ-UNqBfEbqEmk4-9qBjbT5zb8itD1NCICoyJNX3VV4KHhOkoU_fZvuymirlzUalvUYymXOJJ87wQ0eO00efWrWmm&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img03.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3DvQ2cyEBdPxygRzJDl0gv77Ob6VAkTBlM2XsPYFuVrjUDMpSh3ABDREfRncNaIgq*jIT*tLb8aY7-W7p5QEgf9mU1tXUiNqaGWIWGOgofRkk%3D&appid=200580\" data-id=\"oIWsFt0i-S7j0klcD34MkLpH7SoY\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=vQ2cyEBdPxygRzJDl0gv77Ob6VAkTBlM2XsPYFuVrjUDMpSh3ABDREfRncNaIgq*jIT*tLb8aY7-W7p5QEgf9mU1tXUiNqaGWIWGOgofRkk=',4,'oIWsFt0i-S7j0klcD34MkLpH7SoY')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt0i-S7j0klcD34MkLpH7SoY\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>技术分享,奇闻趣事分享</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_2\" d=\"oIWsFt6vmv3DlKzTq-7kkI_7FMBY\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_2\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzAE5ZvrNREof8-nM2JRTTy1vbZbHB1STv50zcvC7QkVqeY77qTlHPT0EkdgEua-UHme6-yisa6k4rYr2IaLHNyXJWOjrjNffolrjmhSAQXUaBswsSfOds26UiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt6vmv3DlKzTq-7kkI_7FMBY\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_2\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzAE5ZvrNREof8-nM2JRTTy1vbZbHB1STv50zcvC7QkVqeY77qTlHPT0EkdgEua-UHme6-yisa6k4rYr2IaLHNyXJWOjrjNffolrjmhSAQXUaBswsSfOds26UiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->翻身<!--red_end--></em>的<em><!--red_beg-->码农<!--red_end--></em></a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">gh_718887f7937d</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzAE5ZvrNREof8-nM2JRTTy1vbZbHB1STv50zcvC7QkVqeY77qTlHPT0EkdgEua-UHme6-yisa6k4rYr2IaLHNyXJWOjrjNffolrjmhSAQXUaBswsSfOds26UiiWOv1GPM&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img02.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3DbLC74voD6MPMMNiEGM9ORLyVUFQ6elcOViXzI41Qh57T*dkmATrA1WmoEQDP5aMWs03fAKAB9aAAumCKtvmw*JJLGyXGY81f-2pr8*lvGPQ%3D&appid=200580\" data-id=\"oIWsFt6vmv3DlKzTq-7kkI_7FMBY\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=bLC74voD6MPMMNiEGM9ORLyVUFQ6elcOViXzI41Qh57T*dkmATrA1WmoEQDP5aMWs03fAKAB9aAAumCKtvmw*JJLGyXGY81f-2pr8*lvGPQ=',4,'oIWsFt6vmv3DlKzTq-7kkI_7FMBY')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt6vmv3DlKzTq-7kkI_7FMBY\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>5年的<em><!--red_beg-->码农<!--red_end--></em>开发,现产品负责人,聊一聊<em><!--red_beg-->码农<!--red_end--></em>的成长与职场晋升</dd>\n" +
                "</dl>\n" +
                "<dl>\n" +
                "<dt>最近文章：</dt>\n" +
                "<dd>\n" +
                "<a target=\"_blank\" uigs=\"account_article_2\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6cwJThYulHEtVjXrGTiVgSwfUO-jSquQmN3udWWdQLw6Kv--4f7jF9lqXa8Fplpd9lvdQRjBilegdnurwZYNNdnIDsdBLU0IEEyKfhHWiXtj5ll9vWYoCG5pKLZgXTAchUaAruRsMs90-QxMHN4CjwMew0y2qM0YHKu2_NOgeY1h7XSGzKT3IH7LZLm7NaEvfisWVaq15ikPZ6SlhPfSWlPauaIJacqIizNDjmxkBPloHpHkoPMgL3A..&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\">开发APP不如做微信小程序</a><span><script>document.write(timeConvert('1565526634'))</script></span>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_3\" d=\"oIWsFt6X61oK5GSq1JtTtNVDbk2o\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_3\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzkG5E3GVZoUSY7-LLUncuSAFIJ7H5T4NtPjEqgzOMlrrk0ZSGnWStoVSbc5TuE8Q2rvJXEwdziA9QmGGRjmrM6vlSVHPmAP-E-COJRgIYlO4JElB2ilcx56UiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt6X61oK5GSq1JtTtNVDbk2o\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_3\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzkG5E3GVZoUSY7-LLUncuSAFIJ7H5T4NtPjEqgzOMlrrk0ZSGnWStoVSbc5TuE8Q2rvJXEwdziA9QmGGRjmrM6vlSVHPmAP-E-COJRgIYlO4JElB2ilcx56UiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->翻身<!--red_end--></em><em><!--red_beg-->码农<!--red_end--></em>把歌唱</a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">Joe-hello-world</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzkG5E3GVZoUSY7-LLUncuSAFIJ7H5T4NtPjEqgzOMlrrk0ZSGnWStoVSbc5TuE8Q2rvJXEwdziA9QmGGRjmrM6vlSVHPmAP-E-COJRgIYlO4JElB2ilcx56UiiWOv1GPM&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img02.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3DmcUq3GDlDtxLuP7h2lUd50ENPJ1A2AUYf4Gmx4MNm1LPSliQZC9EQRmRH7q37sJfBIKqZRlOetEiC6XHv8LAbsyxbpXKxqAA68fVz9EoJuU%3D&appid=200580\" data-id=\"oIWsFt6X61oK5GSq1JtTtNVDbk2o\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=mcUq3GDlDtxLuP7h2lUd50ENPJ1A2AUYf4Gmx4MNm1LPSliQZC9EQRmRH7q37sJfBIKqZRlOetEiC6XHv8LAbsyxbpXKxqAA68fVz9EoJuU=',4,'oIWsFt6X61oK5GSq1JtTtNVDbk2o')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt6X61oK5GSq1JtTtNVDbk2o\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>记录自己的学习路程、学习见解以及工作中的经验.</dd>\n" +
                "</dl>\n" +
                "<dl>\n" +
                "<dt>最近文章：</dt>\n" +
                "<dd>\n" +
                "<a target=\"_blank\" uigs=\"account_article_3\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6cwJThYulHEtVjXrGTiVgSwfUO-jSquQmN3udWWdQLw6Kv--4f7jF9lqXa8Fplpd9LGnyqqhPm9R447kZJMMNuwu0tJD13zV_x2j-eZ_UktfYkbtqU8lQkDQKmloQ0W54HepkeV1QlQRVBBpZ_nmiFudK6q4MtaIu0ly0XmLubg9O6YxlJbFwaxKHCtmuL0sWMqpyje60Wn-pIyQ0j-iDjaUjzNuV-CQixcDgDzjg_ZTm0CtGSSkZQQ..&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\">分享图片</a><span><script>document.write(timeConvert('1559260836'))</script></span>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_4\" d=\"oIWsFt3e9zXQf_dwVCJUwTCy1LAM\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_4\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzm_pC66zy-jp5_K7I3HdSESTS9ioFsN-DpuGdZqq6cvR7yaC_xYkS_6uqJiHgjA4fj-zmIKa-RbYwFc17UO_biJMbHFhOF33e4PsI_Sch7SEDEccgP5BcZG4OZCnxixtX&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt3e9zXQf_dwVCJUwTCy1LAM\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_4\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzm_pC66zy-jp5_K7I3HdSESTS9ioFsN-DpuGdZqq6cvR7yaC_xYkS_6uqJiHgjA4fj-zmIKa-RbYwFc17UO_biJMbHFhOF33e4PsI_Sch7SEDEccgP5BcZG4OZCnxixtX&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->码农翻身<!--red_end--></em>记</a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">xnp-666</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzm_pC66zy-jp5_K7I3HdSESTS9ioFsN-DpuGdZqq6cvR7yaC_xYkS_6uqJiHgjA4fj-zmIKa-RbYwFc17UO_biJMbHFhOF33e4PsI_Sch7SEDEccgP5BcZG4OZCnxixtX&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img01.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3D0dN1GFGrGb2xALTkOk0YHPCyy7uOHbwe*7LGtd7wXc8W3LbK0IC686lHRpIcQ*rwgBg6TP3RLgOMOuDWAkQhEvrFWKyKbkEmQ11JhVaQGlQ%3D&appid=200580\" data-id=\"oIWsFt3e9zXQf_dwVCJUwTCy1LAM\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=0dN1GFGrGb2xALTkOk0YHPCyy7uOHbwe*7LGtd7wXc8W3LbK0IC686lHRpIcQ*rwgBg6TP3RLgOMOuDWAkQhEvrFWKyKbkEmQ11JhVaQGlQ=',4,'oIWsFt3e9zXQf_dwVCJUwTCy1LAM')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt3e9zXQf_dwVCJUwTCy1LAM\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>工作不要996,生活要有669,会工作更要会生活!</dd>\n" +
                "</dl>\n" +
                "<dl>\n" +
                "<dt>最近文章：</dt>\n" +
                "<dd>\n" +
                "<a target=\"_blank\" uigs=\"account_article_4\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6cwJThYulHEtVjXrGTiVgSwfUO-jSquQmN3udWWdQLw6Kv--4f7jF9lqXa8Fplpd9hqUfBEv8Y6VIFpphnOu74gvObHmb0cOZ-UD4SJzOVCwBeWJBrD-Nj-64wMZOwPKwfucsD2WZXgYKakOAOn9qnWEjCEXIvPmRNq_D7MPNdRDzorEau_nVsJFQ3YGQ91uqMMKzxFb7MsvjH9L8bo6vsWz-a-abtwkkIjPyGqjjDHrYl_Q5RRZQjg..&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\">整个白河都在牵挂你,我们的姑娘 -- 金文君</a><span><script>document.write(timeConvert('1523945924'))</script></span>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_5\" d=\"oIWsFt1cHwPCQswZKBoQ-6qOH49o\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_5\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdz5qekqYrsGKo_duE1Bg__-3ABjv8v_jFeGPb-yuGns6cT0OH4MSQz5tm9hTsgGp7JQLY6Coe_2tjA1fGNnOwl9ZftzN458Y4L5AgdcIsVt0YKZ2qTvdF_lWRTpLLTNgHY&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt1cHwPCQswZKBoQ-6qOH49o\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_5\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdz5qekqYrsGKo_duE1Bg__-3ABjv8v_jFeGPb-yuGns6cT0OH4MSQz5tm9hTsgGp7JQLY6Coe_2tjA1fGNnOwl9ZftzN458Y4L5AgdcIsVt0YKZ2qTvdF_lWRTpLLTNgHY&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->码农翻身<!--red_end--></em>把歌唱</a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">vincent15618926519</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdz5qekqYrsGKo_duE1Bg__-3ABjv8v_jFeGPb-yuGns6cT0OH4MSQz5tm9hTsgGp7JQLY6Coe_2tjA1fGNnOwl9ZftzN458Y4L5AgdcIsVt0YKZ2qTvdF_lWRTpLLTNgHY&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img03.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3DZKs5gpr1mthsVElN8UEs96Ko5bUJTTTYJIVIO*Oi1HThEtOgs1J7subZui0CGjJJ-L*hunP4H78f5WDirxLnS0hKIf63NfI82mbFoIxndJM%3D&appid=200580\" data-id=\"oIWsFt1cHwPCQswZKBoQ-6qOH49o\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=ZKs5gpr1mthsVElN8UEs96Ko5bUJTTTYJIVIO*Oi1HThEtOgs1J7subZui0CGjJJ-L*hunP4H78f5WDirxLnS0hKIf63NfI82mbFoIxndJM=',4,'oIWsFt1cHwPCQswZKBoQ-6qOH49o')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt1cHwPCQswZKBoQ-6qOH49o\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>it开发</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_6\" d=\"oIWsFt2-kl1h3KIaCflqVWNSHxns\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_6\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzTVX417-zrjoToE9OvieFA3jC2NgyxHkP9ZuVdSnYR2gbv9NZ6DLz9fZp9A9PNzavPx8QmZcEG0XpailancNouSsOqZt6a8Qe7KwXunF-hfTFXAHHPqLEA-O00efWrWmm&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt2-kl1h3KIaCflqVWNSHxns\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_6\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzTVX417-zrjoToE9OvieFA3jC2NgyxHkP9ZuVdSnYR2gbv9NZ6DLz9fZp9A9PNzavPx8QmZcEG0XpailancNouSsOqZt6a8Qe7KwXunF-hfTFXAHHPqLEA-O00efWrWmm&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->码农翻身<!--red_end--></em>必经之路</a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">gh_5a305a50c793</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzTVX417-zrjoToE9OvieFA3jC2NgyxHkP9ZuVdSnYR2gbv9NZ6DLz9fZp9A9PNzavPx8QmZcEG0XpailancNouSsOqZt6a8Qe7KwXunF-hfTFXAHHPqLEA-O00efWrWmm&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img01.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3D-oOD9aBB1Syms6b-FN-npLoxML0glNvhIsZ6cARYH6wpgn4TszBW8YJqqCLapgLLZA1QhFXmfM7UTbTYi67PII4KLHv5kR0szZ6ChUyG7YM%3D&appid=200580\" data-id=\"oIWsFt2-kl1h3KIaCflqVWNSHxns\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=-oOD9aBB1Syms6b-FN-npLoxML0glNvhIsZ6cARYH6wpgn4TszBW8YJqqCLapgLLZA1QhFXmfM7UTbTYi67PII4KLHv5kR0szZ6ChUyG7YM=',4,'oIWsFt2-kl1h3KIaCflqVWNSHxns')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt2-kl1h3KIaCflqVWNSHxns\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>主要面向IT行业,分享计算机网络、操作体统、数据结构与算法分析、linux系统、c++等.也会不断学习分布式、负载均衡、大数据等技术.</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "\t\t<!-- a -->\n" +
                "\t\t<li id=\"sogou_vr_11002301_box_7\" d=\"oIWsFt5Ul2zVfnpSv2i48VQQurmM\">\n" +
                "<div class=\"gzh-box2\">\n" +
                "<div class=\"img-box\">\n" +
                "<a target=\"_blank\" uigs=\"account_image_7\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzoWGdCyzmJ-2vioBqQasNWPUTuWl5dtr4Tq01qFcSZpx_BehuY3vDyPXipvR-WJIzvPssdRGHqteXAnZwIZJgDwVdaTqLqJBZk0CcLoqinEp2FPToPw2sAaUiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><span></span><img src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt5Ul2zVfnpSv2i48VQQurmM\" onload=\"resizeImage(this,58,58)\" onerror=\"errorHeadImage(this)\"></a>\n" +
                "</div>\n" +
                "<div class=\"txt-box\">\n" +
                "<p class=\"tit\">\n" +
                "<a target=\"_blank\" uigs=\"account_name_7\" href=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzoWGdCyzmJ-2vioBqQasNWPUTuWl5dtr4Tq01qFcSZpx_BehuY3vDyPXipvR-WJIzvPssdRGHqteXAnZwIZJgDwVdaTqLqJBZk0CcLoqinEp2FPToPw2sAaUiiWOv1GPM&amp;type=1&amp;query=%E7%A0%81%E5%86%9C%E7%BF%BB%E8%BA%AB\"><em><!--red_beg-->码农翻身<!--red_end--></em>把猫撸</a>\n" +
                "</p>\n" +
                "<p class=\"info\">微信号：<label name=\"em_weixinhao\">gh_898cef0bbc21</label>\n" +
                "</p>\n" +
                "</div>\n" +
                "<div style=\"display:none;\" class=\"pop-tip\" data=\"/link?url=dn9a_-gY295K0Rci_xozVXfdMkSQTLW6EzDJysI4ql5MPrOUp16838dGRMI7NnPqDp_UBV4YQpRel-BzvDazdAwvDqyjOWdzoWGdCyzmJ-2vioBqQasNWPUTuWl5dtr4Tq01qFcSZpx_BehuY3vDyPXipvR-WJIzvPssdRGHqteXAnZwIZJgDwVdaTqLqJBZk0CcLoqinEp2FPToPw2sAaUiiWOv1GPM&amp;type=1&amp;query=码农翻身\">\n" +
                "<p>查阅公众号的历史文章，建议前往微信客户端</p>\n" +
                "<p>温馨提示：点击右侧二维码标识并用微信扫一扫即可快速传送哦~</p>\n" +
                "</div>\n" +
                "<div class=\"ew-pop\">\n" +
                "<a class=\"code\" href=\"javascript:void(0)\"><img height=\"24\" width=\"24\" src=\"/new/pc/images/ico_ewm.png\"></a><span style=\"display:none;\" class=\"pop\"><i></i>微信扫一扫关注<br>\n" +
                "<img height=\"104\" width=\"104\" src=\"https://img04.sogoucdn.com/v2/thumb?t=2&url=http%3A%2F%2Fmp.weixin.qq.com%2Frr%3Fsrc%3D3%26timestamp%3D1566548547%26ver%3D1%26signature%3Dq65GjH6AUC2dQKpEtFN-2zjRInLiePFIol8Ap7XuMcbignRfh8KgaTHFsPLSxPb54hsf*Ht4F8u5Suo0jnxzVFnJMBX9CVENL2hZf6bLXBI%3D&appid=200580\" data-id=\"oIWsFt5Ul2zVfnpSv2i48VQQurmM\" onerror=\"qrcodeShowError('http://mp.weixin.qq.com/rr?src=3&amp;timestamp=1566548547&amp;ver=1&amp;signature=q65GjH6AUC2dQKpEtFN-2zjRInLiePFIol8Ap7XuMcbignRfh8KgaTHFsPLSxPb54hsf*Ht4F8u5Suo0jnxzVFnJMBX9CVENL2hZf6bLXBI=',4,'oIWsFt5Ul2zVfnpSv2i48VQQurmM')\"><img height=\"32\" width=\"32\" class=\"shot-img\" src=\"//img01.sogoucdn.com/app/a/100520090/oIWsFt5Ul2zVfnpSv2i48VQQurmM\" onerror=\"errorHeadImage(this)\"></span>\n" +
                "</div>\n" +
                "</div>\n" +
                "<dl>\n" +
                "<dt>功能介绍：</dt>\n" +
                "<dd>养了一只猫,天天和我打架</dd>\n" +
                "</dl>\n" +
                "</li>\n" +
                "\n" +
                "\t\t<!-- z -->\n" +
                "\t\n" +
                "</ul>\n" +
                "    \n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "        </div>\n" +
                "        \n" +
                "            <script>var account_anti_url = \"/websearch/weixin/pc/anti_account.jsp?t=1566548547125&signature=ZZKB*VdkYKAu6l3A63WDWcBz9JJPx72w5MI6WkdV9ceakyxr11SV2eB0HmBp3aYxds4HMkf58srdfPA5U1PhDAPNQ4gZMzWKiixHDwpyEEhxgBom8Z90b3spljdK1JZ9JWYv2AHTUUNAl71rOBowcmVEGTejA*1BSKUeOeZce4YKZVqhOvNujntTFWfIyKeby4YHsrRrivFSdP45WYDGFFKPlCZQWG90N2yGFzirXdRD*3mY30EI5Pb0qYsK-Y0Gj-RaxpQj5W-Ojq*c0Q8qdTgwZ5exrqdkZy9tnzJTqTZrRNUerq6h0684AM*KhIQTyvkIlqiBsyX3E8L7K9lMcw==\";</script>\n" +
                "        \n" +
                "    </div>\n" +
                "    <div class=\"back-top\" style=\"display: none;\"><a href=\"javascript:void(0);\" uigs=\"other_float_back_top\"></a></div>\n" +
                "    \n" +
                "    <div class=\"bottom-form\">\n" +
                "        \n" +
                "\n" +
                "<form name=\"searchForm\" action=\"/weixin\">\n" +
                "    <div class=\"querybox\">\n" +
                "        <div class=\"qborder\">\n" +
                "            <div class=\"qborder2\">\n" +
                "                <input type=\"hidden\" name=\"type\" value=\"1\"/>\n" +
                "                <input type=\"hidden\" name=\"s_from\" value=\"input\"/>\n" +
                "                <input type=\"text\" class=\"query\" name=\"query\" id=\"query\" ov=\"码农翻身\" value=\"码农翻身\" autocomplete=\"off\"/>\n" +
                "                \n" +
                "                    <input type=\"hidden\" name=\"ie\" value=\"utf8\"/>\n" +
                "                \n" +
                "                <a href=\"javascript:void(0)\" class=\"qreset2\" name=\"reset\" uigs=\"search_reset\"></a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <input type=\"button\" value=\"搜文章\" class=\"swz\" onclick=\"search(this,2)\" uigs=\"search_article\"/>\n" +
                "        <input type=\"button\" value=\"搜公众号\" class=\"swz2\" onclick=\"search(this,1)\" uigs=\"search_account\"/>\n" +
                "        <input type=\"hidden\" name=\"_sug_\" value=\"n\"/>\n" +
                "        <input type=\"hidden\" name=\"_sug_type_\" value=\"\"/>\n" +
                "    </div>\n" +
                "</form>\n" +
                "    </div>\n" +
                "\n" +
                "<div class=\"footer-box\" id=\"s_footer\">\n" +
                "    <div class=\"footer\">\n" +
                "        <a id=\"sogou_webhelp\" href=\"http://help.sogou.com/\" target=\"_blank\" uigs=\"bottom_ssbz\">搜索帮助</a>&nbsp;<a href=\"http://fankui.help.sogou.com/index.php/web/web/index/type/4\" target=\"_blank\" uigs=\"bottom_yjfk\">意见反馈及投诉</a>&nbsp;<script src=\"/websearch/wexinurlenc_sogou_profile.jsp\"></script>&copy;&nbsp;2019&nbsp;SOGOU.COM&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"http://www.sogou.com/docs/terms.htm\" target=\"_blank\" uigs=\"bottom_mzsm\">免责声明</a>&nbsp;<a href=\"http://corp.sogou.com/private.html\" target=\"_blank\" uigs=\"bottom_yszc\">隐私政策</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "    \n" +
                "        <script src=\"/new/pc/js/account.min.js?v=20190822\"></script>\n" +
                "    \n" +
                "    <script>\n" +
                "        var WX_SUGG_PAGE_FROM=\"pcGzhSearch\";\n" +
                "        \n" +
                "        var SugPara = {\n" +
                "            \"bigsize\":true,\n" +
                "            \"enableSug\":true,\n" +
                "            \"sugType\":\"wxpub\",\n" +
                "            \"domain\":\"w.sugg.sogou.com\",\n" +
                "            \"productId\":\"web\",\n" +
                "            \"sugFormName\":\"sf\",\n" +
                "            \"submitId\":\"stb\",\n" +
                "            \"suggestRid\":\"01015002\",\n" +
                "            \"normalRid\":\"01019900\",\n" +
                "            \"oms\":1,\n" +
                "            \"nofixwidth\":1,\n" +
                "            \"useParent\":1\n" +
                "        };\n" +
                "        uigs_para.exp_id = \"null_0-null_1-null_2-null_3-null_4-null_5-null_6-null_7-\";\n" +
                "        uigs_para.exp_id = uigs_para.exp_id.substring(0, uigs_para.exp_id.length - 1);\n" +
                "    </script>\n" +
                "    <script src=\"/new/weixin/js/uigs.min.js?v=20180607\"></script>\n" +
                "    <script src=\"/new/pc/js/log.min.js?v=20170321\"></script>\n" +
                "    <script src=\"/new/pc/js/event.min.js?v=20190822\"></script>\n" +
                "    <script src=\"/new/pc/js/search.min.js?v=20161107\"></script>\n" +
                "    <script src=\"/new/pc/js/suggestion.min.js?v=20180607\"></script>\n" +
                "    <script src=\"/new/weixin/js/form.min.js?v=20170101\"></script>\n" +
                "    \n" +
                "\n" +
                "<script>\n" +
                "    (function(){$(\"a\").on(\"mousedown click contextmenu\",function(){var b=Math.floor(100*Math.random())+1,a=this.href.indexOf(\"url=\"),c=this.href.indexOf(\"&k=\");-1!==a&&-1===c&&(a=this.href.substr(a+4+parseInt(\"21\")+b,1),this.href+=\"&k=\"+b+\"&h=\"+a)})})();\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n" +
                "<!--1566548547132-->\n" +
                "<!--zly--><!--weixin-->";


//        Document document = DocumentHelper.parseText(a);
//        List<Element> composites = document.selectNodes("//*[@id=\"sogou_vr_11002301_box_0\"]/dl[2]/dd/a");
//        for (Element e : composites) {
//            System.out.println(e.getText());
//        }


        Document doc = Jsoup.parse(a);
        Element b = doc.getElementById("sogou_vr_11002301_box_0");
//        System.out.println("b:" + b);
        Elements c = b.getElementsByAttributeValue("uigs","account_image_0");
        System.out.println("c:" + c);
        for(Element e :c){
            String f = e.attr("href");
            System.out.println(f);
        }
    }

}
