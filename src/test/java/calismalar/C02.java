package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {


    static WebDriver driver;
    @BeforeClass
    public static void beforClass(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

  @Test
  public  void  test01() {

        //1) Open the browser
      //2) Enter the URL “http://practice.automationtesting.in/”
      driver.get("http://practice.automationtesting.in/");

      //3) Click on Shop Menu
      driver.findElement(By.xpath("//a[text()='Shop']")).click();
      //4) Now click on Home menu button
      driver.findElement(By.xpath("//a[text()='Home']")).click();

      //5) Test whether the Home page has Three Arrivals only
      WebElement slider1=driver.findElement(By.xpath("//img[@alt='Shop Selenium Books']"));
      WebElement slider2=driver.findElement(By.xpath("//img[@src='//practice.automationtesting.in/wp-content/uploads/2017/01/HTML.png']"));
      WebElement slider3=driver.findElement(By.xpath("//img[@src='//practice.automationtesting.in/wp-content/uploads/2017/01/JavaScript.png']"));

      //6) The Home page must contains only three Arrivals
      List<WebElement> arrivals=driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link"));
      int expectedArrival=3;
      int actualArrival= arrivals.size();


      Assert.assertTrue(expectedArrival==actualArrival);

  }

    @AfterClass
    public static void afterClass(){
        driver.close();
    }

}
