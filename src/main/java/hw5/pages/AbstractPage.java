package hw5.pages;

import hw5.components.HeaderMenu;
import hw5.components.SideBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {

  protected WebDriver driver;
  protected SideBarMenu sideBarMenu;
  protected HeaderMenu headerMenu;
  protected WebDriverWait wait;

  protected AbstractPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 5);
  }

  protected void setElementInAList(String elementName, List<WebElement> webElementsList) {
    wait.until(ExpectedConditions.visibilityOfAllElements(webElementsList));
    for (WebElement element : webElementsList) {
      if (!element.isSelected() & element.getText().equals(elementName))
        element.click();
    }
  }
}
