package scan_comp.site.pages;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPage extends AbstractLoadable implements Page {

  @Override
  public void openPage() {
    driverProvider.getInstance().get(getUrl());
  }

}
