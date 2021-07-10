package api_class.Rest_Assured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredGroovyFunctions {

    @Test
    public void getCompetitionTest(){

        Response response = given().accept(ContentType.JSON).when().get("http://api.football-data.org/v2/competitions")
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();

        Map<String,Object> map = response.path("competitions.find {it.name == 'WC Qualification' }");

    }
    @Test
    public void getCompt(){
        Response response = given().accept(ContentType.JSON).when()
                .get("http://api.football-data.org/v2/competitions")
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();

        Map<String,Object> map =  response.path("competitions.find { it.id == 2036 }");
        System.out.println(map.get("name"));
    }

    @Test
    public void getAllComp(){
        Response response = given().accept(ContentType.JSON).when()
                .get("http://api.football-data.org/v2/competitions")
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();

        List<Map<String,Object>> competList = response.path("competitions.findAll { it.id > 2006}");
        System.out.println(competList.size());
    }

    @Test
    public void getAllCompTest2(){
        Response response = given().accept(ContentType.JSON).when()
                .get("http://api.football-data.org/v2/competitions")
                .then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();

        List<String> competList = response.path("competitions.findAll { it.id > 2006}.name");
        System.out.println(competList);
    }
}
