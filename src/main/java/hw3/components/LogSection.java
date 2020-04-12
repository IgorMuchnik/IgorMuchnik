package hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class LogSection extends AbstractComponent {

  @FindBy(css = ".logs li")
  private List<WebElement> logs;

  public LogSection(WebDriver driver) {
    super(driver);
  }

  public boolean isSpecificLogDisplayed(String parameter) {
    waitForLogsToBeVisible();
    boolean isDisplayed = false;
    for (WebElement log : logs) {
      if (log.getText().contains(parameter)) {
        isDisplayed = true;
      }
    }
    return isDisplayed;
  }

  public boolean isCheckboxLogDisplayed(String checkboxName, String status) {
    return isSpecificLogDisplayed(checkboxName + ": condition changed to " + status);
  }


  public boolean isRadioLogDisplayed(String radioName) {
    return isSpecificLogDisplayed("metal: value changed to " + radioName);
  }

  public boolean isDropdownLogDisplayed(String dropdownValue) {
    return isSpecificLogDisplayed("Colors: value changed to " + dropdownValue);
  }

  private void waitForLogsToBeVisible(){
    wait.until(ExpectedConditions.visibilityOfAllElements(logs));
  }
}
