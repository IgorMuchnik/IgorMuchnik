package hw3.ex2;

import hw3.BaseTest;
import hw3.pages.SimpleElementsPage;
import hw3.pages.IndexPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Ex2 extends BaseTest {

  @Test
  public void differentElementPageFunctionalityTest() {

    // 1 Open test site by URL
    openPage();
    IndexPage indexPage = new IndexPage(driver);

    // 2 Assert Browser title
    assertEquals(indexPage.getBrowserTitle(), "Home Page");

    // 3 Perform login
    indexPage.login(USER, PASSWORD);

    // 4 Assert Username is logged
    assertTrue(indexPage.isUserNameDisplayed());
    assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");

    // 5 Open through the header menu Service -> Different Elements Page
    WebDriverWait wait = new WebDriverWait(driver, 5);
    indexPage.goToDifferentElementsPage();

    // 6 Select checkboxes "Water", "Wind"
    String checkBoxOne = "Water";
    String checkBoxTwo = "Wind";
    SimpleElementsPage simpleElementsPage = new SimpleElementsPage(driver);
    simpleElementsPage.setCheckBox(checkBoxOne);
    simpleElementsPage.setCheckBox(checkBoxTwo);

    // 7 Select radio "Selen"
    String radio = "Selen";
    simpleElementsPage.setRadio(radio);

    // 8 Select in dropdown "Yellow"
    String color = "Yellow";
    simpleElementsPage.setColorDropDown(color);

    // 9 Assert that
    //   for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    assertTrue(simpleElementsPage.isCheckboxLogDisplayed(checkBoxOne, "true"));
    assertTrue(simpleElementsPage.isCheckboxLogDisplayed(checkBoxTwo, "true"));

    //   for radio button there is a log row and value is corresponded to the status of radio button
    assertTrue(simpleElementsPage.isRadioLogDisplayed(radio));

    //   for dropdown there is a log row and value is corresponded to the selected value
    assertTrue(simpleElementsPage.isDropdownLogDisplayed(color));
  }
}
