package restapi;

import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class TestVerifySuccessfullStatusCode extends BaseTest {

    @Test(priority = 1)
    @TestCaseId("TC_Test_Response_Elements_001")
    @Description("Check status code.")
    @Features("Rest Assured Status Code")
    public void verifyAPISuccessfullStatusCode() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = APIRequestExecutor.completeGetResponse(httpRequest,  "status");
        Assert.assertEquals(response.getStatusCode(), 200);//Checking if sign in to get response elemets was successfull
    }
}
