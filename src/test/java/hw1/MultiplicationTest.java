package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest extends BaseTest {

  @DataProvider
  public Object[][] dataProviderLongNumbers(){
    return new Object[][] {
      {1, 2, 2},
      {0, 1, 0},
      {111, 4, 444},
      {-5, -10, 50}
    };
  }

  @Test(dataProvider = "dataProviderLongNumbers")
  public void multiplyTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult){

    long actualResult = calculator.mult(firstNumber, secondNumber);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }

  @DataProvider
  public Object[][] dataProviderDoubleNumbers(){
    return new Object[][] {
      {1., -2., -2.},
      {0., 0.5, 0.},
      {111.111, 4, 444.444}
    };
  }

  @Test(dataProvider = "dataProviderDoubleNumbers")
  public void multiplyTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult){

    double actualResult = calculator.mult(firstNumber, secondNumber);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }
}
