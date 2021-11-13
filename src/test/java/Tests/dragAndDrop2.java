package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class dragAndDrop2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //Capitals
       WebElement copenhagen = driver.findElement(By.id("box4"));
       WebElement washington = driver.findElement(By.id("box3"));
       WebElement stockholm  = driver.findElement(By.id("box2"));
       WebElement   oslo     = driver.findElement(By.id("box1"));
       WebElement   madrid   = driver.findElement(By.id("box7"));
       WebElement    rome    = driver.findElement(By.id("box6"));
       WebElement  seoul     = driver.findElement(By.id("box5"));

       //Countries
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement unitedStates = driver.findElement(By.id("box103"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement southKorea = driver.findElement(By.id("box105"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(copenhagen,denmark).build().perform();
        actions.dragAndDrop(washington,unitedStates).build().perform();
        actions.dragAndDrop(stockholm,sweden).build().perform();
        actions.dragAndDrop(oslo,norway).build().perform();
        actions.dragAndDrop(madrid,spain).build().perform();
        actions.dragAndDrop(rome,italy).build().perform();
        actions.dragAndDrop(seoul,southKorea).build().perform();






    }
}
