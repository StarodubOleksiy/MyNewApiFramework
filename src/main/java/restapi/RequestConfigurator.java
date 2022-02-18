package restapi;

import org.json.simple.JSONObject;

public class RequestConfigurator {

    public static JSONObject jSONObjectWithRandomClientNameAndEmailModel() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("clientName", TestData.generateRandomName());
        requestParams.put("clientEmail", TestData.generateRandomEmail());
        return requestParams;
    }

    public static JSONObject jSONObjectWithRandomCustomerNameAndBookIdModel() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("customerName", "Randolph Bruen");
        requestParams.put("bookId", 1);
        return requestParams;
    }

}
