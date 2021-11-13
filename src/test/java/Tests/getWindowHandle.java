package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class getWindowHandle {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://phptravels.com/demo/");
        driver.manage().deleteAllCookies();


        driver.findElement(By.xpath("/html/body/header/div/nav/a[6]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);

        driver.findElement(By.name("username")).sendKeys("baysozaydin@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567");
        Thread.sleep(4000);
        driver.switchTo().window(parentWindow);

    }
}
