package restapi;

import com.google.gson.Gson;
import models.ClientModel;
import models.CustomerModel;
import org.json.simple.JSONObject;

import static io.restassured.http.ContentType.JSON;

public class RequestConfigurator {

    public static String createClientModelInstance() {
        ClientModel client = new ClientModel();
        client.setClientName(TestData.generateRandomName());
        client.setClientEmail(TestData.generateRandomEmail());
        return new Gson().toJson(client);
    }

    public static String createCustomerModelInstance() {
        CustomerModel customer = new CustomerModel();
        customer.setCustomerName("Randolph Bruen");
        customer.setBookId(1);
        return new Gson().toJson(customer);
    }

}
