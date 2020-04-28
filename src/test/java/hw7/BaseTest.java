package hw7;

import hw7.models.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class BaseTest {

  @BeforeTest
  public void beforeClass() {
    initElements(JDISite.class);
    JDISite.open();
    JDISite.homePage.login(User.ROMAN);
    JDISite.homePage.checkLoggedIn(User.ROMAN);
  }

  @AfterClass
  public void afterClass() {
    killAllSeleniumDrivers();
  }
}
