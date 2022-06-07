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


    @Test(priority = 3, dataProvider = "data-provider")
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIBookOrder(String token, String customerName, int bookId, int responseCode) {
        String body = RequestConfigurator.createCustomerModelInstance(customerName,bookId);
        Response response = APIRequestExecutor.completePostResponseWithAuthorization(token,body,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, responseCode);
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
                        {"invalid token",TestData.generateRandomName(), 2, 401},
                        {"Bearer blblblbl",TestData.generateRandomName(), 2, 401}
                };
    }
}
