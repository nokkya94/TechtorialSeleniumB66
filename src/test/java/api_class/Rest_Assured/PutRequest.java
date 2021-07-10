package api_class.Rest_Assured;

import Utils.Constants;
import Utils.PayloadUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.Constants.*;
import static io.restassured.RestAssured.given;

public class PutRequest {

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI="https://petstore.swagger.io/v2/pet";

    }


    @Test
    public void updatePetTest(){

        int petId = 14990;
        String petName ="Lafayett";
        String status = "to be stored";

        String petPayload = PayloadUtils.getPetStoreUtils(petId,petName,status);

        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petPayload)
                .when().put()//we removed URI with RestAssured method called baseURI
                .then().statusCode(HttpStatus.SC_OK)
                .and().body(ID, Matchers.is(petId))
                .and().body(NAME, Matchers.equalTo(petName))
                .and().body(STATUS,Matchers.is(status));

    }

}
