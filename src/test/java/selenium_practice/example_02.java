package selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class example_02 {

    public static void main(String[] args) {

        // 1.Yeni bir class olusturalim (Homework)


        // 3.Sayfa URL’inin “trendyol” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        // 4.https://www.youtube.com/ sayfasina gidin.
        //Sayfa basliginin “youtube.com” icerdigini dogrulayin.
        // 5. Tekrar “trenyol” sayfasina donun
        // 7. Sayfayi yenileyin
        // 8. Sayfayi tam sayfa (maximize) yapin
        // 9.Browser’i kapatin

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2.ChromeDriver kullanarak, trendyol sayfasina gidin ve sayfa
        // basliginin (title) “trendyol” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.

        driver.get("www.trendyol.com");

        String expectedTitle ="trendyol";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAİLED" + actualTitle);
        }

        // 3.Sayfa URL’inin “trendyol” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.


    }
}
