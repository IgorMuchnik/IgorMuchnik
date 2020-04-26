package hw6.hooks;

import hw6.utils.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks {

  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    WebDriverSingleton.INSTANCE.setDriver("chrome");
    WebDriverSingleton.INSTANCE.getDriver().manage().window().maximize();
  }

  @After
  public void tearDown() {
    WebDriverSingleton.INSTANCE.getDriver().quit();
  }
}
