package a;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.HttpException;

import java.io.IOException;
import java.util.List;

public class asdf {


    public static void main(String[] args) throws HttpException, IOException {

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage page = webClient.getPage("http://mp.weixin.qq.com/profile?src=3&timestamp=1559025173&ver=1&signature=FIycc4ngtmB2HLX2h1HqBu5oBTwmndp0itghW7lq9bgQHSy3grSKbcEDnNGkLtximArxmbLmasnaVOnBAnfvww==");
        List a = page.getElementsByName("weui_msg_card");
        //获取子元素
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(1));
        }


    }
}