package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class DivisionTest extends BaseTest {

  @DataProvider
  public Object[][] dataProviderLongNumbers(){
    return new Object[][] {
      {4, 2, 2},
      {0, 1, 0},
      {-5, 10, 0}
    };
  }

  @Test(dataProvider = "dataProviderLongNumbers")
  public void divideTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult){

    long actualResult = calculator.div(firstNumber, secondNumber);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }

  @DataProvider
  public Object[][] dataProviderDoubleNumbers(){
    return new Object[][] {
      {6., -3., -2.},
      {0., 0.5, 0.},
      {444.444, 4, 111.111}
    };
  }

  @Test(dataProvider = "dataProviderDoubleNumbers")
  public void divideTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult){

    double actualResult = calculator.div(firstNumber, secondNumber);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }

  @DataProvider
  public Object[][] dataProviderLongDivisionByZero(){
    return new Object[][] {
      {6, 0}
    };
  }

  @Test(dataProvider = "dataProviderLongDivisionByZero")
  public void longDivisionByZero(long firstNumber, long secondNumber){
    assertThrows(Exception.class, () -> calculator.div(firstNumber, secondNumber));
  }

  @DataProvider
  public Object[][] dataProviderDoubleDivisionByZero(){
    return new Object[][] {
      {6., 0.}
    };
  }

  @Test(dataProvider = "dataProviderDoubleDivisionByZero")
  public void doubleDivisionByZero(double firstNumber, double secondNumber){
    assertThrows(Exception.class, () -> calculator.div(firstNumber, secondNumber));
  }

}
