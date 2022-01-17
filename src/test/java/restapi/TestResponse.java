package restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import restapi.*;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;

import ru.yandex.qatools.allure.annotations.*;

/**
 * Created by Oleksiy on 14/12/2020.
 */

/**
 * Here is just some rest-assured tests
 */


public class TestResponse {

    ApplicationConfigReader reader = new ApplicationConfigReader();// Creating instace of class that has important login data
    Response response; //Here is instance of response elements


    @BeforeTest
    public void getResponse() {
        response = RestAssured.given().request(Method.GET, reader.getBaseURL()); //get response data using http method GET
    }

    @Test
    @TestCaseId("TC_Test_Response_Elements_001")
    @Description("Check status code.")
    @Features("Rest Assured Status Code")
    public void test1VerifyStatusCode() {
        Assert.assertEquals(response.getStatusCode(), 200);//Checking if sign in to get response elemets was successfull
    }


}
