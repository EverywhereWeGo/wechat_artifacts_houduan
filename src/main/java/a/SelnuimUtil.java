package a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class SelnuimUtil {
    public static String getNeedString(String url) throws URISyntaxException, IOException {
        String resultStr = "";
        System.getProperties().setProperty("webdriver.chrome.driver", SelnuimUtil.class.getClass().getResource("/").toURI().getPath().substring(1) + "chromedriver.exe");
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(SelnuimUtil.class.getClass().getResource("/").toURI().getPath().substring(1) + "chromedriver.exe")).usingAnyFreePort().build();
        service.start();


        ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-infobars");
//        options.addArguments("start-maximized");
//        options.addArguments("headless");
//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver();
        driver.get(url);//打开指定的网站


        driver.findElement(By.xpath("//*[@id=\"sogou_vr_11002301_box_0\"]/div/div[2]/p[1]/a")).click();
//*[@id="sogou_vr_11002301_box_0"]
        String current_handle = driver.getWindowHandle();
        System.out.println(current_handle);
        Set<String> all_handles = driver.getWindowHandles();
        for (String o : all_handles) {
            if (o == current_handle) {
                continue;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver = driver.switchTo().window(o);
            resultStr = driver.findElement(By.xpath("/html/body/script[9]")).getAttribute("innerHTML");
        }
        driver.quit();//退出浏览器
//        service.stop();
        return resultStr;
    }

    public static void main(String[] args) throws SQLException, URISyntaxException, IOException {
        String a = SelnuimUtil.getNeedString("https://weixin.sogou.com/weixin?type=1&s_from=input&query=网络大数据&ie=utf8&_sug_=n&_sug_type_=&w=01019900&sut=6532&sst0=1559045167494&lkt=0%2C0%2C0");
        System.out.println(a);
    }

}



