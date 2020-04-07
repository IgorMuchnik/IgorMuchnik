package hw2.ex1;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 extends BaseTest {

  @Test
  public void exercise1() {
    // 1 Open test site by URL
    openPage();

    // 2 Assert Browser title
    softAssert.assertEquals(driver.getTitle(), "Home Page", "Invalid title on the page");

    // 3 Perform login
    login("Roman", "Jdi1234");

    // 4 Assert Username is loggined
    softAssert.assertEquals(getUsername(), "ROMAN IOVLEV", "The login has not happened");

    // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
    softAssert.assertEquals(driver.findElements(By.cssSelector(".m-l8 > li")).size(), 4,
      "Invalid quantity of elements");
    softAssert.assertEquals(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"),
      driver.findElements(By.cssSelector(".m-l8 > li")).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList()),
      "Something wrong in headers");

    // 6 Assert that there are 4 images on the Index Page and they are displayed
    List<WebElement> images = driver.findElements(By.className("benefit-icon"));
    images.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
    softAssert.assertEquals(images.size(), 4, "Invalid quantity of images");

    // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
    softAssert.assertEquals(driver.findElements(By.className("benefit-txt")).size(),4,
      "Invalid quantity of benefit texts");
    String expectedTextUnderIcons = "To include good practices\n" +
                                    "and ideas from successful\n" +
                                    "EPAM project\n" +
                                    "To be flexible and\n" +
                                    "customizable\n" +
                                    "To be multiplatform\n" +
                                    "Already have good base\n" +
                                    "(about 20 internal and\n" +
                                    "some external projects),\n" +
                                    "wish to get more…";
    String actualTextUnderIcons = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("benefits"))).getText();
    softAssert.assertEquals(actualTextUnderIcons, expectedTextUnderIcons, "Invalid text under icons");

    // 8 Assert that there is the iframe with “Frame Button” exist
    WebElement iFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frame")));
    softAssert.assertTrue(iFrame.isDisplayed());

    // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
    driver.switchTo().frame("frame");
    WebElement iFrameButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("button-frame")));
    softAssert.assertTrue(iFrameButton.isDisplayed());

    // 10 Switch to original window back
    driver.switchTo().defaultContent();

    // 11 Assert that there are 5 items in the Left Section are displayed and they have proper text
    List<WebElement> sideBarMenu = driver.findElements(By.cssSelector(".sidebar-menu > li"));
    softAssert.assertEquals(sideBarMenu.size(), 5, "Invalid quantity of elements on sidebar");
    sideBarMenu.forEach(elem -> softAssert.assertTrue(elem.isDisplayed()));
    String expectedSideBarMenuText = "Home\n" +
      "Contact form\n" +
      "Service\n" +
      "Metals & Colors\n" +
      "Elements packs";
    String actualSideBarMenuText = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sidebar-menu")))
      .getText();
    softAssert.assertEquals(actualSideBarMenuText, expectedSideBarMenuText,
      "Wrong sidebar menu text");

    // 12 Close Browser
    // Done by tearDown method in the BaseTest class
    // And finally look up all the asserts
    softAssert.assertAll();
  }
}