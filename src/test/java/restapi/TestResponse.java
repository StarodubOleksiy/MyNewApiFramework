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
    public void test1VerifyStatusCode() {
        response = given().request(Method.GET, new StringBuilder(reader.getBaseURL()).append("status").toString());
        Assert.assertEquals(response.getStatusCode(), 200);//Checking if sign in to get response elemets was successfull
    }

    /*
    * {
      "bookId": 1,
      "customerName": "Randolph Bruen"
    }
    * */
    @Test//https://simple-books-api.glitch.me/
    @TestCaseId("TC_Test_Response_Elements_002")
    @Description("")
    @Features("Rest Assured Status Code")
    public void test2() { //https://simple-books-api.glitch.me/orders
        final String accessToken = getAccessToken();
        System.out.println("accessToken = " + accessToken);
        RestAssured.baseURI = reader.getBaseURL();
        RequestSpecification httpRequest;
        Response response;
        httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("customerName", "Randolph Bruen");
        requestParams.put("bookId", 1); // Cast
        httpRequest.headers("Authorization", "Bearer " + accessToken,
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest
                .request(Method.POST, "orders");
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 201);
    }

    /*
    * {
  "clientName": "Dina",
  "clientEmail": "Phoebe.Walter@yahoo.com"
}
    * */

    @Test//https://simple-books-api.glitch.me/
    @TestCaseId("TC_Test_Response_Elements_003")
    @Description("")
    @Features("Rest Assured Status Code")
    public void test3() {//https://simple-books-api.glitch.me/api-clients/
        response = given().request(Method.GET, new StringBuilder(reader.getBaseURL()).append("status").toString());
        Assert.assertEquals(response.getStatusCode(), 200);//Checking if sign in to get response elemets was successfull
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("clientName", "Dina");
        map.put("clientEmail", "Phoebe.Walter@yahoo.com");

        System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("clientName", "Dina");
        request.put("clientEmail", "Phoebe.Walter@yahoo.com");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post(new StringBuilder(reader.getBaseURL()).append("api-clients/").toString()).
                then().
                statusCode(201);
    }

    @Test
    public void testNN() {
        RestAssured.baseURI = reader.getBaseURL();
        RequestSpecification httpRequest;
        Response response;
        httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("clientName", "Nanie1");
        requestParams.put("clientEmail", "Lavind1.Towaner@gmail.com"); // Cast
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest
                .request(Method.POST, "api-clients/");
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 201);
        System.out.println("response.getBody().asString() = " + response.getBody().jsonPath().getJsonObject("accessToken"));//Access Token
    }

    @Test
    public void testNNN() {
        String str1 = String.valueOf(new Random().nextInt((1000 - 2) + 1) + 2);
        String str2 = String.valueOf(new Random().nextInt((1000 - 3) + 1) + 3);
        RestAssured.baseURI = reader.getBaseURL();
        RequestSpecification httpRequest;
        Response response;
        httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("clientName", "Nannie" + str1);
        requestParams.put("clientEmail", "Lavina" + str2 + ".Towne@gmail.com"); // Cast
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest
                .request(Method.POST, "api-clients/");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        System.out.println("response.getBody().jsonPath().getJsonObject(accessToken) = " + response.getBody().jsonPath().getJsonObject("accessToken"));
    }

    public String getAccessToken() {
        String str1 = String.valueOf(new Random().nextInt((1000 - 2) + 1) + 2);
        String str2 = String.valueOf(new Random().nextInt((1000 - 3) + 1) + 3);
        RestAssured.baseURI = reader.getBaseURL();
        RequestSpecification httpRequest;
        Response response;
        httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("clientName", "Nannie" + str1);
        requestParams.put("clientEmail", "Lavina" + str2 + ".Towne@gmail.com"); // Cast
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest
                .request(Method.POST, "api-clients/");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        return response.getBody().jsonPath().getJsonObject("accessToken");
    }


}
