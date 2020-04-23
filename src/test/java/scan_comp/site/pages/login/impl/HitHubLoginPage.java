package scan_comp.site.pages.login.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import scan_comp.site.pages.AbstractPage;
import scan_comp.site.pages.Page;

@Component
public class HitHubLoginPage extends AbstractPage implements Page {

  @FindBy(id = "login_field")
  WebElement loginField;
  @FindBy(id = "password")
  WebElement passwordField;
  @FindBy(name = "commit")
  WebElement submitButton;

  @Override
  public String getUrl() {
    return "https://github.com/login";
  }
}
