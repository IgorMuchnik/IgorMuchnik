package hw5.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum WebDriverSingleton {

  INSTANCE;

  private WebDriver driver;
  private WebDriverWait wait;

  public void createdDriver(String browserName) {
    if ("CHROME".equalsIgnoreCase(browserName)) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      wait = new WebDriverWait(driver, 5);
    }
  }

  public WebDriver getDriver() {
    if (driver == null) {
      createdDriver("chrome");
    }
    return driver;
  }

  public WebDriverWait getWait() {
    return wait;
  }
}