package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static restapi.TestData.generateRandomName;

public class Utils {

    public static String getUrlLink(String urn) {
        return new StringBuilder(ApplicationConfigReader.getBaseURL()).append(urn).toString();
    }

    public static String getAccessToken() {
        String body = RequestConfigurator.createClientModelInstance(TestData.generateRandomName(),TestData.generateRandomEmail());
        Response response = APIRequestExecutor.completePostResponseWithoutAuthorization(body, "api-clients");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        return response.getBody().jsonPath().getJsonObject("accessToken");
    }

}
