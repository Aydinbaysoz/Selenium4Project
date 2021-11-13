package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandlingWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/au/");
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div[2]/div/div[1]/div/div[1]/div/a/span")).click();
        Thread.sleep(4000);
        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println(windowhandles);

        Iterator<String> iterator = windowhandles.iterator();
        String parentwindow = iterator.next();
        String childwindow = iterator.next();

        driver.switchTo().window(childwindow);

        driver.findElement(By.name("UserFirstName")).sendKeys("Aydin");
        driver.findElement(By.name("UserLastName")).sendKeys("Baysoz");
        driver.switchTo().window(parentwindow);

    }
}
