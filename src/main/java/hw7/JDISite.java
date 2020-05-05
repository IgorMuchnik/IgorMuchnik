package hw7;

import hw7.pages.HomePage;
import hw7.pages.MetalsColorsPage;

public class JDISite {
  public static HomePage homePage;
  public static MetalsColorsPage metalsColorsPage;

  private JDISite() {}

  public static void open() {
    homePage.open();
  }
}
