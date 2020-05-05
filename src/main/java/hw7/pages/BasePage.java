package hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.components.LoginForm;
import hw7.enums.HeaderMenuItem;
import hw7.models.User;
import org.hamcrest.Matchers;

public class BasePage extends WebPage {
  private LoginForm loginForm;

  @Css("#user-name")
  private Label userName;

  @Css("#user-icon")
  private Button userIcon;

  @Css(".m-l8 > li")
  private Menu headerMenu;

  public void login(User user) {
    userIcon.click();
    loginForm.login(user);
  }

  public void checkLoggedIn(User user) {
    userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
  }

  public void openNewPageByHeaderMenu(HeaderMenuItem item) {
    clickOnHeaderMenuItem(item);
  }

  private void clickOnHeaderMenuItem(HeaderMenuItem item){
    headerMenu.select(item.getName());
  }
}
