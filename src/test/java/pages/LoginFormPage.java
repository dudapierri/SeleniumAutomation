package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
    private WebDriver browser;
    public LoginFormPage(WebDriver browser){
        this.browser = browser;
    }

    public LoginFormPage typeEmail(String email){
        browser.findElement(By.id("user")).sendKeys(email);
        return this;
    }

    public LoginFormPage typePassword(String password){
        browser.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public HomePage clickSignIn(){
        browser.findElement(By.xpath("/html/body/div[1]/main/div[1]/section[1]/form/div[6]/div/div/button")).submit();
        return new HomePage(browser);
    }

    public HomePage makeLogin(String email, String password){
        browser.findElement(By.id("user")).sendKeys(email);
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.xpath("/html/body/div[1]/main/div[1]/section[1]/form/div[6]/div/div/button")).submit();
        return new HomePage(browser);
    }

}
