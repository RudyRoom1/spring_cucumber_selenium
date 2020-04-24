package scan_comp.site.components.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scan_comp.site.components.AbstractComponent;
import scan_comp.site.components.HomeComponent;

@Component
@Scope("cucumber-glue")
public class DefaultBarComponent extends AbstractComponent implements
    HomeComponent {

  @FindBy(xpath = "//input[@data-unscoped-placeholder='Search GitHub']")
  WebElement searchInput;

  @FindBy(xpath = "//a[@class='HeaderMenu-link no-underline mr-3']")
  WebElement singInButton;

  @FindBy(xpath = "//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']")
  WebElement singUpButton;

  public WebElement getSearchInput() {
    return searchInput;
  }

  public WebElement getSingInButton() {
    return singInButton;
  }

  public WebElement getSingUpButton() {
    return singUpButton;
  }

  @Override
  public void searchFor(String query) {
    this.waitForLoad();
    searchInput.sendKeys(query);
    searchInput.submit();
  }

  public void goToLoginPage(){
    this.waitForLoad();
    singInButton.click();
  }

  @Override
  public WebElement getLoadableElement() {
    return searchInput;
  }
}
