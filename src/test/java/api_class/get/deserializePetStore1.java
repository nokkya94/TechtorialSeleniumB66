package api_class.get;

import api_class.desserialization.pojo.PetPOJOoption2;
import api_class.desserialization.pojo.PetPojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class deserializePetStore1 {
    @Test
    public void deserializepet() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        //Construct the URL https://petstore.swagger.io/v2/pet/findByStatus?status=sold
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").
                setHost("petstore.swagger.io").
                setPath("v2/pet/findByStatus").
                setParameter("status","sold");

        //Define the Http method
        HttpGet get = new HttpGet(uriBuilder.build());
        get.addHeader("accept", "application/json");

        //execute a call
        HttpResponse response = client.execute(get);

        ObjectMapper objectMapper = new ObjectMapper();

        //verify status code
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        List<Map<String,Object>> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String,Object>>>() {
        });

        for(int i = 0; i< deserializedResponse.size(); i++) {
            Map<String,Object> mapp = deserializedResponse.get(i);
            System.out.println("id : "+mapp.get("id")+" , name: "+ mapp.get("name"));

            List<Map<String,Object>> tagsData = (List<Map<String,Object>>) mapp.get("tags");
            for(int j =0; j<tagsData.size() ;j++) {

                Map<String,Object> tagsMap = (Map<String,Object>) tagsData.get(j);

                if (tagsMap != null) {

                    System.out.println("Tags id: " + tagsMap.get("id") + " , tags name : " + tagsMap.get("name"));
                }
            }
        }
    }

    @Test
    public void getPetPojo() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        //Construct the URL https://petstore.swagger.io/v2
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").
                setHost("petstore.swagger.io").
                setPath("v2/pet/10010000000");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");

        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);


        ObjectMapper objectMapper = new ObjectMapper();
        PetPojo abilityPojo = objectMapper.readValue(response.getEntity().getContent(), PetPojo.class);


        Assert.assertEquals(abilityPojo.getName(),"Hutch");
        Assert.assertEquals(abilityPojo.getId(),10010000000l);
        Assert.assertEquals(abilityPojo.getStatus(),"good pet");

        Map<String,Object> newMap = abilityPojo.getCategory();
        System.out.println(newMap);

        Assert.assertEquals(newMap.get("id"),700);
        Assert.assertEquals(newMap.get("name"),"German Shepard");


    }
    @Test
    public void getPetPojo2() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        //Construct the URL https://petstore.swagger.io/v2
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").
                setHost("petstore.swagger.io").
                setPath("v2/pet/10010000000");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");

        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        PetPOJOoption2 parsedPet = objectMapper.readValue(response.getEntity().getContent(), PetPOJOoption2.class);

        System.out.println(parsedPet.getCategory().getName());
    }




}
