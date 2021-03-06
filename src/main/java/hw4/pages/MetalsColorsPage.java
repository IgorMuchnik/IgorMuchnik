package hw4.pages;

import hw4.components.ResultsForm;
import hw4.dataModels.FormData;
import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MetalsColorsPage extends AbstractPage {

  private ResultsForm result;

  @FindBy(css = "#odds-selector > p label")
  private List<WebElement> summaryRadioOdd;

  @FindBy(css = "#even-selector > p label")
  private List<WebElement> summaryRadioEven;

  @FindBy(css = "#elements-checklist label")
  private List<WebElement> elements;

  @FindBy(css = "#colors .bootstrap-select")
  private WebElement colors;

  @FindBy(css = "#colors ul > li")
  private List<WebElement> colorsDropdownElements;

  @FindBy(css = ".metals .bootstrap-select")
  private WebElement metals;

  @FindBy(css = ".metals .caret")
  private WebElement metalsCaret;

  @FindBy(css = "#metals ul > li")
  private List<WebElement> metalsDropdownElements;

  @FindBy(id = "vegetables")
  private WebElement vegetables;

  @FindBy(css = "#vegetables .dropdown-menu li")
  private List<WebElement> vegetablesDropdownElements;

  @FindBy(id = "submit-button")
  private WebElement submitButton;


  public MetalsColorsPage(WebDriver driver) {
    super(driver);
    result = new ResultsForm(driver);
    PageFactory.initElements(driver, this);
  }

  public void fillForm(FormData form) {
    setColor(form.getColors());
    setMetal(form.getMetals());
    setVegetable(form.getVegetables());
    setElement(form.getElements());
    setEven(form.getEven());
    setOdd(form.getOdd());
  }

  public void setColor(String color) {
    if (!color.equalsIgnoreCase(Colors.COLORS.toString())) {
      setWebElement(colors, colorsDropdownElements, colors, color);
    }
  }

  public void setMetal(String metal) {
    if (!metal.equalsIgnoreCase(Metals.METALS.toString())) {
      setWebElement(metalsCaret, metalsDropdownElements, metals, metal);
    }
  }

  public void setVegetable(List<Vegetables> vegetable) {
    if (!vegetable.get(0).toString().equalsIgnoreCase(Vegetables.VEGETABLES.toString())) {
      wait.until(ExpectedConditions.elementToBeClickable(vegetables)).click();
      wait.until(ExpectedConditions
        .attributeToBe(By.cssSelector("#vegetables .dropdown-menu"), "style", "display: block;"));
      driver.findElement(By.xpath("//*[@id='vegetables']//label[text()='Vegetables']")).click();
      for (Vegetables vegetableToSet : vegetable) {
        clickElement(vegetablesDropdownElements, vegetableToSet.toString());
      }
    }
  }

  public void setElement(List<Elements> element) {
    if (element != null) {
      wait.until(ExpectedConditions.visibilityOfAllElements(elements));
      for (Elements elemToSet : element) {
        clickElement(elements, elemToSet.toString());
      }
    }
  }

  public void setOdd(Integer value) {
    setNumber(value, summaryRadioOdd);
  }

  public void setEven(Integer value) {
    setNumber(value, summaryRadioEven);
  }

  private void setNumber(Integer value, List<WebElement> whereToSet) {
    if (value !=2  && value != 1) {
      wait.until(ExpectedConditions.visibilityOfAllElements(whereToSet));
      clickElement(whereToSet, value.toString());
    }
  }

  private void setWebElement(WebElement elemToSet, List<WebElement> whatWaitToAppear, WebElement elemTocCheck, String valueToSet) {
    wait.until(ExpectedConditions.elementToBeClickable(elemToSet)).click();
    wait.until(ExpectedConditions
      .attributeToBe(elemTocCheck, "class", "btn-group bootstrap-select uui-form-element open"));
    clickElement(whatWaitToAppear, valueToSet);
  }

  private void clickElement(List<WebElement> whereToSet, String value){
    for (WebElement element : whereToSet) {
      if (element.getText().equalsIgnoreCase(value)) {
        element.click();
      }
    }
  }

  public void submitForm() {
    wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
  }

  public Integer getSumResult() {
    return result.getSumResult();
  }

  public String getColorResult() {
    return result.getColorResult();
  }

  public String getMetalResult() {
    return result.getMetalResult();
  }

  public String getVegetableResult() {
    return result.getVegetableResult();
  }

  public String getElementsResult() {
    return result.getElementsResult();
  }

}
