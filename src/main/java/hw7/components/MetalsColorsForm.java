package hw7.components;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw7.enums.Vegetables;
import hw7.models.MetalsColors;

public class MetalsColorsForm {
  @UI("[name=custom_radio_odd]")
  private RadioButtons oddSummary;

  @UI("[name=custom_radio_even]")
  private RadioButtons evenSummary;

  @FindBy(xpath = "//p[@class='checkbox'][contains(., '%s')]//label")
  private UIElement elements;

  @JDropdown(root = "#colors",
    value = ".filter-option",
    list = "li",
    expand = ".caret")
  private Dropdown colors;

  @JDropdown(root = "#metals",
    value = ".filter-option",
    list = "li",
    expand = ".caret")
  private Dropdown metals;

  @JDropdown(root = "#vegetables",
    value = ".filter-option",
    list = "li",
    expand = ".caret")
  private Dropdown vegetables;

  @FindBy(css = "#submit-button")
  private Button submit;

  public void fillForm(MetalsColors data) {
    oddSummary.select(String.valueOf(data.getOddSummaryNumber()));
    evenSummary.select(String.valueOf(data.getEvenSummaryNumber()));
    data.getElements().forEach(el -> elements.select(el));
    colors.select(data.getColor());
    metals.select(data.getMetal());
    uncheckedDefaultValue();
    data.getVegetables().forEach(v -> vegetables.select(v));
  }

  public void submitForm() {
    submit.click();
  }

  private void uncheckedDefaultValue() {
    vegetables.select(Vegetables.VEGETABLES.getVegetable());
  }
}
