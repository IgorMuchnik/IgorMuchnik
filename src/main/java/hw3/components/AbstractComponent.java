package hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

  protected WebDriver driver;
  protected WebDriverWait wait;

  public AbstractComponent(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 5);
    PageFactory.initElements(driver, this);
  }
}
