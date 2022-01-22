package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {

    static WebDriver driver;   //class seviyesinde birkez olusturduk
    static WebElement aramaKutusu;
    static WebElement sonucYazisiElementi;


    @Test
    public  void test01(){
   //arama kutusuna nutella yazip sonuc yazisinin nutella icerip icermedigini dogrulayin
    aramaKutusu.sendKeys("nutella"+ Keys.ENTER);


    }


  @Test
  public  void test02(){

}

    @Test
    public  void test03(){

    }


    @BeforeClass   //artik bir kez calisacak
    public static void ayarlariDuzenle(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        aramaKutusu=driver.findElement(By.id("ftwotabsearchtextbox"));
        //sonucYazisiElementi= driver.findElement();


    }


    @AfterClass   //artik birkez calisacak
    public static void ortaligiTopla(){
       // driver.close();

    }










}
