package hw7.components;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw7.models.User;

public class LoginForm extends Form<User> {
  @FindBy(css = "#name")
  private TextField login;

  @FindBy(css = "#password")
  private TextField password;

  @FindBy(css = "#login-button")
  private Button submit;
}
