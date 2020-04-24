package scan_comp.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DriverProvider {

  @Value("${browser}")
  private String browserName;

  private ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

  @Bean(destroyMethod = "quit")
  @Scope("singleton")
  public WebDriver getInstance() {
    if (driverInstance.get() == null) {
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      desiredCapabilities.setBrowserName(browserName);
      driverInstance.set(DriverFactory.getDriver(desiredCapabilities));
      driverInstance.get().manage().window().maximize();
    }
    return driverInstance.get();
  }

}
