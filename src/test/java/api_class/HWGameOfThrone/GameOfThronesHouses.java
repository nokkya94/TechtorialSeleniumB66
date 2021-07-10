package api_class.HWGameOfThrone;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.bs.A;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameOfThronesHouses {
    /**
     * Launch the client(postman)
     * Construct URL
     * Define the HTTP methods (Get, Post,Put, Delelete)
     * Add parameters (if needed)
     * path params
     * query param
     * header
     * click the Send button to execute/call
     */

    @Test
    public void getCharacters() throws URISyntaxException, IOException {
        //https://api.got.show/api/show/characters
        //build a client
        HttpClient client = HttpClientBuilder.create().build();
        //build endpoint
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/show/characters");
        //select method get/post/put/delete
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        //add headers
        httpGet.addHeader("Accept","application/json");

        //execute a call
        HttpResponse response = client.execute(httpGet);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();

        List<Map<String,Object>> deserializedData = objectMapper.readValue(response.getEntity().getContent(), new TypeReference <List<Map<String,Object>>>() {
        });

        for(Map<String,Object> eachMapFromList : deserializedData){

            if(eachMapFromList!=null){
                String names = (String) eachMapFromList.get("name");
                if(names.endsWith("Reed")){
                    System.out.println(names);
                }
            }
        }



    }

    @Test
    public void setEveryCharacterInItsHouse() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        //https://api.got.show/api/show/characters
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/show/characters");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept","application/json");

        HttpResponse response = httpClient.execute(httpGet);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();

        List<Map<String,Object>> parsedData = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String,Object>>>() {
        });
        //  house  list of everyone in that house
        ArrayList<String> StarkList = new ArrayList<>();
        ArrayList<String> GreyjoyList = new ArrayList<>();
        ArrayList<String> CasselList = new ArrayList<>();
        ArrayList<String> UmberList = new ArrayList<>();
        ArrayList<String> KarstarkList = new ArrayList<>();
        ArrayList<String> MormontList = new ArrayList<>();
        ArrayList<String> GloverList = new ArrayList<>();
        ArrayList<String> CerwynList = new ArrayList<>();
        ArrayList<String> ManderlyList = new ArrayList<>();
        ArrayList<String> ReedList = new ArrayList<>();
        ArrayList<String> BoltonList = new ArrayList<>();
        ArrayList<String> LannisterList = new ArrayList<>();
        ArrayList<String> PayneList = new ArrayList<>();
        ArrayList<String> CleganeList = new ArrayList<>();
        ArrayList<String> BaratheonList = new ArrayList<>();
        ArrayList<String> SeaworthList = new ArrayList<>();
        ArrayList<String> TarthList = new ArrayList<>();
        ArrayList<String> ArrynList = new ArrayList<>();
        ArrayList<String> RoyceList = new ArrayList<>();
        ArrayList<String> WaynwoodList = new ArrayList<>();
        ArrayList<String> TyrellList = new ArrayList<>();
        ArrayList<String> TarlyList = new ArrayList<>();
        ArrayList<String> KenningList = new ArrayList<>();
        ArrayList<String> FreyList = new ArrayList<>();
        ArrayList<String> MartellList = new ArrayList<>();
        ArrayList<String> SandSnakesList = new ArrayList<>();
        ArrayList<String> TargaryenList = new ArrayList<>();
       Map<String,ArrayList<String>> houses = new LinkedHashMap<>();

        for (Map<String,Object> data : parsedData){


            String names = (String) data.get("name");
            if(data!=null){
                if(names.endsWith("Stark")){
                    StarkList.add(names+"\n");
                    houses.put("House Stark",StarkList);
                }if(names.endsWith("Greyjoy")){
                    GreyjoyList.add(names+"\n");
                    houses.put("House Greyjoy",GreyjoyList);
                }if(names.endsWith("Cassel")){
                    CasselList.add(names+"\n");
                    houses.put("House Cassel",CasselList);
                }if(names.endsWith("Maesters")){
                    UmberList.add(names+"\n");
                    houses.put("House Umber",UmberList);
                }if(names.endsWith("Karstark")){
                    KarstarkList.add(names+"\n");
                    houses.put("House Karstark",KarstarkList);
                }if(names.endsWith("Mormont")){
                    MormontList.add(names+"\n");
                    houses.put("House Mormont",MormontList);
                }if(names.endsWith("Glover")){
                    GloverList.add(names+"\n");
                    houses.put("House Glover",GloverList);
                }if(names.endsWith("Cerwyn")){
                    CerwynList.add(names+"\n");
                    houses.put("House Cerwyn",CerwynList);
                }if(names.endsWith("Manderly")){
                    ManderlyList.add(names+"\n");
                    houses.put("House Manderly",ManderlyList);
                }if(names.endsWith("Reed")){
                    ReedList.add(names+"\n");
                    houses.put("House Reed",ReedList);
                }if(names.endsWith("Bolton")){
                    BoltonList.add(names+"\n");
                    houses.put("House Bolton",BoltonList);
                }if(names.endsWith("Lannister")){
                    LannisterList.add(names+"\n");
                    houses.put("House Lannister",LannisterList);
                }if(names.endsWith("Payne")){
                    PayneList.add(names+"\n");
                    houses.put("House Payne",PayneList);
                }if(names.endsWith("Clegane")){
                    CleganeList.add(names+"\n");
                    houses.put("House Clegane",CleganeList);
                }if(names.endsWith("Baratheon")){
                    BaratheonList.add(names+"\n");
                    houses.put("House Baratheon",BaratheonList);
                }if(names.endsWith("Seaworth")){
                    SeaworthList.add(names+"\n");
                    houses.put("House Seaworth",SeaworthList);
                }if(names.endsWith("Tarth")){
                    TarthList.add(names+"\n");
                    houses.put("House Tarth",TarthList);
                 }if(names.endsWith("Arryn")){
                    ArrynList.add(names+"\n");
                    houses.put("House Arryn",ArrynList);
                }if(names.endsWith("Royce")){
                    RoyceList.add(names+"\n");
                    houses.put("House Royce",RoyceList);
                }if(names.endsWith("Waynwood")){
                    WaynwoodList.add(names+"\n");
                    houses.put("House Waynwood",WaynwoodList);
                }if(names.endsWith("Tyrell")){
                    TyrellList.add(names+"\n");
                    houses.put("House Tyrell",TyrellList);
                }if(names.endsWith("Tarly")){
                    TarlyList.add(names+"\n");
                    houses.put("House Tarly",TarlyList);
                }if(names.endsWith("Kenning")){
                    KenningList.add(names+"\n");
                    houses.put("House Kenning",KenningList);
                }if(names.endsWith("Frey")){
                    FreyList.add(names+"\n");
                    houses.put("House Frey",FreyList);
                }if(names.endsWith("Martell")){
                    MartellList.add(names+"\n");
                    houses.put("House Martell",MartellList);
                }if(names.contains("Sand")){
                    SandSnakesList.add(names+"\n");
                    houses.put("House SandSnake",SandSnakesList);
                }if(names.endsWith("Targaryen")){
                    TargaryenList.add(names+"\n");
                    houses.put("House Targaryen",TargaryenList);
                }

            }

        }
        System.out.println(houses);
    }
}
