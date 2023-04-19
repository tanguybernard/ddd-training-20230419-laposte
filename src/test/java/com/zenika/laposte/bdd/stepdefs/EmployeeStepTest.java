package com.zenika.laposte.bdd.stepdefs;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static org.assertj.core.api.Assertions.assertThat;


public class EmployeeStepTest {

    private Response response;



    @Before
    public void setUp() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

    }


    @Given("Employees presents")
    public void employees_presents(DataTable table) throws IOException {
        List<Map<String, String>> signUpForms = table.asMaps(String.class, String.class);
        String id = signUpForms.get(0).get("id");
        String name = signUpForms.get(0).get("name");
        System.out.println(name);
        //TODO store data
    }

    @When("I send a request to get employees")
    public void iSendARequestToGetEmployees() throws JSONException {


        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        response = httpRequest.get("");



    }

    @When("I create employees {string} with {string}")
    public void iCreateEmployeesWith(String name, String address) throws JSONException {

        RequestSpecification request = RestAssured.given();
        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("address", address);
        // Add a header stating the Request body is a JSON
        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request

        request.body(requestParams); // Post the request and check the response

        response  = request.post("/employees");

    }

    @Then("^the response will return status 200$")
    public void receive_snek_snek() throws IOException {
        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();
        assertThat(statusCode).isEqualTo(200);


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        String serializedItem = response.getBody().asString();
        Element element = mapper.readValue(serializedItem, new TypeReference<>() {
        });

        for (Item item: element.books()) {
            assertThat(item.isbn()).isNotNull();
        }


    }

}

record Element(List<Item> books){

}
record Item(String isbn, String title, String subTitle, String author) {

}
