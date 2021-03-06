package hw5.ex1;

import hw5.BaseTest;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.IndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("End to end test on different elements page")
public class Ex2 extends BaseTest {

  private IndexPageSteps indexPageSteps;
  private DifferentElementsPageSteps differentElementsPageSteps;

  @BeforeMethod
  public void init() {
    indexPageSteps = new IndexPageSteps(driver);
    differentElementsPageSteps = new DifferentElementsPageSteps(driver);
  }


  @Story("Verify all the selectors on page")
  @Test
  public void differentElementPageFunctionalityTest() {
    // 1 Open test site by URL
    indexPageSteps.open();

    // 2 Assert Browser title
    indexPageSteps.browserTitleShouldBe("Home Page");

    // 3 Perform login
    indexPageSteps.login(USER, PASSWORD);

    // 4 Assert Username is logged
    indexPageSteps.usernameShouldBeDisplayed();
    indexPageSteps.headerMenuShouldHaveSize(4);
    indexPageSteps.usernameShouldBe("ROMAN IOVLEV");

    // 5 Open through the header menu Service -> Different Elements Page
    indexPageSteps.goToDifferentElementsPage();

    // 6 Select checkboxes "Water", "Wind"
    String checkBoxOne = "Water";
    String checkBoxTwo = "Wind";
    differentElementsPageSteps.checkCheckbox(checkBoxOne);
    differentElementsPageSteps.checkCheckbox(checkBoxTwo);

    // 7 Select radio "Selen"
    String radio = "Selen";
    differentElementsPageSteps.checkRadio(radio);

    // 8 Select in dropdown "Yellow"
    String dropdownColor = "Yellow";
    differentElementsPageSteps.setColorDropdownTo(dropdownColor);

    // 9 Assert that
    //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbo
    differentElementsPageSteps.individualLogRowForCheckboxShouldBe(checkBoxOne, "true");
    differentElementsPageSteps.individualLogRowForCheckboxShouldBe(checkBoxTwo, "true");

    //    • for radio button there is a log row and value is corresponded to the status of radio button
    differentElementsPageSteps.individualLogRowForRadioShouldBeDisplayed(radio);

    //    • for dropdown there is a log row and value is corresponded to the selected value
    differentElementsPageSteps.individualLogRowForDropdownShouldBeDisplayed(dropdownColor);
  }
}
