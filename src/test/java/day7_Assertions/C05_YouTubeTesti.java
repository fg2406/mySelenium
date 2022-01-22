package day7_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YouTubeTesti {

     //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //            3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //            ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
  static  WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }


    @Test
    public void titleTest(){
        //          ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertTrue(driver.getTitle().contains("YouTube"));
    }

    @Test
    public void imageTest(){
        //          ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]")).isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
    }

    @Test
    public void baslikDogrulamaTesti(){
        //          ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().contains("youtube"));
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    }
