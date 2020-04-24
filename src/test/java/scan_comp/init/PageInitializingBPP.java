package scan_comp.init;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import scan_comp.driver.DriverProvider;
import scan_comp.site.pages.Loadable;

@Component
public class PageInitializingBPP implements BeanPostProcessor {

  @Autowired
  private DriverProvider driverProvider;

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof Loadable) {
      PageFactory.initElements(driverProvider.getInstance(), bean);
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
