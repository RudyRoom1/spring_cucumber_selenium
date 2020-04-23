package scan_comp.site.pages.search.impl;

import org.springframework.stereotype.Component;
import scan_comp.site.pages.AbstractPage;

@Component
public class GitHubSearchPage extends AbstractPage {

//  @Autowired
//  private DefaultBarComponent defaultBarComponent;

  @Override
  public String getUrl() {
    return "https://github.com/search";
  }

//  public DefaultBarComponent defaultBarComponent() {
//    this.waitForLoad();
//    return defaultBarComponent;
//  }
}
