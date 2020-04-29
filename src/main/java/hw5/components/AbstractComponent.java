package hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {

  protected WebDriver driver;
  protected WebDriverWait wait;

  protected AbstractComponent(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 5);
    PageFactory.initElements(driver, this);
  }

  protected boolean isElementsDisplayed(List<WebElement> webElements){
    wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    boolean isDisplayed = false;
    for (WebElement element : webElements) {
      isDisplayed = element.isDisplayed();
    }
    return isDisplayed;
  }
}
