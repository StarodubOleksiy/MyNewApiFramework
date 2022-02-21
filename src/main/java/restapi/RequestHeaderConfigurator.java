package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.ClientModel;
import models.CustomerModel;
import org.json.simple.JSONObject;

public class RequestHeaderConfigurator {

    public static RequestSpecification createHttpRequestWithoutAuthorization(ClientModel clientModel) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers(
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(clientModel);
        return httpRequest;
    }

    public static RequestSpecification createHttpRequestWithAuthorization(CustomerModel customerModel) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Authorization", "Bearer " + Utils.getAccessToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON);
        httpRequest.body(customerModel);
        return httpRequest;
    }
}
