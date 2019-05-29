package a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class SelnuimUtil {
    public static String getNeedString(String url) throws URISyntaxException {
        String resultStr = "";
        System.setProperty("webdriver.chrome.driver", DBUtil.class.getClass().getResource("/").toURI().getPath().substring(1) + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);//打开指定的网站

        driver.findElement(By.xpath("//*[@id=\"sogou_vr_11002301_box_0\"]/div/div[2]/p[1]/a")).click();

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
        return resultStr;
    }
}



