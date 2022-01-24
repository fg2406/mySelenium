package slackHomeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    // /*
    //        1-driver olusturalim
    //        2-java class'imiza chromedriver.exe'yi tanitalim
    //        3-driver'in tum ekrani kaplamasini saglayalim
    //        4-https://github.com/ adresine gidelim
    //        5-Ardindan https://www.hepsiburada.com/ adrsine gidelim
    //        6-Title ve url console da yazdirin ve yine title ve url in "burada" kelimesini icerip icermedigini kontrol edelim
    //        7-Sonrasinda https://github.com/ adresine geri donelim ve  sayfayi yenileyelim
    //        8-Son adim olarak butun sayfalarimizi kapatmis olalim
    //     */
    public static void main(String[] args) throws InterruptedException {
        // System.setProperty:driver i tanitir
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        driver.get("https://www.hepsiburada.com/");
        String hbTitle= driver.getTitle();
        String hbUrl = driver.getCurrentUrl();

        System.out.println("hbUrl = " + hbUrl);
        System.out.println("hbTitle = " + hbTitle);

        if (hbTitle.contains("burada") || hbUrl.contains("burada")){
            System.out.println("burada kelimesi icerir");
        }
        else {
            System.out.println("burada kelimesi yoktur");
        }

        Thread.sleep(2000);

        //siteden kaynakli geri gitme bir seferde olmadigi icin boyle bir condition ile senaryo gerceklestirilebilir

        while (driver.getCurrentUrl().equals("https://www.hepsiburada.com/")) {
            driver.navigate().back();
        }
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.quit();

    }


}
