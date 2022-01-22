package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class C01_TekrarTesti {


    public static void main(String[] args) {
//1-C01_TekrarTesti isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        //bu tarz direk click durumlarinda webelement olusturmadan direk yapilabilir
        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin


       // WebElement sayfaBasligiTest= driver.findElement(By.xpath("//a[@class='MV3Tnb']"));
        String actualTitel= driver.getTitle();
        String exceptedTitel="Google";

        if (actualTitel.contains(exceptedTitel)){
             System.out.println("PASS");
         }else{
             System.out.println("FAILD");
         }

        //5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaButton= driver.findElement(By.xpath("//input[@name='q']"));
        aramaButton.sendKeys("Nutella"+ Keys.ENTER);


        //6-Bulunan sonuc sayisini yazdirin

        WebElement bulunanSonuc= driver.findElement(By.id("result-stats"));
        System.out.println(bulunanSonuc.getText());


        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisi= bulunanSonuc.getText();
         String sonucKelimeleri[]=sonucSayisi.split(" ");
       String sonucNutellaSayisi=sonucKelimeleri[1];
       sonucNutellaSayisi=sonucNutellaSayisi.replace(".","");

       int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayisi);

       if (nutellaAramaSonucu>10000000){
           System.out.println("Nutella arama sonucu PASS");
       }else{
           System.out.println("Nutella arama sonucu FAILD");
       }

        //8-Sayfayi kapatin
        driver.close();



    }








}
