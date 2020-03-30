package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdditionTest extends BaseTest {

  @DataProvider
  public Object[][] dataProviderLongNumbers(){
    return new Object[][] {
      {1, 2, 3},
      {0, 1, 1},
      {123, 321, 444},
      {-5, -10, -15}
    };
  }

  @Test(dataProvider = "dataProviderLongNumbers")
  public void sumTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult){

    long actualResult = calculator.sum(firstNumber, secondNumber);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }

  @DataProvider
  public Object[][] dataProviderDoubleNumbers(){
    return new Object[][] {
      {1., 2., 3.},
      {0., 0.5, 0.5},
      {123.123, 321.321, 444.444}
    };
  }

  @Test(dataProvider = "dataProviderDoubleNumbers")
  public void sumTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult){

    double actualResult = calculator.sum(firstNumber, secondNumber);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }
}
