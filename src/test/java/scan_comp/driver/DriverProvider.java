package scan_comp.driver;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import java.util.concurrent.TimeUnit;
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
//  @Scope(SCOPE_CUCUMBER_GLUE)
  public WebDriver getInstance() {
    if (driverInstance.get() == null) {
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      desiredCapabilities.setBrowserName(browserName);
      driverInstance.set(DriverFactory.getDriver(desiredCapabilities));
      driverInstance.get().manage().window().maximize();
      driverInstance.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    return driverInstance.get();
  }

}
