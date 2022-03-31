package restapi;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ApiBookOrder extends BaseTest {


    @Test(priority = 3)
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIBookOrder() {
        String body = RequestConfigurator.createCustomerModelInstance();
        Response response = APIRequestExecutor.completePostResponseWithAuthorization(body,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }
}
