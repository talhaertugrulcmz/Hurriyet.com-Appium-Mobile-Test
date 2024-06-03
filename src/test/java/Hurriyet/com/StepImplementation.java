package Hurriyet.com;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepImplementation extends Driver{


    private static final Logger log = LoggerFactory.getLogger(Driver.class);

    @Step("<int> saniye kadar bekle")
    public void waitForsecond(int s) throws InterruptedException {
        Thread.sleep(1000*s);
    }

    // Uygulamanın Acılma Kontrolu
    @Step("<xpath> uygulamanın açılması kontrol edilmektedir")
    public void Control(String xpath){

        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());
        TLogger.logger.info("Hurriyet.com mobil uygulamasi acildi tebrikler");
    }


    // Uygulama Giris Ekran Konrolu
    @Step("<id> Kullanici giriş sayfasının açılması kontrol edilmektedir")
    public void Control1(String id){
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        TLogger.logger.info("Kullanici Giris sayfasi acildi tebrikler");
    }


    // Kullanci Bilgileri Profil Ekranında Kontrolu
    @Step("<id1> Kullanici Adi Bilgisi ve <id2> Mail Bilgilerinin Dogru Oldugu Kontrol Edilir")
    public void Control2(String id1,String id2){

        String KullaniciAdiKontrol = appiumDriver.findElement(By.id(id1)).getText();
        String MailKontrol = appiumDriver.findElement(By.id(id2)).getText();

        Assert.assertTrue(appiumDriver.findElement(By.id(id1)).isDisplayed());
        System.out.println("Kullanici Adi Bilgileri : " + KullaniciAdiKontrol);

        Assert.assertTrue(appiumDriver.findElement(By.id(id2)).isDisplayed());
        System.out.println("Kullanici Mail Bilgileri : " + MailKontrol);

        if (KullaniciAdiKontrol.equals("TEST CASE") && MailKontrol.equals("raker79113@crodity.com")){
            System.out.println("Kullanici Adi ve Mail Bilgileri Dogru Goruntulenmektedir...");
        }else {
            System.out.printf("Kullanici Adi ve Mail Bilgileri Yanlis !!! ");
        }

    }

    // Sayfada Görünürlük Kontrolu
    @Step("<id> elemetin sayfada gorunur olduğunu kontrol et ve tıkla")
    public void findByelementEndclick(String id){
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()){
            element.click();
        }else{
            System.out.println("Kontrol edilen element Görünür olmadı");
        }

    }

    @Step("<xpath> li elementi bul ve tıkla")
    public void clickByxpath(String xpath)
    {
        appiumDriver.findElement(By.xpath(xpath)).click();

    }

    @Step("<css> li elemente tıkla")
    public void clickBycss(String css)
    {
        appiumDriver.findElement(By.className(css)).click();

    }

    @Step("<id> elementi bul ve ardindan tikla")
    public void clickByid(String id)
    {
        appiumDriver.findElement(By.id(id)).click();

    }

    // Kullanici Bilgileri Girme Ve Kontrolu
    @Step("<id> elementi bul ve <text1> mail girisi yap,<id2> elementi bul ve <text2> sifre girisi yap")
    public void sendKey(String id ,String text1,String id2,String text2) {

        appiumDriver.findElement(By.id(id)).sendKeys(text1);
        TLogger.logger.info("Kullanici maili girildi : " + text1);
        appiumDriver.findElement(By.id(id2)).sendKeys(text2);
        TLogger.logger.info("Kullanici sifresi girildi : " + text2);

        if(text1.equals("raker79113@crodity.com") && text2.equals("Testcase123!")){
            TLogger.logger.info("Kullanici Maili Ve Sifresi Dogru Tebrikler ...");
        }else if (text1 == ("raker79113@crodity.com") && text2 !=("TestCase123!")){
            TLogger.logger.info("Sifre Hatali");
        }else if (text1 != "raker79113@crodity.com" && text2 == "TestCase123!"){
            TLogger.logger.info("Kullanici Adi Hatali");
        }else {
            TLogger.logger.info("Kullanici Adi ve Sifresi Hatali");
        }

    }

    // Telefon Navbarı ile Geri Gelme
    @Step("Telefon Tuşu ile Uygulamada Geri Gelme")
    public void GeriGelme() throws InterruptedException {
        appiumDriver.navigate().back();
        Thread.sleep(2000);
    }
}


