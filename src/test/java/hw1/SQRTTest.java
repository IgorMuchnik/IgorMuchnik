package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class SQRTTest extends BaseTest {

  @DataProvider
  public Object[][] dataProviderPositiveNumbers(){
    return new Object[][] {
      {4., 2.},
      {0., 0.0},
      {36., 6}
    };
  }

  @Test(dataProvider = "dataProviderPositiveNumbers")
  public void sqrtPositiveNumbers(double number, double expectedResult){

    double actualResult = calculator.sqrt(number);

    assertEquals(actualResult, expectedResult, "Test failed because");
  }

  @DataProvider
  public Object[][] dataProviderNegativeNumber(){
    return new Object[][] {
      {-25}
    };
  }

  @Test(dataProvider = "dataProviderNegativeNumber")
  public void sqrtNegativeNumbers(double number){
    assertThrows(Exception.class, () -> calculator.sqrt(number));
  }

}
