package slackHomeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

         /*Question1
          1.https://www.youtube.com sayfasına gidin
          2.Title i consolda yazdirin
          3.Title “YouTube” a eşitse “correct title” yazdirin değilse “incorrect title yzdirin”
          4.Sayfayi kapatin
          5.Tum sayfalari kapatin
          6.Consola “Test completed” yazdirin */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","Resources/Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //1.
        driver.get("https://www.youtube.com/");
        //2.
        System.out.println(driver.getTitle());
        //3.
        String actualTitel=driver.getTitle();  //actual
        String isim="YouTube"; //expected result


        // actual result=expected result
        if (actualTitel.equals(isim)){
            System.out.println(" Correct Title");
        }else{
            System.out.println("incorrect title");
            System.out.println("actualTitel :"+driver.getTitle());
        }

        //4.
        driver.close();

        //5.
        driver.quit();

        //6.


        System.out.println("Test complete");



    }



}
