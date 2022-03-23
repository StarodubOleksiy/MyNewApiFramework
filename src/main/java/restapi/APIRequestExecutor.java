package restapi;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIRequestExecutor {

    public static Response completePostResponse(RequestSpecification httpRequest, String urn) {
        return httpRequest.request(Method.POST, Utils.getUrlLink(urn));
    }

    public static Response completeGetResponse(RequestSpecification httpRequest, String urn) {
        return httpRequest.request(Method.GET, Utils.getUrlLink(urn));
    }
}
