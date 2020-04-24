package scan_comp.site.pages.login.impl;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scan_comp.site.pages.AbstractPage;
import spring.CustomTestExecutionListener;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class GitHubLoginPage extends AbstractPage implements LoginPage {
  private static final Logger logger = LoggerFactory.getLogger(GitHubLoginPage.class);

  @FindBy(id = "login_field")
  WebElement loginField;
  @FindBy(id = "password")
  WebElement passwordField;
  @FindBy(name = "commit")
  WebElement submitButton;
  @FindBy(xpath = "//div[@class='Header-item position-relative mr-0 d-none d-lg-flex']//span[@class='dropdown-caret']")
  WebElement profileTrigger;
  @FindBy(xpath = "//div[@class='header-nav-current-user css-truncate']/child::a[@href='/TestRepo-rp5']")
  WebElement profileHeader;

  @Value("${login}")
  private String login;

  @Value("${password}")
  private String password;

  @Override
  public String getUrl() {
    return "https://github.com/login";
  }

//  @Override
//  public WebElement getLoadableElement() {
//    return null;
//  }

  @Override
  public void fillLoginFields() {
    loginField.sendKeys(login);
    passwordField.sendKeys(password);
    submitButton.click();
  }

  private String getProfileName() {
    profileTrigger.click();
    return profileHeader.getText();
  }

  public void checkProfileName() {
    SoftAssertions softly = new SoftAssertions();
    String profileName = getProfileName();
    softly.assertThat(profileName)
        .as(String.format("Expected profile name: %s \nActual profile name: %s", login, profileName))
        .isEqualTo(login);
    logger.info("Expected profile name: {}\nActual profile name: {}",login, profileName);
  }
}
