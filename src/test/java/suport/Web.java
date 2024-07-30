package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Work\\Documents\\QA\\chromedriver.exe");
        WebDriver browser = new ChromeDriver(); //abre o navegador
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // tenta achar o elemento em até 5 segundoa
        browser.get("https://www.netshoes.com.br/"); // navega para o site
        browser.manage().window().maximize(); // deixar em tela cheia

        return browser;
    }
}
