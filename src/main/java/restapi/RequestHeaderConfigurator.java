package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class RequestHeaderConfigurator {

    public static RequestSpecification createHttpRequestWithoutAuthorization(JSONObject requestParams) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        return httpRequest;
    }

    public static RequestSpecification createHttpRequestWithAuthorization(JSONObject requestParams) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Authorization", "Bearer " + Utils.getAccessToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(requestParams.toJSONString());
        return httpRequest;
    }
}
