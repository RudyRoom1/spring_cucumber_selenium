package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import scan_comp.driver.DriverProvider;

public class Hooks {

  @Autowired
  private DriverProvider driverProvider;

  @Before
  public void init(){

  }

//  @After
//  public void tearDown(){
//    driverProvider.getInstance().close();
//  }

}
