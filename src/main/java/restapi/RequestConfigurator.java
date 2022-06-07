package restapi;

import com.google.gson.Gson;
import models.ClientModel;
import models.CustomerModel;
import org.json.simple.JSONObject;

import static io.restassured.http.ContentType.JSON;

public class RequestConfigurator {

    public static String createClientModelInstance(String clientName, String clientEmail) {
        ClientModel client = new ClientModel();
        client.setClientName(clientName);
        client.setClientEmail(clientEmail);
        return new Gson().toJson(client);
    }

    public static String createCustomerModelInstance(String customerName, int bookId) {
        CustomerModel customer = new CustomerModel();
        customer.setCustomerName(customerName);
        customer.setBookId(bookId);
        return new Gson().toJson(customer);
    }

}
