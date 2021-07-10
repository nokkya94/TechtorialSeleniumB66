package api_class.Rest_Assured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredAdv {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;

//https://pokeapi.co/api/v2/ability
    @BeforeMethod
    public void setUp(){
        RestAssured.basePath="https://pokeapi.co";
        RestAssured.baseURI="api/v2/ability";
        reqSpec = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
        resSpec = new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void test1(){

        given().spec(reqSpec).when().get().then().spec(resSpec);

    }
    @Test
    public void test2(){

        Response response = given().spec(reqSpec).queryParam("limit","1")
                .when().get().then().spec(resSpec).extract().response();

        List<Map<String,Object>> results = JsonPath.from(response.asString()).getList("results");
        Assert.assertEquals(results.size(),1);

    }

}
