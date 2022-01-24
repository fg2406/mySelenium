package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {


   static WebDriver driver;

   @BeforeClass
   public static void BeforClass(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.manage().window().maximize();

   }
   @Test
   public  void  test01() {

       //) Open the browser
       //2) Enter the URL “http://practice.automationtesting.in/”
       driver.get("http://practice.automationtesting.in/");

       // 3) Click on Shop Menu
       driver.findElement(By.xpath("//a[text()='Shop']")).click();

       //4) Now click on Home menu button
       driver.findElement(By.xpath("//a[text()='Home']")).click();

       //5) Test whether the Home page has Three Sliders only
       //6) The Home page must contains only three sliders

       int expectedSliders=3;
       int actualSliders;

       List<WebElement> sliders= driver.findElements(By.className("row_inner_wrapper"));
       actualSliders=sliders.size();

       Assert.assertTrue(expectedSliders==actualSliders);
   }

  @AfterClass
    public  static  void afterClass(){
    driver.close();

  }



}
