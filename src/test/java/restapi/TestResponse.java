package restapi;


import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.tools.ant.types.Assertions;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import restapi.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ru.yandex.qatools.allure.annotations.*;

import static io.restassured.RestAssured.given;

/**
 * Created by Oleksiy on 14/12/2020.
 */

/**
 * Here is just some rest-assured tests
 */


public class TestResponse {

    ApplicationConfigReader reader = new ApplicationConfigReader();// Creating instace of class that has important login data
    static Response response = null;


    @Test(priority = 1)
    @TestCaseId("TC_Test_Response_Elements_001")
    @Description("Check status code.")
    @Features("Rest Assured Status Code")
    public void test1VerifySucccessfullGetStatusCode() {
        response = given().request(Method.GET, Utils.getUrlLink("status"));
        Assert.assertEquals(response.getStatusCode(), 200);//Checking if sign in to get response elemets was successfull
    }


     @Test
    public void test2() {
        RequestSpecification httpRequest;
        Response response;
        httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("clientName", Utils.generateRandomName());
        requestParams.put("clientEmail", Utils.generateRandomName() + ".Towne@gmail.com"); // Cast
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());//Utils.getUrlLink("orders") api-clients/
        response = httpRequest
               .request(Method.POST, Utils.getUrlLink("api-clients"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
          }

    @Test
    @TestCaseId("TC_Test_Response_Elements_002")
    @Description("")
    @Features("Rest Assured Status Code")
    public void test3() { //https://simple-books-api.glitch.me/orders
        RequestSpecification httpRequest;
        Response response;
        httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("customerName", "Randolph Bruen");
        requestParams.put("bookId", 1); // Cast
        httpRequest.headers("Authorization", "Bearer " + Utils.getAccessToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.request(Method.POST, Utils.getUrlLink("orders"));
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 201);
    }

}
