package hw5.pages;

import hw5.components.Benefits;
import hw5.components.ButtonFrame;
import hw5.components.HeaderMenu;
import hw5.components.SideBarMenu;
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

  public void login(String username, String password){
    headerMenu.login(username, password);
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

  public List<String> getHeaderMenuText(){
    return headerMenu.getHeaderMenuElementsText();
  }

  public boolean isHeaderMenuItemsDisplayed(){ return headerMenu.isHeaderMenuItemsDisplayed(); }

  public int getBenefitImagesCount(){
    return benefits.getBenefitImagesNumber();
  }

  public int getBenefitTextsCount(){
    return benefits.getBenefitTextsNumber();
  }

  public List<String> getBenefitTexts(){
    return benefits.getBenefitTexts();
  }

  public boolean isBenefitIconsDisplayed(){
    return benefits.isBenefitIconsDisplayed();
  }

  public boolean isFrameDisplayed(){
    return buttonFrame.isFrameDisplayed();
  }

  public boolean isFrameButtonDisplayed(){
    return buttonFrame.isButtonDisplayed();
  }

  public void switchToFrame(){
    buttonFrame.switchToFrame();
  }

  public void switchToDefault(){
    buttonFrame.switchToDefaultWindow();
  }

  public boolean isSidebarElementsDisplayed(){
    return sideBarMenu.isSidebarElementsDisplayed();
  }

  public List<String> getSideBarMenuElementsText(){ return sideBarMenu.getSideBarMenuElementsText(); }

  public int getSidebarElementsCount(){
    return sideBarMenu.getSidebarElementsCount();
  }

  public void goToDifferentElementsPage(){ headerMenu.goToDifferentElementPage(); }
}
