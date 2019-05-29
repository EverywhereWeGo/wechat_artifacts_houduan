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
        HtmlPage page = webClient.getPage("https://weixin.sogou.com/weixin?type=1&s_from=input&query=%E7%A0%81%E5%86%9C%E6%9C%89%E9%81%93+&ie=utf8&_sug_=y&_sug_type_=&w=01019900&sut=2541&sst0=1559042129483&lkt=1%2C1559042128095%2C1559042128095");
        List a = page.getElementsByName("weui_msg_card");
        //获取子元素
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(1));
        }


    }
}