package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver browser;
    public HomePage(WebDriver browser){
        this.browser = browser;
    }

    public String capturarTextoLogin(){
        return browser.findElement(By.id("username-logged")).getText();
    }


}
