package scan_comp.site.pages;

import scan_comp.driver.DriverProvider;
import io.vavr.control.Try;
import java.util.concurrent.TimeUnit;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public abstract class AbstractLoadable implements Loadable {

  private static final long DEFAULT_TIMEOUT = 10;
  private static final long SHORT_TIMEOUT = 2;

  @Autowired
  protected DriverProvider driverProvider;

//  protected void getUrl(String url){
//    scan_comp.driver.get(url);
//  }

  @Override
  public WebElement getLoadableElement() {
    return null;
  }

  @Override
  public boolean isLoaded() {
    return Try.of(() -> getDriverWait(SHORT_TIMEOUT)
        .until(ExpectedConditions.elementToBeClickable(getLoadableElement()))).isSuccess();
  }

  @Override
  public void waitForLoad() {
    getDriverWait(DEFAULT_TIMEOUT)
        .until(ExpectedConditions.elementToBeClickable(getLoadableElement()));
  }

  @Override
  public void waitForDisappear() {
    getDriverWait(DEFAULT_TIMEOUT)
        .until(ExpectedConditions.invisibilityOf(getLoadableElement()));
  }

  public FluentWait<WebDriver> getDriverWait(long duration) {
    return new WebDriverWait(driverProvider.getInstance(), duration)
        .pollingEvery(500, TimeUnit.MILLISECONDS);
  }

}
