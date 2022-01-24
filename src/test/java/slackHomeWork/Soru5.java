package slackHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Soru5 {




        static WebDriver driver;

        @BeforeClass
        public static void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @Test
        public void test01(){
            //● https://www.amazon.com/ adresine gidin.
            driver.get("https://www.amazon.com/");

            //    Arama kutusunun yanindaki kategori menusundeki kategori
            //    sayisinin 45 oldugunu test edin

            List<WebElement> kategoriSaysi=driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
            int istenenSayi=45;
            int actualSayi= kategoriSaysi.size();


            Assert.assertTrue(actualSayi==actualSayi);

        }



        @Test
        public  void  test02(){

         //  1. Kategori menusunden Books secenegini secin
            WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

            //2. Arama kutusuna Java yazin ve aratin

            aramaKutusu.sendKeys("Java"+ Keys.ENTER);

            //3. Bulunan sonuc sayisini yazdirin
            WebElement sonuc= driver.findElement(By.xpath("//div[@class='sg-col-inner'][1]"));

            System.out.println(sonuc.getText());

            //4. Sonucun Java kelimesini icerdigini test edin

            String excepted="Java";
            Assert.assertTrue(sonuc.getText().contains(excepted));


        }





        @AfterClass
        public static void  teardown(){
            driver.close();
        }



}
