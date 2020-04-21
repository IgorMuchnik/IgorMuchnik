package hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SideBarMenu extends AbstractComponent {
  @FindBy(css = ".sidebar-menu > li")
  private List<WebElement> sideBarMenuElements;

  public SideBarMenu(WebDriver driver) {
    super(driver);
  }

  public boolean isSidebarElementsDisplayed(){
    return isElementsDisplayed(sideBarMenuElements);
  }

  public List<String> getSideBarMenuElementsText(){
    waitForSidebarMenuToBeVisible();
    return sideBarMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  public int getSidebarElementsCount(){
    return wait.until(ExpectedConditions.visibilityOfAllElements(sideBarMenuElements)).size();
  }

  private void waitForSidebarMenuToBeVisible(){
    wait.until(ExpectedConditions.visibilityOfAllElements(sideBarMenuElements));
  }
}
