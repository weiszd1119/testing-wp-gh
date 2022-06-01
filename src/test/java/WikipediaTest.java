// testing allure report

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaTest {
    WebDriver driver;

    @Test
    public void loginWikipedia() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://en.wikipedia.org/w/index.php?title=Special:UserLogin");
        String inputUserName = "Yaraclen";
        WebElement findUserName = driver.findElement(By.id("wpName1"));
        findUserName.sendKeys(inputUserName);
        String inputPassword = "TEmp1119";
        WebElement findPassword = driver.findElement(By.id("wpPassword1"));
        findPassword.sendKeys(inputPassword);
        findPassword.sendKeys(Keys.ENTER);
    }
    @Test
    public void searchSeleniumWikipedia() {
        loginWikipedia();
        String inputSearch = "Selenium (software)"; //a feladat Selenium-ot ír inputnak, de az csak a lapértelmezőre ugrik
        WebElement findSearch = driver.findElement(By.id("searchInput"));
        findSearch.sendKeys(inputSearch);
        findSearch.sendKeys(Keys.ENTER);
        assertEquals("https://en.wikipedia.org/wiki/Selenium_(software)",driver.getCurrentUrl());
        //driver.get(URL);
    }

    @Test
    public void searchFrameworkWikipedia() {
        loginWikipedia();
        String inputSearch = "Framework";
        WebElement findSearch = driver.findElement(By.id("searchInput"));
        findSearch.sendKeys(inputSearch);
        findSearch.sendKeys(Keys.ENTER);
        WebElement clickOnLink = driver.findElement(By.id("mw-content-text"));
        clickOnLink.click();
        assertEquals("https://en.wikipedia.org/wiki/Framework", driver.getCurrentUrl());
        //webDriver.get(URL);
    }

    @Test
    public void setFontStyle() throws InterruptedException {
        loginWikipedia();
        WebElement clickOnLanguageSettings = driver.findElement(By.xpath("//*[@id=\"p-lang\"]/button"));
        clickOnLanguageSettings.click();
        Thread.sleep(2000); //nem találja a gombot, mert még nem töltött be
        WebElement clickOnFonts = driver.findElement(By.cssSelector("#uls-display-settings-fonts-tab"));
        clickOnFonts.click();
        Thread.sleep(2000);
        WebElement clickOnCheckbox = driver.findElement(By.id("webfonts-enable-checkbox"));
        clickOnCheckbox.click();
        //Font selection
        /*
        Thread.sleep(2000);
        WebElement clickOnSelectedFont = driver.findElement(By.id("content-font-selector"));
        Thread.sleep(2000);
        Selectfont selectfont = new Selectfont(clickOnSelectedFont);
        selectfont.selectByVisibleText("ComicNeue");
        Thread.sleep(2000);
        WebElement clickOnApply = webDriver.findElement(By.xpath("//*[@id=\"language-settings-dialog\"]/div[3]/div/button[2]"));
        clickOnApply.click();
        */
    }

    @Test
    public void findAParagraph() {
        loginWikipedia();
        String inputSearch = "Selenium (software)";
        WebElement findSearch = driver.findElement(By.id("searchInput"));
        findSearch.sendKeys(inputSearch);
        findSearch.sendKeys(Keys.ENTER);
        WebElement clickOnLinkSeleniumGrid = driver.findElement(By.xpath("//*[@id=\"toc\"]/ul/li[2]/ul/li[5]/a"));
        clickOnLinkSeleniumGrid.click();
        assertEquals("https://en.wikipedia.org/wiki/Selenium_(software)#Selenium_Grid", driver.getCurrentUrl());
    }
}