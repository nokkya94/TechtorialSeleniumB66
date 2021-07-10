package cucumber_class.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.*;

import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;

public class APItestGot {

    Response response;

    @When("user executes {string} request for GOT")
    public void user_executes_request_for_got(String request) {
      response = given().accept(ContentType.JSON)
              .when().get("https://api.got.show/api/show/characters").then().extract().response();

    }


    @Then("status code is {int} for GOT API")
    public void status_code_is_for_got_api(Integer status200) {
        response.then().statusCode(status200).contentType(ContentType.JSON);

    }
    @Then("find all unique titles and verify the number of titles is more than {int}")
    public void find_all_unique_titles_and_verify_the_number_of_titles_is_more_than(Integer int1) throws IndexOutOfBoundsException {
        //GOT API is a whole list of maps so I created a deserialized list of maps
        List<Map<String,Object>> deserializedList = response.as(new TypeRef<List<Map<String, Object>>>() {
        });
        
        Set<String> uniqueTitles = new HashSet<>();//i need this set to store uniques
        for(Map<String,Object> insideList : deserializedList){
            
            List<List<String>> listOfTitlesLists = new ArrayList<>();
            listOfTitlesLists.add((List<String>) insideList.get("titles"));
            //navigating through whole api im adding each value(list) of titles key from each map from the deserialized list in my new list called listOfTitlesLists
            if(listOfTitlesLists!=null){//now its time to iterate through lists of my listOfTitlesLists and get unique Strings

                for (int i = 0 ; i<listOfTitlesLists.size();i++){
                    for (String unique:  listOfTitlesLists.get(i)) {
                        uniqueTitles.add(unique);
                    }
                }
            }
        }

        System.out.println("The size of all unique titles set is : " +uniqueTitles.size());
        System.out.println(uniqueTitles);
        Assert.assertTrue(uniqueTitles.size()>15);




    }

}
