package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.ClientModel;
import models.CustomerModel;
import org.json.simple.JSONObject;

public class RequestHeaderConfigurator {

    public static RequestSpecification createHttpRequestWithoutAuthorization() {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        return httpRequest;
    }

    public static RequestSpecification createHttpRequestWithAuthorization(String token) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Authorization", token,
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        return httpRequest;
    }

    public static RequestSpecification createHttpRequestWithAuthorizationWithoutAuthorizationParam() {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        return httpRequest;
    }

    public static RequestSpecification createHttpRequestWithAuthorizationWithoutContentTypeParam(String token) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Authorization", token,
                "Accept", ContentType.JSON);
        return httpRequest;
    }

    public static RequestSpecification createHttpRequestWithAuthorizationWithoutAcceptParam(String token) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Authorization", token,
                "Content-Type", ContentType.JSON);
        return httpRequest;
    }
}
