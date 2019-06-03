package b_util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;


public class SelnuimUtil {
    public static String getNeedString(String url) {
        String resultStr = "";
        try {
            System.getProperties().setProperty("webdriver.chrome.driver", SelnuimUtil.class.getClass().getResource("/").toURI().getPath().substring(1) + "chromedriver.exe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-infobars");
//        options.addArguments("start-maximized");
//        options.addArguments("headless");
//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver();
        for (String availableLogType : driver.manage().logs().getAvailableLogTypes()) {
            System.out.println(availableLogType);
        }
        driver.get(url);//打开指定的网站


        driver.findElement(By.xpath("//*[@id=\"sogou_vr_11002301_box_0\"]/div/div[2]/p[1]/a")).click();
        String current_handle = driver.getWindowHandle();
        Set<String> all_handles = driver.getWindowHandles();
        for (String o : all_handles) {
            if (o == current_handle) {
                continue;
            }
            try {
                Thread.sleep(5000);
                driver.switchTo().window(o);
                String htmlstr = driver.findElement(By.xpath("/html/body/script[9]")).getAttribute("textContent");
                System.out.println("htmlstr:" + htmlstr);
                resultStr = htmlstr.substring(htmlstr.indexOf("var msgList = ") + 22, htmlstr.indexOf("seajs.use") - 11);
            } catch (InterruptedException | NoSuchElementException | StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }


//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            WebDriverWait wait = new WebDriverWait(driver, 200);
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/script[9]")));

        }
        driver.quit();//退出浏览器
        return resultStr;
    }


    public static void main(String[] args) throws SQLException, URISyntaxException, IOException, InterruptedException {
        String a = SelnuimUtil.getNeedString("https://weixin.sogou.com/weixin?type=1&s_from=input&query=网络大数据");
        System.out.println(a);


    }
}



