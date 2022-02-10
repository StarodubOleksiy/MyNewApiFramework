package restapi;


import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;

/**
 * Created by Oleksiy on 14/12/2020.
 */

/**
 * Here is just some rest-assured tests
 */


public class TestResponse {

    ApplicationConfigReader reader;
    JSONObject requestParams = null;
    static Response response;
    static RequestSpecification httpRequest = null;

    @BeforeTest
    public void beforeTest() {
        reader = new ApplicationConfigReader();
    }

    @Test(priority = 1)
    @TestCaseId("TC_Test_Response_Elements_001")
    @Description("Check status code.")
    @Features("Rest Assured Status Code")
    public void test1VerifySucccessfullGetStatusCode() {
        response = completeResponse(Method.GET, "status");
        Assert.assertEquals(response.getStatusCode(), 200);//Checking if sign in to get response elemets was successfull
    }


    @Test
    @TestCaseId("TC_Test_Response_Elements_002")
    @Description("")
    @Features("Rest Assured Status Code")
    public void test2() {
        requestParams.put("clientName", Utils.generateRandomName());
        requestParams.put("clientEmail", Utils.generateRandomEmail());
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        response = completeResponse(Method.POST, "api-clients");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void test3() {
        requestParams.put("customerName", "Randolph Bruen");
        requestParams.put("bookId", 1);
        httpRequest.headers("Authorization", "Bearer " + Utils.getAccessToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        response = completeResponse(Method.POST, "orders");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @BeforeMethod
    public void beforeMethod() {
        httpRequest = RestAssured.given();
        requestParams = new JSONObject();
    }

    @AfterMethod
    public void afterMethod() {
        httpRequest = null;
        requestParams = null;
    }

    private Response completeResponse(Method method, String urn) {
        return httpRequest.request(method, Utils.getUrlLink(urn));
    }

}
