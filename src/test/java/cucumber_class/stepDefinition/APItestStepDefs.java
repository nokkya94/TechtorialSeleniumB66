package cucumber_class.stepDefinition;

import api_class.desserialization.pojo.PetPojo;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APItestStepDefs {

    Response response;

    @When("user executes {string} request")
    public void user_executes_request(String request) {
       response = given().accept(ContentType.JSON).when()
                .get("https://petstore.swagger.io/v2/pet/1050");

    }


    @Then("status code is {int}")
    public void status_code_is(Integer statusCode200) {
        response.then().statusCode(statusCode200);

    }
    @Then("pet has following attributes")
    public void pet_has_following_attributes(io.cucumber.datatable.DataTable dataTable) {
        PetPojo parsedPet = response.as(PetPojo.class);
        List<Map<String,String>> maps = dataTable.asMaps();
        Map<String,String> petData = maps.get(0);
        String petName = petData.get("petName");
        String petStatus = petData.get("petStatus");
        int petId = Integer.parseInt(petData.get("petId"));

        Assert.assertEquals(parsedPet.getId(),petId);
        Assert.assertEquals(parsedPet.getName(),petName);
        Assert.assertEquals(parsedPet.getStatus(),petStatus);

    }


}
