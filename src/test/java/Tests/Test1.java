package Tests;

import apple.laf.JRSUIConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static apple.laf.JRSUIConstants.*;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       // driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://www.amazon.com");
        driver.get("https://www.hku.edu.tr");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().back();
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        String originalWindow = driver.getWindowHandle();
        driver.switchTo().window(originalWindow);

       // driver.switchTo().newWindow(WindowType.WINDOW);
        // driver.switchTo().newWindow(WindowType.TAB);




        driver.quit();


    }
}
