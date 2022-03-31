package restapi;

import ru.yandex.qatools.allure.annotations.Description;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ApiClientRegister extends BaseTest {

    @Test(priority = 2)
    @TestCaseId("TC_Test_Response_Elements_002")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIClientRegister() {
        String body = RequestConfigurator.createClientModelInstance();
        Response response = APIRequestExecutor.completePostResponseWithoutAuthorization(body, "api-clients");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

}
