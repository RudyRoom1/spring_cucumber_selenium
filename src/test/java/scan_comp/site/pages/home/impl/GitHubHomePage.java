package scan_comp.site.pages.home.impl;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scan_comp.site.components.impl.DefaultBarComponent;
import scan_comp.site.pages.AbstractPage;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class GitHubHomePage extends AbstractPage {

  @Autowired
  private DefaultBarComponent defaultBarComponent;

  @FindBy(xpath = "//input[@data-unscoped-placeholder='Search GitHub']/..")
  WebElement searchInput;

  @Override
  public String getUrl() {
    return "https://github.com/";
  }

  public DefaultBarComponent defaultBarComponent() {
    this.waitForLoad();
    return defaultBarComponent;
  }

  @Override
  public WebElement getLoadableElement() {
    return searchInput;
  }
}
