package hw4.pages;

import hw4.components.Benefits;
import hw4.components.ButtonFrame;
import hw4.components.HeaderMenu;
import hw4.components.SideBarMenu;
import hw4.dataModels.User;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class IndexPage extends AbstractPage {

  private Benefits benefits;
  private ButtonFrame buttonFrame;

  public IndexPage(WebDriver driver) {
    super(driver);
    this.headerMenu = new HeaderMenu(driver);
    this.benefits = new Benefits(driver);
    this.buttonFrame = new ButtonFrame(driver);
    this.sideBarMenu = new SideBarMenu(driver);
  }

  public void login(User user){
    headerMenu.login(user.getName(), user.getPassword());
  }

  public boolean isUserNameDisplayed(){
    return headerMenu.isUserNameDisplayed();
  }

  public String getUserName(){
    return headerMenu.getUserName();
  }

  public String getBrowserTitle(){
    return driver.getTitle();
  }

  public void navigateToTablePage() {  headerMenu.navigateToTablePage(); }

  public void navigateToMetalsColorsPage() {  headerMenu.navigateToMetalsColorsPage(); }
}
