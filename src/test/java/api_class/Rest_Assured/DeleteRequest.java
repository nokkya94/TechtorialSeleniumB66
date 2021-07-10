package api_class.Rest_Assured;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {

    @Test
    public void deleteTest(){
        given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/1050")
                .then().statusCode(404).contentType(ContentType.JSON).and()
                .body("code", Matchers.equalTo(1));

    }

    @Test
    public void deleteSmthingWhichDoesntExist(){

        given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/10502222")
                .then().defaultParser(Parser.JSON).statusCode(404)
                .and().body("code",Matchers.is(404));

    }

}
