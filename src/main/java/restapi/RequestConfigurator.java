package restapi;

import models.ClientModel;
import models.CustomerModel;
import org.json.simple.JSONObject;

public class RequestConfigurator {

    public static ClientModel createClientModelInstance() {
        ClientModel client = new ClientModel();
        client.setClientName(TestData.generateRandomName());
        client.setClientEmail(TestData.generateRandomEmail());
        return client;
    }

    public static CustomerModel createCustomerModelInstance() {
        CustomerModel customer = new CustomerModel();
        customer.setCustomerName("Randolph Bruen");
        customer.setBookId(1);
        return customer;
    }

}
