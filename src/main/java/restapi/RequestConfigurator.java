package restapi;

import com.google.gson.Gson;
import models.ClientModel;
import models.CustomerModel;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.JSON;

public class RequestConfigurator {

    public static String createClientModelInstance(String clientName, String clientEmail) {
        ClientModel client = new ClientModel();
        client.setClientName(clientName);
        client.setClientEmail(clientEmail);
        return new Gson().toJson(client);
    }

    public static <T> String createCustomerModelInstance(String customerName, T bookId) {
        CustomerModel<T> customer = new CustomerModel();
        customer.setCustomerName(customerName);
        customer.setBookId(bookId);
        return new Gson().toJson(customer);
    }

}
