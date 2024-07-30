package tests;


import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.Generator;
import suport.Screenshot;
import suport.Web;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
@RunWith(DataDrivenTestRunner.class) //Utilizar a biblioteca do eayTest para Data-driven tests
@DataLoader(filePaths = "LoginTest.csv") //Os arquivos que eu quero utilizar como sendo repósitório dos meus dados de teste
public class LoginTest {
    private WebDriver browser;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        browser = Web.createChrome();

    }

    @After
    public void tearDown(){
        //browser.quit();
    }


    @Test
    public void successfulLoginTest(){
        browser.findElement(By.linkText("Entrar")).click();
        browser.findElement(By.linkText("Login")).click();
        browser.findElement(By.id("user")).sendKeys("meu_email@teste.com");
        browser.findElement(By.id("password")).sendKeys("teste_automacao");
        browser.findElement(By.xpath("/html/body/div[1]/main/div[1]/section[1]/form/div[6]/div/div/button")).submit();

        String validation = browser.findElement(By.id("username-logged")).getText();
        Assert.assertEquals("Teste",validation);

        //Evidencia
        Screenshot.take(browser,"C:\\Users\\Work\\Documents\\QA\\test-report\\netshoes\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void useOfCombobOX(){
        browser.findElement(By.linkText("Entrar")).click();
        browser.findElement(By.linkText("Login")).click();
        browser.findElement(By.id("user")).sendKeys("meu_email@teste.com");
        browser.findElement(By.id("password")).sendKeys("teste_automacao");
        browser.findElement(By.xpath("/html/body/div[1]/main/div[1]/section[1]/form/div[6]/div/div/button")).submit();

        browser.findElement(By.xpath("//*[@id=\"header-user-logged\"]/a/i")).click();
        browser.findElement(By.linkText("Minha conta")).click();
        browser.findElement(By.linkText("Endereços")).click();
        browser.findElement(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div[1]/div/div[2]/button")).click();

        WebElement comboBox = browser.findElement(By.id("streetType"));
        new Select(comboBox).selectByVisibleText("Rodovia");
        browser.findElement(By.xpath("//button[@data-testid='confirm-button']")).submit();

        /*   ---- COMO CONFIRMAR UM POPUP JANELA JAVASCRIPT

                BROWSER.SWITCHTO().ALERT().ACCEPT();

         */

    }

   /* @Test
    public void dataDrivenTesting(@Param(name="nome")String nome,
                                  @Param(name="cep")String cep,
                                  @Param(name="destinatario")String destinatario,
                                  @Param(name="numero")String numero,
                                  @Param(name="mensagem")String mensagem){

        // Adicionar endereço
        browser.findElement(By.linkText("Entrar")).click();
        browser.findElement(By.linkText("Login")).click();
        browser.findElement(By.id("user")).sendKeys("meu_email@teste.com");
        browser.findElement(By.id("password")).sendKeys("teste_automacao");
        browser.findElement(By.xpath("/html/body/div[1]/main/div[1]/section[1]/form/div[6]/div/div/button")).submit();

        browser.findElement(By.xpath("//*[@id=\"header-user-logged\"]/a/i")).click();
        browser.findElement(By.linkText("Minha conta")).click();
        browser.findElement(By.linkText("Endereços")).click();

        browser.findElement(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div[2]/button")).click();
        browser.findElement(By.xpath("//input[@id='name']")).sendKeys(nome);
        browser.findElement(By.xpath("//input[@id='zipCode']")).sendKeys(cep);
        browser.findElement(By.xpath("//input[@id='recipientName']")).sendKeys(destinatario);
        browser.findElement(By.xpath("//input[@id='streetNumber']")).sendKeys(numero);
        browser.findElement(By.xpath("//button[@data-testid='confirm-button']")).submit();

        String message = browser.findElement(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div[3]/div/span")).getText();
        Assert.assertEquals(mensagem,message);

    }*/

}
