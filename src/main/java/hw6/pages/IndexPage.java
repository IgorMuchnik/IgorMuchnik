package hw6.pages;

import hw6.components.Benefits;
import hw6.components.ButtonFrame;
import hw6.components.HeaderMenu;
import hw6.components.SideBarMenu;
import hw6.dataModels.User;
import org.openqa.selenium.WebDriver;

public class IndexPage extends AbstractPage {

  public IndexPage(WebDriver driver) {
    super(driver);
    this.headerMenu = new HeaderMenu(driver);
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

  public void navigateToDifferentElementsPage(){ headerMenu.navigateToDifferentElementPage(); }

  public void navigateToUserTablePage(){ headerMenu.navigateToUserTablePage(); }
}