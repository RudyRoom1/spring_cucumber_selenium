package scan_comp.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {


  public static WebDriver getDriver(final DesiredCapabilities capabilities) {
    switch (capabilities.getBrowserName()) {
      case "FIREFOX": {
        // firefox
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
      }
      case "CHROME": {
        ChromeDriverManager.chromedriver().setup();
        return new ChromeDriver();
      }
      default:
        throw new IllegalArgumentException("Invalid browser name: " + capabilities);
    }
  }

}

