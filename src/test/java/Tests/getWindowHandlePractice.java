package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class getWindowHandlePractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://phptravels.com/demo/");
        driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[2]" +
                                     "/div/div/div[1]/div/div/div/div/div/a")).click();

        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println(windowhandles);





    }
}
