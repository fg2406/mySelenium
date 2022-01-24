package slackHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {

    public static void main(String[] args) throws InterruptedException {

      // 1.  https://id.heroku.com/login sayfasina gidin
        //        2.  Bir mail adersi giriniz
        //        3.  Bir password giriniz
        //        4.  Login butonuna tiklayiniz
        //        5.  "There was a problem with your login." texti gorunur ise
        //        6.  "kayit yapilamadi" yazdiriniz
        //        8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        //        9.  Tum sayfalari kapatiniz





        System.setProperty("webdriver.chrome.driver", "C:\\Users\\melek\\Documents\\selenium dependencies\\drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://id.heroku.com/login");

        WebElement userElement = driver.findElement(By.cssSelector("input#email"));
        userElement.sendKeys("aliseleniumcu@gmail.com");

        WebElement userPass= driver.findElement(By.cssSelector("input#password"));
        userPass.sendKeys("test@123");

        WebElement loginBtn= driver.findElement(By.id("login"));
        loginBtn.click();
        WebElement expectedResult=driver.findElement(By.cssSelector("form[role='form'] > div[role='alert']"));

        if (expectedResult.isDisplayed()) {
            System.out.println("kayit yapilamadi");
        } else {
            System.out.println("kayit yapildi");

        }
        driver.close();
    }



}
