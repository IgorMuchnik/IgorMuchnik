package hw5;

import hw3.utils.PropertyReader;
import hw5.utils.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected WebDriver driver;
  protected final static String URL = PropertyReader.read("baseUrl");
  protected final static String USER = PropertyReader.read("user");
  protected final static String PASSWORD = PropertyReader.read("password");

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    WebDriverSingleton.INSTANCE.createdDriver("chrome");
    driver = WebDriverSingleton.INSTANCE.getDriver();
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
