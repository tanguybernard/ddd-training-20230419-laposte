package com.zenika.laposte.bdd.stepdefs;

import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisId;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateEtiquetteForColis {


    private Response response;



    @Before
    public void setUp() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:8080";

    }

    @Autowired
    ColisRepository colisRepository;

    @Given("^I have a package \"([^\"]*)\"$")
    public void iHaveAPackage(String id) {

        Colis colis = Colis.create(new ColisId(id), LocalDate.now(), "Alice");
        colisRepository.create(colis);
    }


    @When("^I create the etiquette \"([^\"]*)\" to the package \"([^\"]*)\"$")
    public void iAssignAtiquette(String idEtiquette, String idColis) {

        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("idEtiquette", idEtiquette);
        requestParams.put("poids", 150);
        requestParams.put("dLongueur", 10);
        requestParams.put("dLargeur", 10);
        requestParams.put("dProfondeur", 10);
        httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.post("/colis/"+idColis+"/etiquette");

        //response = httpRequest.get("/test");
    }

    @Then("^the response will return status 201$")
    public void responseWillReturn2O1(){
        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();
        assertThat(statusCode).isEqualTo(201);
    }


    @And("^The package \"([^\"]*)\" contain etiquette \"([^\"]*)\"$")
    public void thePackageContainEtiquette(String idColis, String idEtiquette) throws Exception {

        Colis colis = this.colisRepository.getById(new ColisId(idColis));

        assertThat(colis.etiquetteId.toString()).isEqualTo(idEtiquette);


    }
}