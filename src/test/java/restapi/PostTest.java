package restapi;

import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class PostTest extends BaseTest {

    @Test(priority = 1)
    @TestCaseId("TC_Test_Response_Elements_002")
    @Description("")
    @Features("Rest Assured Status Code")
    public void test1VerifyAPIClientRegister() {
        RequestSpecification httpRequest = RequestHeaderConfigurator.createHttpRequestWithoutAuthorization();
        httpRequest.body(RequestConfigurator.createClientModelInstance());
        Response response = APIRequestExecutor.completePostResponse(httpRequest, "api-clients");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test(priority = 2)
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void test2VerifyAPIBookOrder() {
        RequestSpecification httpRequest = RequestHeaderConfigurator.createHttpRequestWithAuthorization();
        httpRequest.body(RequestConfigurator.createCustomerModelInstance());
        Response response = APIRequestExecutor.completePostResponse(httpRequest,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }
}
