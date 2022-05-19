package com.testinium.page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;
    public LoginPage(){
        methods = new Methods();
    }

    public void login(){
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//input[@id='login-email']"),"ulas_1998@hotmail.com");
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//input[@id='login-password']"),"ulas283U");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(7);
        Assert.assertTrue(methods.isElementVisible(By
                .xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11453388/wh:44a9b399f']")));
        methods.waitBySeconds(7);
    }


}
