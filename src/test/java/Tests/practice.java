package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class practice {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.salesforce.com/au/");
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-nav salesforce-sans-regular ']")).click();
        Thread.sleep(4000);
        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println(windowhandles);

        Iterator<String> iterator = windowhandles.iterator();
        String parentWindow = iterator.next();
        System.out.println(parentWindow);
        String childWindow = iterator.next();
        System.out.println(childWindow);

        driver.switchTo().window(childWindow);

        driver.findElement(By.name("UserFirstName")).sendKeys("Aydin");
        Thread.sleep(4000);
        driver.findElement(By.name("UserLastName")).sendKeys("Baysoz");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='UserEmail-ZkRU']")).sendKeys("baysoz@gmail.com");
        Thread.sleep(2000);

        driver.switchTo().window(parentWindow);
        driver.close();




    }
}
