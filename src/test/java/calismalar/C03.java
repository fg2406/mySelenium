package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class C03 {


    WebDriver driver;
   @Before
    public  void  setup(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }


  @Test
  public  void  test01(){
    // 1) Open the browser
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

      //7) Now click the image in the Arrivals
     //driver.findElement(By.xpath("//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']")).click();
      driver.findElement(By.xpath("(//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image'])[1]")).click();

      //8) Test whether it is navigating to next page where the user can add that book into his basket.


        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket

      WebElement nextPage=driver.findElement(By.xpath("//div[@itemprop='description']"));
      Assert.assertTrue(nextPage.isEnabled());
  }







   @After
    public  void  teardown(){
     //  driver.close();
   }

}
