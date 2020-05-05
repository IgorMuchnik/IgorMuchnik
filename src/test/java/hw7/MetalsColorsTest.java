package hw7;

import hw7.enums.HeaderMenuItem;
import hw7.models.MetalsColors;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MetalsColorsTest extends BaseTest {

  @Test(dataProvider = "dataset", dataProviderClass = MetalsColorsDataSet.class)
  public void metalAndColorsTest(MetalsColors data) {
    JDISite.homePage.openNewPageByHeaderMenu(HeaderMenuItem.METALS_AND_COLORS);
    JDISite.metalsColorsPage.checkOpened();
    JDISite.metalsColorsPage.fillAndSubmitMetalAndColorsForm(data);
    Assert.assertEquals(JDISite.metalsColorsPage.getResults(), data.getExpectedResults());
  }
}
