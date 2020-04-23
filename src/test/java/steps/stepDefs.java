package steps;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import scan_comp.site.pages.home.impl.GitHubHomePage;
import scan_comp.site.pages.search.impl.GitHubSearchPage;
import spring.ApplicationConfig;
import spring.CustomTestExecutionListener;

@TestExecutionListeners(value = {CustomTestExecutionListener.class})
@ContextConfiguration(classes = ApplicationConfig.class)
public class stepDefs {

  @Autowired
  private GitHubHomePage homePage;

  @Autowired
  private GitHubSearchPage gitHubSearchPage;

  //  private static final Logger logger = LoggerFactory.getLogger(CustomTestExecutionListener.class);
  @Given("^I open GitHub homePage$")
  public void iOpenGitHubHomePage() {
    homePage.openPage();
  }

  @Given("^I open GitHub search page$")
  public void iOpenGitHubSearchPage() {
    gitHubSearchPage.openPage();
  }
}
