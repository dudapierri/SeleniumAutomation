package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver browser;
    public LoginPage(WebDriver browser){
        this.browser = browser;
    }

    public LoginFormPage clickLogin(){
        browser.findElement(By.linkText("Entrar")).click();
        browser.findElement(By.linkText("Login")).click();
        return new LoginFormPage(browser);
    }
}
