package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class getWindowHandles {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.salesforce.com/au/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div/div/div[2]/div[1]" +
                "/div[1]/div[3]/div/div[2]/div/div[1]/div/div[1]/div/a")).click();

        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println(windowhandles);

        Iterator<String> iterator = windowhandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        System.out.println(childWindow);

        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@id='UserFirstName-4VUX']")).sendKeys("Aydin");
        driver.findElement(By.xpath("//input[@id='UserLastName-CC21']")).sendKeys("Baysoz");
        driver.switchTo().window(parentWindow);


    }
}
