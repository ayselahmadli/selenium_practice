package selenium_practice;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilites.TestBase;

import java.util.List;

public class test_01 extends TestBase {



    @Test
    public void test01() {

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa
        // basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");

        Assert.assertTrue(driver.getTitle().contains("Facebook"));
        System.out.println(driver.getTitle());

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.

        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        System.out.println(driver.getCurrentUrl());


        // 4.https://www.walmart.com/ sayfasina gidin.
        //Sayfa basliginin “Walmart.com” icerdigini dogrulayi

        driver.navigate().to("https://www.walmart.com");
        Assert.assertTrue(driver.getTitle().contains("Walmart.com"));
        System.out.println(driver.getTitle());

        driver.navigate().back();
        bekle(3);

        driver.navigate().refresh();
    }

    @Test
    public void test02() {

        // Amazan anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Arama cubuguna Nutella yazdirip aratin
        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);


        // Arama sonuclarinin Nutella icerdigini test edin

        WebElement aramaSonuclari = driver.findElement(By.xpath("//*[@class=\"a-size-base s-desktop-toolbar a-text-normal\"]"));
        String expectedSonuc = "Nutella";
        String actualSonuc = aramaSonuclari.getText();

        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
        System.out.println("PASSED");
    }

         @Test
        public void test03(){

            // Amazon sayfasina gidelim. https://www.amazon.com/
             driver.get("https://www.amazon.com");

            //  4. Sayfa basligini(title) yazdirin
             //  5. Sayfa basliginin “Amazon” icerdigini test edin
             Assert.assertTrue(driver.getTitle().contains("Amazon"));
             System.out.println(driver.getTitle());

             //  6. Sayfa adresini(url) yazdirin
             System.out.println(driver.getCurrentUrl());

             //  7. Sayfa url’inin “amazon” icerdigini test edin.
             Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

           //  8. Sayfa handle degerini yazdirin
             driver.getWindowHandle();

            // 9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
             String expectedHTML = "alisveris";
             String actualHTML = driver.getPageSource();

             if (actualHTML.contains(expectedHTML)){
                 System.out.println("Test PASSED");
             }else{
                 System.out.println("Test FAİLED");
             }
    }

    @Test

    public void test04() {

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        bekle(3);
        driver.manage().window().maximize();

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin

        Point point = new Point(200,200);
        Dimension dimension = new Dimension(800,600);

        Point actualPosition = driver.manage().window().getPosition();
        Dimension actualSize = driver.manage().window().getSize();

        if(actualPosition.equals(point) && actualSize.equals(dimension)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAİLED"); 
        }


    }

    @Test
    public void test05() {

        //Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com/");
       String expectedTitle = "Youtube";
       String actualTitle = driver.getTitle();

       if(expectedTitle.contains(actualTitle)){
           System.out.println("Test PASSED");
       }else{
           System.out.println("Test FAİLED");
       }

        //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));
        System.out.println(driver.getCurrentUrl());
        bekle(2);

        //Daha sonra Amazon sayfasina gidin https://www.amazon.com/

        driver.navigate().to("https://www.amazon.com");
        bekle(2);

        //Youtube sayfasina geri donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();
        bekle(3);

        //Amazon sayfasina donun
        driver.navigate().back();

        //Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        String expectedBaslik = "Amazon";
        String actualBaslik = driver.getTitle();

        if(expectedBaslik.contains(actualBaslik)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAİLED");
        }

        //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String expectedUrl = "Amazon";
        String actualUrl = driver.getTitle();

        if(expectedUrl.contains(actualUrl)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAİLED");
        }
        bekle(3);
    }

    @Test
    public void test06(){

        //https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //Category bolumundeki elementleri locate edin
        WebElement woman = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]"));
        WebElement men = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]"));
        WebElement kids = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[3]"));

        //Category bolumunde 3 element oldugunu test edin
        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"accordian\"]"));
        int expectedElementSayisi = 3;
        int actualElementSayisi = elementList.size();

        if (actualElementSayisi == expectedElementSayisi){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAİLED");
        }
        //Category isimlerini yazdirin
        for (WebElement eachElement:elementList
        ) {

            System.out.println(eachElement.getText());
        }




    }

    @Test
    public void test07(){

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");


        //2 ) Berlin’i  3 farkli relative locator ile locate edin
        WebElement NYC = driver.findElement(By.xpath("//*[@id=\"pid3_thumb\"]"));
        WebElement boston = driver.findElement(By.xpath("//*[@id=\"pid6_thumb\"]"));
        WebElement bayArea = driver.findElement(By.xpath("//*[@id=\"pid8_thumb\"]"));
        WebElement sailor = driver.findElement(By.xpath("//*[@id=\"pid11_thumb\"]"));

        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.id("pid7_thumb")).below(NYC).toRightOf(boston));




        //3 ) Relative locator’larin dogru calistigini test edin

        String expectedIdValue= "//*[@id=\"pid7_thumb";
        String actualIdValue1 = berlin1.getAttribute("id");

        if (expectedIdValue.equals(actualIdValue1)){
            System.out.println("1. Relative Locator Testi PASSED");
        }else {
            System.out.println("1. Relative Locator Testi FAILED");
        }

    }

   @Test
    public void test08() {

       //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
       driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
       bekle(3);

       //Add Element butonuna basin
       driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
       bekle(3);

       //Delete butonu’nun gorunur oldugunu test edin
       WebElement deleteButonu = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
       Assert.assertTrue(deleteButonu.isDisplayed());

       //Delete tusuna basin
       deleteButonu.click();
       bekle(3);

       //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
       WebElement addRemoveYazi = driver.findElement(By.xpath("//*[@id=\"content\"]/h3"));
       Assert.assertTrue(addRemoveYazi.isDisplayed());

   }
     @Test
      public void test09() {

        //2- https://www.amazon.com/ adresine gidin
       driver.get("https://www.amazon.com/");

          // 3- Browseri tam sayfa yapin
         //driver.manage().window().fullscreen();
         //  4- Sayfayi “refresh” yapin
         //driver.navigate().refresh();
         // 5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin

       Assert.assertTrue(driver.getTitle().contains("Spend less"));
       System.out.println(driver.getTitle());
       bekle(5);


       // 6- Gift Cards sekmesine basin
         driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
          bekle(3);

             // 7- Birthday butonuna basin
      driver.findElement(By.xpath("//a[@aria-label=\"Birthday\"]")).click();
      bekle(3);

             //8-  Best Seller bolumunden ilk urunu tiklayin
         driver.findElement(By.xpath("//*[@id=\"acs-product-block-0\"]")).click();
         bekle(3);

         //9-  Gift card details’den 25 $’i  secin
         WebElement urunUcreti =driver.findElement(By.xpath("//*[@id=\"a-autoid-28\"]"));

         //10-Urun ucretinin 25$ oldugunu test edin
         String expectedUrunUcreti = "$25";
         String actualUrunUcreti = urunUcreti.getText();
         Assert.assertEquals(expectedUrunUcreti,actualUrunUcreti);

   }
   @Test
    public void test11(){
       //1- https://www.amazon.com/ sayfasına gidin.
       driver.get("https://www.amazon.com/");

       //2- Arama kutusuna “city bike” yazip aratin
       WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaCubugu.sendKeys("city bike" + Keys.ENTER);

       //3- Görüntülenen sonuçların sayısını yazdırın
       String result = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1")).getText();
       String resultSayi = result.substring(0,35);
       //String resultSayi = result.substring(0,result.indexOf(" "));
       System.out.println(resultSayi);

       //4- Listeden ilk urunun resmine tıklayın.
       WebElement urun =driver.findElement(By.xpath("//div[@data-component-type='s-search-result']//img"));
       urun.click();
       bekle(3);



   }

   @Test
    public void test12(){

       //https://www.amazon.com/ sayfasina gidelim
       driver.get("https://www.amazon.com/");

       //arama kutusunu locate edelim
       //“Samsung headphones” ile arama yapalim
       WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaCubugu.sendKeys("Samsung headphones" + Keys.ENTER);


       //Bulunan sonuc sayisini yazdiralim
       String sonuc = driver.findElement(By.xpath("//*[@id=\"search\"]/span")).getText();
       String sonucSayi = sonuc.substring(0,44);
       System.out.println(sonucSayi);

       //Ilk urunu tiklayalim
       WebElement ilkUrun = driver.findElement(By.xpath("//div[@class=\"a-section aok-relative s-image-fixed-height\"][1]"));
       ilkUrun.click();
       bekle(3);
   }

   @Test
    public void test13(){

              //1. http://zero.webappsecurity.com sayfasina gidin
              driver.get("http://zero.webappsecurity.com");

             //2. Signin buttonuna tiklayin
             WebElement element = driver.findElement(By.xpath("//*[@id=\"signin_button\"]"));
             element.click();

            //3. Login alanine  “username” yazdirin
           WebElement loginKutusu= driver.findElement(By.id("user_login"));
           loginKutusu.sendKeys("username");

          //4. Password alanina “password” yazdirin
          WebElement passwordKutusu= driver.findElement(By.id("user_password"));
          passwordKutusu.sendKeys("password");

            //5. Sign in buttonuna tiklayin
           WebElement signin = driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]"));
           signin.click();

          //6. Back tusu ile sayfaya donun
          driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        WebElement onlineBanking = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBanking.click();
        WebElement payBills = driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]"));
        payBills.click();

       //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
       driver.findElement(By.xpath("//*[@id=\"sp_amount\"]")).sendKeys("3000");;

      //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id=\"sp_date\"]")).sendKeys("2020-09-10");

       //10. Pay buttonuna tiklayin
       driver.findElement(By.xpath("//*[@id=\"pay_saved_payees\"]")).click();

      //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
       WebElement mesajElementi= driver.findElement(By.id("alert_content"));

       String expectedMesaj = "The payment was successfully submitted.";
       String actualMesaj = mesajElementi.getText();

       Assert.assertTrue(expectedMesaj.contains(actualMesaj));

   }

         @Test
    public void test14() {

             //2- https://www.google.com/ adresine gidin
             driver.get("https://www.google.com/");

             //3- cookies uyarisini kabul ederek kapatin
             //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
             Assert.assertTrue(driver.getTitle().contains("Google"));

             //5- Arama cubuguna “Nutella” yazip aratin
             WebElement element = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
             element.sendKeys("Nutella" + Keys.ENTER);
             bekle(3);

             //6- Bulunan sonuc sayisini yazdirin

             String resultSonuc = driver.findElement(By.xpath("//*[@id=\"slim_appbar\"]")).getText();
             System.out.println("Sonuç sayısı: " + resultSonuc);

             String sonucElement=driver.findElement(By.id("result-stats")).getText();
             String[] sonucSayisiArr=sonucElement.split(" ");
             String sonuc=sonucSayisiArr[1];
             sonuc=sonuc.replace(".","");
             int sonucSayisi=Integer.valueOf(sonuc);
             System.out.println(sonucSayisi);

             //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
             Assert.assertTrue(sonucSayisi>10000000);


         }

      @Test
      public void test15() {

           //“https://www.saucedemo.com” Adresine gidin
          driver.get("https://www.saucedemo.com");

          //Username kutusuna “standard_user” yazdirin
          WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
          username.sendKeys("standard_user" + Keys.ENTER);

          //Password kutusuna “secret_sauce” yazdirin
          WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
          password.sendKeys("secret_sauce" + Keys.ENTER);

          //Login tusuna basin
          driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
          bekle(3);

          //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
          WebElement ilkUrun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
          String productName = ilkUrun.getText();


          //Add to Cart butonuna basin
          driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
          bekle(3);

          //Alisveris sepetine tiklayin
          driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

          //Sectiginiz urunun basarili olarak sepete eklendigini control edin
          WebElement urun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
          String actualUrun = urun.getText();
          if (actualUrun.equals(productName)) {
              System.out.println("Ürün sebete eklendi");
          } else {
              System.out.println("Ürün sepete eklenemedi.");
          }
      }

          @Test
                  public void test16(){

              //2) https://www.bestbuy.com/ Adresine gidin
              driver.get("https://www.bestbuy.com/");

              //   farkli test method’lari olusturarak asagidaki testleri yapin
              //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
              Assert.assertTrue(driver.getCurrentUrl().equals("https://www.bestbuy.com/"));

              //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
              Assert.assertTrue(!driver.getTitle().contains("Rest"));

              //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
              WebElement logoTest = driver.findElement(By.xpath("//img[@alt=\"Best Buy Logo\"][1]"));
              Assert.assertTrue(logoTest.isDisplayed());


              //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
              WebElement FrancaisLinkTest = driver.findElement(By.xpath("//button[@lang=\"fr\"]"));
              Assert.assertTrue(FrancaisLinkTest.isDisplayed());

    }

         @Test
               public void test17() {

             //https://www.youtube.com adresine gidin
             driver.get("https://www.youtube.com");

             //Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
                //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
             Assert.assertTrue(driver.getTitle().contains("YouTube"));

                //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
             WebElement imageTest = driver.findElement(By.xpath("//*[@id=\"logo-icon\"][1]"));
             Assert.assertTrue(imageTest.isDisplayed());

                //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
           WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
           searchBox.isEnabled();

                //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
             Assert.assertTrue(!driver.getTitle().contains("youtube"));

         }

         @Test
        public void test18(){


             //https://the-internet.herokuapp.com/checkboxes
             driver.get("https://the-internet.herokuapp.com/checkboxes");

             //b. Checkbox1 ve checkbox2 elementlerini locate edin.
             WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
             WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

             //c. Checkbox1 seçili değilse onay kutusunu tıklayın
             if (!checkbox1.isSelected()){
                 checkbox1.click();
             }

             //d. Checkbox2 seçili değilse onay kutusunu tıklayın
             if (!checkbox2.isSelected()){
                 checkbox2.click();
             }

             //e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
             Assert.assertTrue(checkbox1.isSelected() && checkbox2.isSelected());
         }

         @Test
          public void test19(){

             //Verilen web sayfasına gidin https://facebook.com
             driver.get("https://facebook.com");

             //b. Cookies’i kabul edin
             driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
             //c. Create an account buton’una basin
            WebElement button =driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
            button.click();

             //d. Radio button elementlerini locate edin ve size uygun olani secin
             WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"u_9_4_jS\"]"));
             radioButton.isSelected();
             bekle(3);
             //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

         }

         @Test
    public void test20(){

             // Amazon anasayfaya gidin
             driver.get("https://www.amazon.com/");


             // dropdown menuyu locate et
             WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));

             // Select class'indan bir obje olusturalim
             Select select = new Select(dropdownElement);

             // arama kutusunun yanindaki dropdown menude 28 secenek oldugunu test edin
             int expectedMenu = 28;
             int actualMenu = select.getOptions().size();
             if (actualMenu == 28){
                 System.out.println("Test Passed");
             }else{
                 System.out.println("Test Failed");
             }

             // dropdown menuden Baby kategorisini secin
            select.selectByVisibleText("Baby");

             // Arama kutusuna Nutella yazip aratin
             WebElement nutellaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
             nutellaKutusu.sendKeys("Nutella" + Keys.ENTER);
             bekle(5);

             // bulunan sonuc sayisinin 10'dan fazla oldugunu test edin
             // sectigimiz opsiyonu yazdirin
             String sonucSayi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
             String sonucLar = sonucSayi.substring(0,sonucSayi.indexOf(" "));
             int sonucInt = Integer.parseInt(sonucLar);
             System.out.println(sonucInt);

             if (sonucInt>10){
                 System.out.println("Test Passed");

             }else{
                 System.out.println("Test Failed");

             }
             // sectigimiz opsiyon'un Baby oldugunu test edin
             dropdownElement = driver.findElement(By.id("searchDropdownBox"));
             Select select1 = new Select(dropdownElement);
             System.out.println(select1.getFirstSelectedOption().getText());

             String expectedSeciliOption = "Baby";
             String actualSeciliOption = select1.getFirstSelectedOption().getText();
             Assert.assertEquals(expectedSeciliOption,actualSeciliOption);

    }

        @Test
    public void test21(){

             //https://the-internet.herokuapp.com/dropdown adresine gidin.
            driver.get("https://the-internet.herokuapp.com/dropdown");

            //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            WebElement option1 = driver.findElement(By.id("dropdown"));
            Select select = new Select(option1);
            select.selectByIndex(1);
            System.out.println("İndex ile seçilen option :" + select.getFirstSelectedOption().getText());

            //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            select.selectByValue("2");
            System.out.println("Value ile seçilen option :" + select.getFirstSelectedOption().getText());

            //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            select.selectByVisibleText("Option 1");
            System.out.println("Visible Text ile seçilen option 1 :" + select.getFirstSelectedOption().getText());



            //4.Tüm dropdown değerleri(value) yazdırın
            List<WebElement> tumdropdownDegerler = select.getOptions();
            System.out.println("====================");
            for (WebElement eachElement: tumdropdownDegerler
            ) {
                System.out.println(eachElement.getText());
            }

            //5. Dropdown’un boyutunun 4 olduğunu test edin
            int expectedBoyut = 3;
            int actualBoyut = tumdropdownDegerler.size();
            Assert.assertEquals(expectedBoyut,actualBoyut);

    }

         @Test
        public void test22(){


             //https://www.amazon.com/ adresine gidin.
             driver.get("https://www.amazon.com/");

              //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
             WebElement dropdownElementi = driver.findElement(By.id("searchDropdownBox"));
             Select select = new Select(dropdownElementi);
             int expectedKategory = 45;
             int actualKategory = select.getOptions().size();
             if (actualKategory == 45){
                 System.out.println("Test Passed" );
             }else {
                 System.out.println("Test Failed :" + actualKategory);

             }
             //-Test 2
               //1. Kategori menusunden Books secenegini secin
             select.selectByVisibleText("Books");

               //2. Arama kutusuna Java yazin ve aratin
             WebElement aramaKutusuJava = driver.findElement(By.id("twotabsearchtextbox"));
             aramaKutusuJava.sendKeys("Java" + Keys.ENTER);

              //3. Bulunan sonuc sayisini yazdirin
             String sonucSayi = driver.findElement(By.xpath("//*[@id=\"search\"]/span")).getText();
             //System.out.println(sonucSayi);

              //4. Sonucun Java kelimesini icerdigini test edin

             String javaKeyword = sonucSayi.substring(sonucSayi.indexOf("1-16"), sonucSayi.indexOf("Java") + 5);
             System.out.println(javaKeyword);

             if (sonucSayi.contains("Java")){
                 System.out.println("Test Passed");
             }

    }

    @Test
    public void test23(){

        //http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //Sign in butonuna basin
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"signin_button\"]"));
        signIn.click();

        //Login kutusuna “username” yazin
        WebElement usernameKutusu = driver.findElement(By.id("user_login"));
        usernameKutusu.sendKeys("username" + Keys.ENTER);

        //Password kutusuna “password.” yazin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password." + Keys.ENTER);

        //Sign in tusuna basin
        WebElement signInsecond = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        signInsecond.click();
        bekle(3);

        driver.navigate().back();

        //Online Banking click edin
        WebElement onlineBanking = driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]"));
        onlineBanking.click();
        bekle(3);

        //Pay Bills sayfasina gidin

        //“Purchase Foreign Currency” tusuna basin
        //“Currency” drop down menusunden Eurozone’u secin
        //“amount” kutusuna bir sayi girin
        //“US Dollars” in secilmedigini test edin
        //“Selected currency” butonunu secin
        //“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
    }

    @Test
    public void test24() {


        //1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()=\"Click for JS Alert\"]")).click();
        bekle(3);

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expectedAlertYazisi = "I am a JS Alert";

        Assert.assertTrue(actualAlertYazisi.equals(expectedAlertYazisi));
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        bekle(3);
    }

        @Test
                public void test25() {

            //2.Test
            //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            //- 2.alert'e tiklayalim
            driver.findElement(By.xpath("//*[text()=\"Click for JS Confirm\"]")).click();

            //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
            driver.switchTo().alert().dismiss();
            String expectedCancel = "You clicked: Cancel";
            String actualCancel = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();

            Assert.assertTrue(actualCancel.equals(expectedCancel));



        }
        @Test
                public void test26(){

            //3.Test
                //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
                driver.get("https://the-internet.herokuapp.com/javascript_alerts");

                //- 3.alert'e tiklayalim
            driver.findElement(By.xpath("//*[text()=\"Click for JS Prompt\"]")).click();

                //- Cikan prompt ekranina "Abdullah" yazdiralim
            driver.switchTo().alert().sendKeys("Abdullah");
            bekle(3);
                //- OK tusuna basarak alert'i kapatalim
            driver.switchTo().alert().accept();

                //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
            String expectedYazi = "Abdullah";
            String actualYazi = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();

            Assert.assertTrue(actualYazi.contains(expectedYazi));

    }

@Test
    public void test27(){
               //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
               driver.get("https://the-internet.herokuapp.com/basic_auth");

               //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
             //Html komutu : https://username:password@URL
               // Username : admin
                // password : admin
              driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
            //4- Basarili sekilde sayfaya girildigini dogrulayin
              WebElement basariliGirisYazisi = driver.findElement(By.tagName("p"));
             Assert.assertTrue(basariliGirisYazisi.isDisplayed());
             bekle(3);
}
           @Test
              public void test28(){

               //https://the-internet.herokuapp.com/iframe adresine gidin.

               //2 ) Bir metod olusturun: iframeTest
               //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
               //- Text Box’a “Merhaba Dunya!” yazin.
               //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
               // gorunur oldugunu dogrulayin ve konsolda yazdirin.
           }

}




























