package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TablePage extends AbstractPage {

  @FindBy(tagName = "select")
  private WebElement dropdown;

  @FindBy(css = "tbody > tr")
  private List<WebElement> tableRows;

  @FindBy(css = "#table-with-pages_filter input")
  private WebElement search;

  public TablePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public String getDropdownValue() {
    wait.until(ExpectedConditions.visibilityOf(dropdown));
    return new Select(dropdown).getFirstSelectedOption().getText();
  }

  public void setDropdownValue(String value) {
    wait.until(ExpectedConditions.elementToBeClickable(dropdown));
    new Select(dropdown).selectByValue(value);
  }

  public int getNumberOfTableRows() {
    return wait.until(ExpectedConditions.visibilityOfAllElements(tableRows)).size();
  }

  public void searchFor(String search) {
    wait.until(ExpectedConditions.visibilityOf(this.search)).sendKeys(search);
  }

  public boolean isCorrectSearch(String search) {
    wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
    boolean isCorrectSearch = false;
    for (WebElement tableRow : tableRows) {
      if (tableRow.getText().toLowerCase().contains(search.toLowerCase()))
        isCorrectSearch = true;
    }
    return isCorrectSearch;
  }
}
