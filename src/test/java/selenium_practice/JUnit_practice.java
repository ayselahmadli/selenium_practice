package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class JUnit_practice {
    WebDriver driver;

    @Test
    public void AmazonTesti() throws InterruptedException {

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // 2- arama kutusunu locate edelim
        WebElement aramaCubuguElementi = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));

        //3- “Samsung headphones” ile arama yapalim
        aramaCubuguElementi.sendKeys("Samsung headphones");

        // 4- Büyütec butonuna tıkla

        driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
        Thread.sleep(5000);


        //4- Bulunan sonuc sayisini yazdiralim
        WebElement result = driver.findElement(By.xpath("//h1[@class=\"a-size-base s-desktop-toolbar a-text-normal\"]"));
        System.out.println("Bulunan sonuç sayısı: " + result.getText());


          //  5- Ilk urunu tiklayalim

        WebElement firstProduct = driver.findElement(By.xpath("//img[@src=\"https://m.media-amazon.com/images/I/41KLRu1n2ZL._AC_UY218_.jpg\"]"));
        firstProduct.click();

        // Sayfadaki tüm başlıkları yazdırma
        java.util.List<WebElement> titles = driver.findElements(By.xpath("//h1[@class='a-size-large a-spacing-none']"));
        for (WebElement title : titles) {
            System.out.println("Başlık: " + title.getText());
        }


    }
    @Before
         public void setup(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

          @After
           public void theardown() throws InterruptedException {
           Thread.sleep(3000);
           driver.close();
}

}
