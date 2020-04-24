package scan_comp.site.pages;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public abstract class AbstractPage extends AbstractLoadable implements Page {

  @Override
  public void openPage() {
    driverProvider.getInstance().get(getUrl());
  }

//  @Override
//  public void closePage(){
//    driverProvider.c
//  }

}
