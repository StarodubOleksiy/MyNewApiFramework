package restapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIRequestExecutor {

    public static Response completePostResponseWithoutAuthorization(String body, String urn) {
        RequestSpecification httpRequest = RequestHeaderConfigurator.createHttpRequestWithoutAuthorization();
        return httpRequest.body(body).request(Method.POST, Utils.getUrlLink(urn));
    }

    public static Response completePostResponseWithAuthorization(String token,String body, String urn) {
        RequestSpecification httpRequest = RequestHeaderConfigurator.createHttpRequestWithAuthorization(token);
        return httpRequest.body(body).request(Method.POST, Utils.getUrlLink(urn));
    }

    public static Response completeGetResponse(String urn) {
        RequestSpecification httpRequest = RestAssured.given();
        return httpRequest.request(Method.GET, Utils.getUrlLink(urn));
    }
}
