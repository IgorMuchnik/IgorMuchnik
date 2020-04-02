package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected SoftAssert softAssert;
  protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 5);
    softAssert = new SoftAssert();
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

  public void login(String username, String pass){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-icon"))).click();
    wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
      "dropdown uui-profile-menu open"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name"))).sendKeys(username);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).sendKeys(pass);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button"))).click();
  }

  public String getUsername(){
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))).getText();
  }

}
