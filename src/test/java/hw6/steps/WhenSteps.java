package hw6.steps;

import hw6.pages.DifferentElementsPage;
import hw6.pages.UserTablePage;
import hw6.utils.WebDriverSingleton;
import io.cucumber.java.en.When;

import java.util.List;

public class WhenSteps {
  private DifferentElementsPage differentElementsPage;
  private UserTablePage userTablePage;

  @When("I set checkboxes")
  public void iSelectCheckboxesOnDifferentElementsPage(List<String> checkboxes) {
    differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
    checkboxes = checkboxes.subList(1, checkboxes.size());
    checkboxes.forEach(e -> differentElementsPage.setCheckBox(e));
  }

  @When("I set radio {string}")
  public void iSelectRadioOnDifferentElementsPage(String radio) {
    differentElementsPage.setRadio(radio);
  }

  @When("I set dropdown {string}")
  public void iSelectDropdownOnDifferentElementsPage(String color) {
    differentElementsPage.setColorDropDown(color);
  }

  @When("I set 'vip' checkbox for {string}")
  public void iSetCheckbox(String username) {
    userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    userTablePage.setVipCheckbox(username);
  }
}
