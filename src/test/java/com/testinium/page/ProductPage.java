package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

import static com.testinium.driver.BaseTest.driver;

public class ProductPage {

    Methods metod;
    Logger logger= LogManager.getLogger(ProductPage.class);

    public ProductPage(){
        metod=new Methods();
    }
    public void scrollAndSelect(){
        metod.sendKeys(By.xpath("//input[@id='search-input']"),"Oyuncak");
        metod.click(By.xpath("//span[@class='common-sprite button-search']"));
        metod.waitBySeconds(1);
        //metod.click(By.cssSelector(".pr-img-link"));
        metod.waitBySeconds(1);
        metod.scrollWithAction(By.cssSelector("#review-reply-button"));
        metod.waitBySeconds(1);
        metod.selectByText(By.xpath("//select[@id='review-sort-selection']"),"Oylama (Düşük > Yüksek)");
        metod.waitBySeconds(1);

    }
    public void attributeTest(){
        String attribute= metod.getAttribute(By.cssSelector(".logo-text>a>img"),"title");
        System.out.println("Alinan text: " +attribute);
        logger.info("Alınan Text : "+attribute);
        metod.waitBySeconds(3);
    }
    public void textControlTest(){
        String text= metod.getText(By.cssSelector(".common-sprite"));
        System.out.println("Alınan Text :" +text);
        logger.info("Alınan Text : "+text);
        metod.waitBySeconds(1);
    }
    public void puanKatalog(){
        metod.click(By.xpath("//div[@class='lvl1catalog']"));
        metod.waitBySeconds(1);
        metod.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        metod.waitBySeconds(1);
        metod.selectByText(By.xpath("//select[@onchange='location = this.value;']"),"Yüksek Oylama");
        metod.waitBySeconds(1);
    }

    public void scrollAndFind(){
        metod.sendKeys(By.xpath("//input[@id='search-input']"),"Oyuncak");
        metod.waitBySeconds(3);
        metod.click(By.xpath("//span[@class='common-sprite button-search']"));
        metod.waitBySeconds(5);
        for(int i = 7 ; i<11; i++ )
        {
            metod.scrollWithAction(By.xpath("//div[@id='product-table']/div["+i+"]"));
            metod.click(By.xpath("//div[@id='product-table']/div["+i+"]/div[2]/div[3]/a[4]"));
            metod.waitBySeconds(2);
        }

        Assert.assertTrue(metod.isElementVisible(By.cssSelector(".swal2-title.ky-swal-title-single")));
        System.out.println("favorilerde ürün var");
        metod.click(By.xpath("//div[@class='logo-text']"));
        metod.waitBySeconds(5);
        metod.click(By.xpath("//div[@class='lvl1catalog']"));
        metod.waitBySeconds(5);
        metod.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        metod.waitBySeconds(5);
        metod.selectByText(By.xpath("//select[@onchange='location = this.value;']"),"Yüksek Oylama");
        metod.waitBySeconds(5);

    }
    public void randomUrunSecimi(){
        metod.click(By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[3]/span"));
        metod.waitBySeconds(3);
        metod.click(By.xpath("//a[@href='kategori/kitap-hobi/1_212.html']"));
        metod.waitBySeconds(3);
        Random r=new Random(); //random sınıfı
        int a=r.nextInt(6);
        while(true)
        {
            if(a != 0)
                break;
            a = r.nextInt(6);
        }

        System.out.println("//ul[@class='product-grid jcarousel-skin-opencart']/li[" + a + "]");
        metod.click(By.xpath(
                "//ul[@class='product-grid jcarousel-skin-opencart']/li[" + a + "]"));
        metod.waitBySeconds(3);
        metod.click(By.id("button-cart"));
        metod.waitBySeconds(3);
    }
    public void favorilerim(){
        metod.click(By.cssSelector(".menu.top.my-list"));
        metod.waitBySeconds(3);
        metod.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        metod.waitBySeconds(2);
        metod.click(By.xpath("//div[@class='product-list']/div[2]/div[2]/div[3]/a[3]"));
        metod.waitBySeconds(3);
    }
    public void sepeteGit(){
        metod.click(By.xpath("//div[@id='cart']"));
        metod.waitBySeconds(1);
        metod.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/cart']"));
        metod.waitBySeconds(1);
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        metod.sendKeys(By.xpath("//input[@name='quantity']"),"2");
        metod.waitBySeconds(1);
        metod.click(By.xpath("//i[@onclick='cartProductUpdate($(this).parent())']"));
        metod.waitBySeconds(1);
        metod.click(By.xpath("//button[@class='swal2-close']"));
        metod.waitBySeconds(1);
        metod.click(By.xpath("//td[@class='to-wishlist']"));
        metod.waitBySeconds(1);
    }
    public void satinAl(){
        metod.click(By.xpath("//a[@href='#tab-shipping-new-adress']"));
        metod.waitBySeconds(1);
        metod.click(By.id("address-firstname-companyname"));
        metod.sendKeys(By.id("address-firstname-companyname"),"Ulaş");
        metod.waitBySeconds(1);
        metod.sendKeys(By.id("address-lastname-title"),"Çamlı");
        metod.sendKeys(By.id("address-zone-id"),"İzmir");
        metod.waitBySeconds(3);
        metod.sendKeys(By.id("address-county-id"),"BAYRAKLI");
        metod.waitBySeconds(1);
        metod.sendKeys(By.id("address-address-text"),"1111 sokak no: 1 d:1");
        metod.waitBySeconds(1);
        metod.sendKeys(By.id("address-mobile-telephone"),"5555555555");
        metod.waitBySeconds(1);
        metod.click(By.id("button-checkout-continue"));
        metod.waitBySeconds(5);
        System.out.println("Adres bilgileri girildi.");
    }

    public void odemeYontemi(){
        metod.waitBySeconds(2);
        metod.click(By.id("button-checkout-continue"));
        metod.waitBySeconds(2);
        metod.click(By.id("credit-card-owner"));
        metod.waitBySeconds(2);
        metod.sendKeys(By.id("credit-card-owner"),"Ulaş Çamlı");
        metod.waitBySeconds(2);
        metod.click(By.id("credit_card_number_1"));
        metod.sendKeys(By.id("credit_card_number_1"),"1111");
        metod.waitBySeconds(2);
        metod.sendKeys(By.id("credit_card_number_2"),"1111");
        metod.waitBySeconds(2);
        metod.sendKeys(By.id("credit_card_number_3"),"1111");
        metod.waitBySeconds(2);
        metod.sendKeys(By.id("credit_card_number_4"),"1111");
        metod.waitBySeconds(2);
        metod.click(By.id("credit-card-expire-date-month"));
        metod.sendKeys(By.id("credit-card-expire-date-month"),"07");
        metod.click(By.id("credit-card-expire-date-year"));
        metod.sendKeys(By.id("credit-card-expire-date-year"),"2025");
        metod.waitBySeconds(2);
        metod.click(By.id("credit-card-security-code"));
        metod.waitBySeconds(2);
        metod.sendKeys(By.id("credit-card-security-code"),"190");
        metod.waitBySeconds(2);
        metod.click(By.id("button-checkout-continue"));
        metod.waitBySeconds(2);
        System.out.println("Geçersiz Kart.");
    }
    public void logOut(){
        metod.click(By.xpath("//a[@class='checkout-logo']"));
        metod.waitBySeconds(2);
        metod.click(By.cssSelector(".menu.top.login"));
        metod.waitBySeconds(2);
        System.out.println("Çıkış yapamadım.");


    }

}
