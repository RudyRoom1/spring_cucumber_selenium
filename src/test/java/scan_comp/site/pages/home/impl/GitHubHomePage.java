package scan_comp.site.pages.home.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scan_comp.site.components.impl.DefaultBarComponent;
import scan_comp.site.pages.AbstractPage;

@Component
public class GitHubHomePage extends AbstractPage {

  @Autowired
  private DefaultBarComponent defaultBarComponent;

  @Override
  public String getUrl() {
    return "https://github.com/";
  }

  public DefaultBarComponent defaultBarComponent() {
    this.waitForLoad();
    return defaultBarComponent;
  }

}
