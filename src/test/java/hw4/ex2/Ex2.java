package hw4.ex2;

import hw4.BaseTest;
import hw4.dataModels.FormData;
import hw4.dataModels.User;
import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import hw4.pages.IndexPage;
import hw4.pages.MetalsColorsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class Ex2 extends BaseTest {

  private IndexPage indexPage;
  private MetalsColorsPage metalsColorsPage;
  private User user;

  @DataProvider
  public Object[][] testData() {
    return new Object[][]{
      {FormData.builder()
        .setElements(Arrays.asList(Elements.EARTH))
        .setColors(Colors.YELLOW)
        .setMetals(Metals.GOLD).build()},

      {FormData.builder()
        .setEven(8)
        .setOdd(3)
        .setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO)).build()},

      {FormData.builder()
        .setEven(2)
        .setOdd(3)
        .setElements(Arrays.asList(Elements.WATER, Elements.WIND, Elements.FIRE))
        .setMetals(Metals.BRONZE)
        .setVegetables(Arrays.asList(Vegetables.ONION)).build()},

      {FormData.builder()
        .setEven(6)
        .setOdd(5)
        .setElements(Arrays.asList(Elements.WATER))
        .setColors(Colors.GREEN)
        .setMetals(Metals.SELEN)
        .setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO,
          Vegetables.VEGETABLES, Vegetables.ONION)).build()},

        {FormData.builder()
          .setElements(Arrays.asList(Elements.FIRE))
          .setColors(Colors.BLUE)
          .setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES)).build()}
      };
  }

  @BeforeMethod
  public void initData() {
    indexPage = new IndexPage(driver);
    metalsColorsPage = new MetalsColorsPage(driver);
    user = User.builder()
      .setPassword(PASSWORD)
      .setName(USER)
      .build();
  }

  @Test(dataProvider = "testData")
  public void metalsColorsPageFuncTest(FormData form) {

    // 1 Open test site by URL
    openPage();
    assertEquals(indexPage.getBrowserTitle(), "Home Page");

    // 2 Perform login
    indexPage.login(user);

    // 3 Click on the link on the Header section
    indexPage.navigateToMetalsColorsPage();

    // 4 Fill form on the page
    metalsColorsPage.fillForm(form);

    // 5 Click “Submit” button
    metalsColorsPage.submitForm();

    // 6 Check Results block output on the right-side
    if (form.getEven() != 2 | form.getOdd() != 1) {
      int expectedSum = form.getEven() + form.getOdd();
      assertThat(metalsColorsPage.getSumResult()).isEqualTo(expectedSum);
    }
    if (!form.getElementsAsString().isEmpty()) {
      assertThat(metalsColorsPage.getElementsResult()).isEqualToIgnoringCase(form.getElementsAsString());
    }
    if (!form.getColors().equalsIgnoreCase(Colors.COLORS.toString())) {
      assertThat(metalsColorsPage.getColorResult()).isEqualToIgnoringCase(form.getColors());
    }
    if (!form.getMetals().equalsIgnoreCase(Metals.METALS.toString())) {
      assertThat(metalsColorsPage.getMetalResult()).isEqualToIgnoringCase(form.getMetals());
    }
    if (!form.getVegetablesAsString().equalsIgnoreCase(Vegetables.VEGETABLES.toString())) {
      assertThat(metalsColorsPage.getVegetableResult()).isEqualToIgnoringCase(form.getVegetablesAsString());
    }
  }

}
