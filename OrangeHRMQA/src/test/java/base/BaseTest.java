package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.main.other.Header;
import org.main.other.Sidebar;
import org.main.pages.LoginPage;
import org.main.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.constants.BaseTestConstants;

public class BaseTest {

    protected LoginPage login;
    protected HomePage home;
    protected WebDriver driver;
    protected Sidebar sidebar;
    protected Header header;

    @BeforeSuite
    public void setDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod()
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.get(BaseTestConstants.BASE_URL);
        driver.manage().window().maximize();
        login = new LoginPage(driver);

    }

    public void loginAsDefaultUser() {

        if(!login.isLoaded()) return;
        home = login.completeLogin(BaseTestConstants.BASE_USERNAME, BaseTestConstants.BASE_PASSWORD);
        home.isLoaded();
        sidebar = new Sidebar(driver);
        header = new Header (driver);
    }


    @AfterMethod
    public void afterClass() {
       driver.quit();
    }

}
