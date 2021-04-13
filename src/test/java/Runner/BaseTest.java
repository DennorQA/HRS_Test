package Runner;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeMethod
    public void createBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denys\\Desktop\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        setDriver(new ChromeDriver(options));
    }

    @BeforeMethod
    public void setUp(){
        this.driver.get("https://cc.healthrecoverysolutions.com/login");
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        this.driver.close();
    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }
}
