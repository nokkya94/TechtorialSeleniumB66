package api_class.Rest_Assured;

import Utils.PayloadUtils;
import api_class.desserialization.pojo.PetPojo;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostRequest {

    String jSon="application/json";

    @Test
    public void createPetTest(){

        String requestPayLoad= PayloadUtils.getPetStoreUtils(101019,"Krakazeabrik","online");

        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(requestPayLoad)
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(HttpStatus.SC_OK).contentType(jSon)
                .and().body("id", Matchers.equalTo(101019))
                .and().body("status",Matchers.equalTo("online"))
                .and().body("name",Matchers.equalTo("Krakazeabrik"));

    }

    @Test
    public void createPetTest2(){
        File petPayload = new File("src/test/java/api_class/serialization/pet2.json");
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petPayload)
        .when().post("https://petstore.swagger.io/v2/pet")
        .then().statusCode(HttpStatus.SC_OK)
        .and().body("id",Matchers.equalTo(1233))
        .and().body("name",Matchers.equalTo("Vagner"))
        .and().body("status",Matchers.equalTo("predator"));
    }

    @Test
    public void createPetTest3(){

        long petId = 1499l;
        String petName ="Lafayet";
        String status = "to be deleted";

        PetPojo pet = new PetPojo(petId,petName,status);

        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(pet)
        .when().post("https://petstore.swagger.io/v2/pet")
        .then().statusCode(HttpStatus.SC_OK).and().contentType(ContentType.JSON)
        .and().body("id",Matchers.equalTo((int)petId))
        .and().body("name",Matchers.equalTo(petName))
        .and().body("status",Matchers.equalTo(status));
    }



}
