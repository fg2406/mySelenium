package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        WebElement userNameBox= driver.findElement(By.id("user-name"));
        userNameBox.sendKeys("standard_user");



        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordBox= driver.findElement(By.id("password"));
        passwordBox.sendKeys("secret_sauce");

        //4. Login tusuna basin
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
     WebElement ilkUrun=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
     String ilkUrunIsmi=ilkUrun.getText();
     ilkUrun.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrunIsmi=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        String sepettekiUrun= sepettekiUrunIsmi.getText();

        if (sepettekiUrun.equals(ilkUrunIsmi)){
            System.out.println("PASS");
        }else{
            System.out.println("FAILD");
        }
        //9. Sayfayi kapatin
        driver.close();
        //Collapse
    }

}
