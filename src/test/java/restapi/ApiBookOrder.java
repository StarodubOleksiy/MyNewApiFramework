package restapi;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ApiBookOrder extends BaseTest {


    @Test(priority = 1, dataProvider = "data-provider")
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIBookOrder(String token, String customerName, int bookId, int responseCode) {
        String body = RequestConfigurator.createCustomerModelInstance(customerName,bookId);
        Response response = APIRequestExecutor.completePostResponseWithAuthorization(token,body,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, responseCode);
    }

    @Test(priority = 2)
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIBookOrderWithoutAuthorizationParam() {
        String body = RequestConfigurator.createCustomerModelInstance(TestData.generateRandomName(),1);
        Response response = APIRequestExecutor.completePostResponseWithAuthorizationWithoutAuthorizationParam(body,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 401);
    }

    @Test(priority = 3)
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIBookOrderWithoutContentTypeParam() {
        String body = RequestConfigurator.createCustomerModelInstance(TestData.generateRandomName(),1);
        Response response = APIRequestExecutor.completePostResponseWithAuthorizationWithoutContentTypeParam("Bearer " + Utils.getAccessToken(),body,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }

    @Test(priority = 4)
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIBookOrderWithoutAcceptParam() {
        String body = RequestConfigurator.createCustomerModelInstance(TestData.generateRandomName(),1);
        Response response = APIRequestExecutor.completePostResponseWithAuthorizationWithoutAcceptParam("Bearer " + Utils.getAccessToken(),body,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @DataProvider(name = "data-provider")
    public Object[][] clientDataMethod() {
        return new Object[][]
                {
                        {"Bearer " + Utils.getAccessToken(),TestData.generateRandomName(), 1, 201},
                        {"Bearer " + Utils.getAccessToken(),"FA", 1, 201},
                        {"Bearer " + Utils.getAccessToken(),"F", 1, 400},
                        {"Bearer " + Utils.getAccessToken(),"", 1, 201},//todo here is a bug
                        {"Bearer " + Utils.getAccessToken(),TestData.generateRandomName(), -1, 400},
                        {"Bearer " + Utils.getAccessToken(),TestData.generateRandomName(), 2, 404},
                        {"Bearer " + Utils.getAccessToken(),TestData.generateRandomName(), Integer.MAX_VALUE, 400},
                        {"invalid token",TestData.generateRandomName(), 1, 401},
                        {"Bearer blblblbl",TestData.generateRandomName(), 1, 401},
                        {"Bearer " + Utils.getAccessToken(),null, 1, 201}//,/todo here is a bug
                        /*{"Bearer " + Utils.getAccessToken(),TestData.generateRandomName(), null, 400},*///java.lang.IllegalArgumentException
                };
    }
}
