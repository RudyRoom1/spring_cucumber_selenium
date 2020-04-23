package scan_comp.site.components.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import scan_comp.site.components.HomeComponent;
import scan_comp.site.components.AbstractComponent;

@Component
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
  public String getName() {
    return null;
  }

  @Override
  public void SearchFor(String query) {
    this.waitForLoad();
    searchInput.sendKeys(query);
    searchInput.submit();
  }
}
