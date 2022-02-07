package restapi;


import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import restapi.*;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

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
        final String accessToken = "<token>";
        RestAssured.baseURI = reader.getBaseURL();
        RequestSpecification httpRequest;
        Response response;
        httpRequest = RestAssured.given();


        // JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
        //{"name":"John123X","salary":"123","age":"23"}
        JSONObject requestParams = new JSONObject();
        requestParams.put("namebookId", 1); // Cast
        requestParams.put("customerName", "Randolph Bruen");

        // Add a header stating the Request body is a JSON
        httpRequest.header("Authorization", "Bearer " + accessToken,
                "Content-Type", "application/json",
                "Accept", ContentType.JSON);

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        response = httpRequest
                .request(Method.POST, new StringBuilder(reader.getBaseURL())
                        .append("orders").toString());
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
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


}
