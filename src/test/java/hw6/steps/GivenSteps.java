package hw6.steps;

import hw6.dataModels.User;
import hw6.pages.IndexPage;
import hw6.utils.WebDriverSingleton;
import io.cucumber.java.en.Given;

public class GivenSteps {

  private IndexPage indexPage;

  @Given("I open JDI GitHub site")
  public void iAmOnIndexPage() {
    WebDriverSingleton.INSTANCE.getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
    indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
  }

  @Given("I login as username: {string} pass: {string}")
  public void iLoginOnIndexPage(String username, String pass) {
    indexPage.login(User.builder().setPassword(pass).setName(username).build());
  }

  @Given("I navigate to Different Elements page through \"Service\" button in Header")
  public void iOpenDifferentElementsPageThroughHeaderOnIndexPage() {
    indexPage.navigateToDifferentElementsPage();
  }

  @Given("I navigate to User Table page through \"Service\" button in Header")
  public void iOpenUserTablePageThroughHeaderOnIndexPage() {
    indexPage.navigateToUserTablePage();
  }

}
