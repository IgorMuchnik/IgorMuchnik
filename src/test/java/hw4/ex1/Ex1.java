package hw4.ex1;

import hw4.BaseTest;
import hw4.dataModels.User;
import hw4.pages.IndexPage;
import hw4.pages.TablePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 extends BaseTest {

  private IndexPage indexPage;
  private TablePage tablePage;
  private User user;

  @BeforeMethod
  public void initData() {
    indexPage = new IndexPage(driver);
    tablePage = new TablePage(driver);
    user = User
      .builder()
      .setName(USER)
      .setPassword(PASSWORD)
      .build();
  }

  @Test
  public void endToEndTest() {
    // 1 Open test site by URL
    openPage();

    // 2 Assert Browser title
    assertEquals(indexPage.getBrowserTitle(), "Home Page");

    // 3 Perform login
    indexPage.login(user);

    // 4 Assert that user is logged
    assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
    assertTrue(indexPage.isUserNameDisplayed());

    // 5 Open through the header menu Service -&gt; Table with pages
    indexPage.navigateToTablePage();

    // 6 Check that default value for “Show entries” dropdown is 5
    assertEquals(tablePage.getDropdownValue(), "5");

    // 7 Select new value for the entries in the dropdown list
    tablePage.setDropdownValue("10");

    // 8 Assert that in the table displayed corrected amount of rows
    assertEquals(tablePage.getNumberOfTableRows(), 10);

    // 9 Type in “Search” field text "junit"
    String searchValue = "junit";
    tablePage.searchFor(searchValue);

    // 10 Assert the table contains only records with Search field value
    assertTrue(tablePage.isCorrectSearch("junit"));

  }
}
