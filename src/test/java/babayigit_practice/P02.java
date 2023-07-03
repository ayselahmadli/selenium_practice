package babayigit_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {

    public static void main(String[] args) throws InterruptedException {

//1-Driver oluşturalim
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
//2-Java class'imiza chnomedriver.exe i tanitalim
        WebDriver driver = new ChromeDriver();
//3-Driver'in tum ekranı kaplamasini saglayalim
        driver.manage().window().maximize();
//4-"https://www.otto.de” adresine gidelim
        driver.get("https://www.otto.de");
//5-Driverla sayfanın yuklenmesini 10.000 milisaniye boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.findElement(By.xpath("//button[@class='p_btn100--1st cookieBanner__button js_cookieBannerPermissionButton']")).click();
//6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String ottoTitle= driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);
        String ottoUrl= driver.getCurrentUrl();
        System.out.println("ottoUrl = " + ottoUrl);
//7-Title ve url inin "OTTO” kelimesinin içerip icermedigini kontrol edelim
        if (ottoTitle.contains("OTTO")&& ottoUrl.contains("OTTO")){
            System.out.println("Hem Title hem de Url OTTO kelimesi içeriyor.\n Test Başarılı");
        }else{
            System.out.println("En az biri OTTO kelimesi içermiyor\n Test Başarısız");
        }
//8-Ardindan "https://wisequarter.com/” adresine gidip
        driver.navigate().to("https://wisequarter.com/");
//9-Bu adresin basligini alalim ve "Quarter” kelimesini icenip icermedigini kontrol edelim
        String wiseTitle= driver.getTitle();
        System.out.println("wiseTitle = " + wiseTitle);
        if (wiseTitle.contains("Quarter")){
            System.out.println(" Wise Title Testi başarılı");
        }else{
            System.out.println("Wise Title testi başarısız");
        }
//10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(2500);
//11-Sayfayı yenileyelim
        driver.navigate().refresh();
        Thread.sleep(2500);
//12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        driver.navigate().forward();
        Thread.sleep(2500);

//13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.close();


    }
}

