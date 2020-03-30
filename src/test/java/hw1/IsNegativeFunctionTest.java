package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsNegativeFunctionTest extends BaseTest {

  @DataProvider
  public Object[][] dataProvider(){
    return new Object[][] {
      {0, false},
      {-1, true},
      {1, false}
    };
  }

  @Test(dataProvider = "dataProvider")
  public void isNegativeCheckNumbers(long number, boolean expectedResult){

    boolean actualResult = calculator.isNegative(number);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }

}
