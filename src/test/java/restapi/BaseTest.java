package restapi;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    ApplicationConfigReader reader;

    @BeforeSuite
    public void beforeTest() {
        reader = new ApplicationConfigReader();
    }

}
