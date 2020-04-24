package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import scan_comp.site.pages.home.impl.GitHubHomePage;
import scan_comp.site.pages.login.impl.GitHubLoginPage;
import scan_comp.site.pages.search.impl.GitHubSearchPage;
import spring.ApplicationConfig;
import spring.CustomTestExecutionListener;

@TestExecutionListeners(value = {CustomTestExecutionListener.class})
@ContextConfiguration(classes = ApplicationConfig.class)
@Scope("cucumber-glue")
public class StepDefs {

  @Autowired
  private GitHubHomePage homePage;

  @Autowired
  private GitHubSearchPage gitHubSearchPage;

  @Autowired
  private GitHubLoginPage gitHubLoginPage;

  //  private static final Logger logger = LoggerFactory.getLogger(CustomTestExecutionListener.class);
  @Given("^I open GitHub homePage$")
  public void iOpenGitHubHomePage() {
    homePage.openPage();
  }

  @Given("^Open GitHub home page$")
  public void iOpenGitHubSearchPage() {
    homePage.openPage();

  }

  @Then("^Type '(.*)' to the search field$")
  public void typeJAVAToTheSearchField(String searchMessage) {
    homePage.defaultBarComponent().searchFor(searchMessage);
  }

  @Then("^Go to login page$")
  public void goToLoginPage() {
    homePage.defaultBarComponent().goToLoginPage();
  }

  @And("^Enter credentials$")
  public void enterCredentials() {
    gitHubLoginPage.fillLoginFields();
  }

  @And("^check login is successful$")
  public void checkLoginIsSuccessful() {
    gitHubLoginPage.checkProfileName();
  }
}
