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
    public void verifyAPIBookOrder(String customerName, int bookId, int responseCode) {
        String body = RequestConfigurator.createCustomerModelInstance(customerName,bookId);
        Response response = APIRequestExecutor.completePostResponseWithAuthorization(body,  "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, responseCode);
    }

    @DataProvider(name = "data-provider")
    public Object[][] clientDataMethod() {
        return new Object[][]
                {
                        {TestData.generateRandomName(), 1, 201},
                };
    }
}
