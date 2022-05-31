import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaTest {
    private static WebDriver webDriver;
    ChromeDriver driver = new ChromeDriver();
    private final String URL = "https://en.wikipedia.org/w/index.php?title=Special:UserLogin";

    @BeforeAll
    static void setDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
    @BeforeEach
    void setWebDriver(){
        webDriver = new ChromeDriver();
    }
    @Test
    public void loginWikipedia() {
        webDriver.get(URL);
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        String inputUserName = "Yaraclen";
        WebElement findUserName = webDriver.findElement(By.id("wpName1"));
        findUserName.sendKeys(inputUserName);
        String inputPassword = "TEmp1119";
        WebElement findPassword = webDriver.findElement(By.id("wpPassword1"));
        findPassword.sendKeys(inputPassword);
        findPassword.sendKeys(Keys.ENTER);
    }