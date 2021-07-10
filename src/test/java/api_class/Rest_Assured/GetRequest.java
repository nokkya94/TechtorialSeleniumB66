package api_class.Rest_Assured;

import api_class.desserialization.pojo.PetPojo;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class GetRequest {

    String jSon="application/json";

    @Test
    public void getTest(){
    //https://petstore.swagger.io/v2/pet/1020

        given().accept(jSon)
                .when().get("https://petstore.swagger.io/v2/pet/1020")
                .then().statusCode(200).contentType(jSon);
    }

    @Test
    public void getPeopleStarWars(){
        //http://swapi.dev/api/people

        given().accept(jSon)
                .when().get("http://swapi.dev/api/people")
                .then().statusCode(HttpStatus.SC_OK).contentType(jSon).log().ifValidationFails();
    }

    @Test
    public void getTest3(){

        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/1020")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("id", equalTo(1020))
        .and().body("category.name", is("Spaniel"));

    }

    @Test
    public void pokeApiTest(){

        given().accept(ContentType.JSON)
                .when().get("https://pokeapi.co/api/v2/ability")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("count", equalTo(327))
                .and().body("results[2].name", is("speed-boost"))
                .and().body("results.name[2]",is("speed-boost"))
                .and().body("results.name",Matchers.anything("speed-boost"));


    }

    @Test
    public void itunesGetTest(){
        //https://itunes.apple.com/search?term=greenday
        given().accept(ContentType.JSON).queryParam("term","greenday")
                .when().get("https://itunes.apple.com/search?term=greenday")
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
                .and().body("resultCount",Matchers.equalTo(50));



    }

    @Test
    public void deserializationUsingRestAssured(){

        Response response = given().accept(ContentType.JSON).queryParam("term","greenday")
                .when().get("https://itunes.apple.com/search")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();
        Map<String, Object> parsedResponse=response.as(new TypeRef<Map<String, Object>>() {
        });
        List<Map<String, Object>> resultsData = (List<Map<String, Object>>) parsedResponse.get("results");
        System.out.println(resultsData.size());
        assertEquals(50,resultsData.size());

    }

    @Test
    public void swapiTest(){
        //http://swapi.dev/api/people
        RestAssured.baseURI="http://swapi.dev/api/people";
        Response response = given().accept(ContentType.JSON)
                .when().get()
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });
        List<Map<String,Object>> resultList = (List<Map<String, Object>>) deserializedResponse.get("results");
        assertEquals(resultList.get(0).get("name"),"Luke Skywalker");

        
    }

    @Test
    public void petTest(){

        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet/1050";
        Response response = given().accept(ContentType.JSON)
                .when().get()
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();

        PetPojo deserialization = response.as(PetPojo.class);
        assertEquals(deserialization.getName(),"gala");
        assertEquals(deserialization.getId(),1050);

    }

    @Test
    public void petTest2(){

        Response response = given().accept(ContentType.JSON)
                .when().get("http://swapi.dev/api/people")
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();

        Map<String,Object> parsedResp = JsonPath.from(response.asString()).getMap(".");
        System.out.println(parsedResp);

        System.out.println("===========");
        List<Map<String,Object>> results = JsonPath.from(response.asString()).getList("results");

        int count = JsonPath.from(response.asString()).getInt("count");
        System.out.println("Count is "+ count);

    }


}
