package hw2.ex2;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2 extends BaseTest {

  @Test
  public void exercise2() {
    //1 Open test site by URL
    openPage();

    //2 Assert Browser title
    assertEquals(driver.getTitle(), "Home Page", "Invalid title on the page");

    //3 Perform login
    login("Roman", "Jdi1234");

    //4 Assert Username is logged
    assertEquals(getUsername(), "ROMAN IOVLEV", "The login has not happened");

    //5 Open through the header menu Service -> Different Elements Page
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Service"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Different elements"))).click();

    //6 Select checkboxes "Water", "Wind"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Water']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Wind']"))).click();

    //7 Select radio "Selen"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Selen']"))).click();

    //8 Select in dropdown "Yellow"
    WebElement colorsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".colors select")));
    new Select(colorsDropdown).selectByVisibleText("Yellow");

    // 9 Assert that
    //   for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    WebElement waterCheckboxLog = wait.until(ExpectedConditions.visibilityOfElementLocated
      (By.xpath("//li[contains(text(),'Water: condition changed to true')]")));
    assertTrue(waterCheckboxLog.isDisplayed(), "Water checkbox log is not displayed");

    WebElement windCheckboxLog = wait.until(ExpectedConditions.visibilityOfElementLocated
      (By.xpath("//li[contains(text(),'Wind: condition changed to true')]")));
    assertTrue(waterCheckboxLog.isDisplayed(), "Wind checkbox log is not displayed");

    //   for radio button there is a log row and value is corresponded to the status of radio button
    WebElement selenRadioLog = wait.until(ExpectedConditions.visibilityOfElementLocated
      (By.xpath("//li[contains(text(),'metal: value changed to  Selen')]")));
    assertTrue(waterCheckboxLog.isDisplayed(), "Selen radio log is not displayed");

    //   for dropdown there is a log row and value is corresponded to the selected value
    WebElement dropdownColorsLog = wait.until(ExpectedConditions.visibilityOfElementLocated
      (By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]")));
    assertTrue(waterCheckboxLog.isDisplayed(), "Colors dropdown log is not displayed");

    //10 Close Browser
    // Done by tearDown method in the BaseTest class
  }
}
