package hw3;

import hw3.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected final static String URL = PropertyReader.read("baseUrl");
  protected final static String USER = PropertyReader.read("user");
  protected final static String PASSWORD = PropertyReader.read("password");

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 5);
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  public void openPage() {
    driver.manage().window().maximize();
    driver.get(URL);
  }

}
