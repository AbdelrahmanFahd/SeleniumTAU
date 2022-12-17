package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.WindowManger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        goHome();
        setCookie();

    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void takeScreenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenShot.toPath(), new File("F:\\Maven Selenium\\TAU_TestNG\\src\\main\\resources\\screenshotes\\" + result.getName() + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void closeBrowser() {

        driver.quit();

    }

    public WindowManger getWindowManger() {
        return new WindowManger(driver);
    }

    private ChromeOptions getChromeOptions() {
        var options = new ChromeOptions();
        options.addArguments("disable-infobars");
//        options.setHeadless(true);
        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("Fahd", "881998").domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(String nameCookie) {

        driver.manage().deleteCookieNamed(nameCookie);
    }

    public boolean cookieExist(String nameCookie) {

        return driver.manage().getCookieNamed(nameCookie) != null;
    }


}
