package restapi;

import org.testng.annotations.DataProvider;
import ru.yandex.qatools.allure.annotations.Description;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ApiClientRegister extends BaseTest {

    @Test(priority = 2, dataProvider = "data-provider")
    @TestCaseId("TC_Test_Response_Elements_002")
    @Description("")
    @Features("Rest Assured Status Code")
    public void verifyAPIClientRegister(String clientName, String clientEmail, int responseCode) {
        String body = RequestConfigurator.createClientModelInstance(clientName, clientEmail);
        Response response = APIRequestExecutor.completePostResponseWithoutAuthorization(body, "api-clients");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, responseCode);
    }

    @DataProvider(name = "data-provider")
    public Object[][] clientDataMethod() {
        return new Object[][]
                {
                        {TestData.generateRandomName(), TestData.generateRandomEmail(), 201},
                        {"BA", "c@bn.nf", 201},
                        {"C", TestData.generateRandomEmail(), 400},
                        {TestData.generateRandomName(), "blablabla", 400},
                        {TestData.generateRandomName(), "a@b.c", 400},
                        {TestData.generateRandomName(), "$*&@gmail.com", 409},
                        {"", "", 400},
                        {null, null, 400}
                };
    }

}
