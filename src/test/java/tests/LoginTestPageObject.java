package tests;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suport.Web;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "successfulLoginTest.csv")
public class LoginTestPageObject {
    private WebDriver browser;

    @Before
    public void SetUp(){
        browser = Web.createChrome();
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void successfulLoginTest(@Param(name="lgin")String login,
                                    @Param(name="senha")String senha,
                                    @Param(name="mensagem")String mensagem){
       String textoLogin = new LoginPage(browser)
                .clickLogin()
                .typeEmail(login)
                .typePassword(senha)
                .clickSignIn()
                .capturarTextoLogin();
       Assert.assertEquals(mensagem,textoLogin);


    }
}
