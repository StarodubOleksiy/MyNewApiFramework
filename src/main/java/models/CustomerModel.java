package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bookId", "customerName"})
@Generated("jsonschema2pojo")
@Setter
@NoArgsConstructor
public class CustomerModel {
    @JsonProperty("bookId")
    private int bookId;
    @JsonProperty("customerName")
    private String customerName;
}
