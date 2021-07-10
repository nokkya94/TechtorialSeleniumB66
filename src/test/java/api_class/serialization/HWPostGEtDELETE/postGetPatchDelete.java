package api_class.serialization.HWPostGEtDELETE;

import api_class.desserialization.pojo.PetPojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class postGetPatchDelete {


    String JsonString = "application/json";
    long petId = 1233l;
    String petName = "Vagner";
    String petStatus = "predator";

    @Test
    public void setUpFile() throws IOException {

        PetPojo pet = new PetPojo(petId,petName,petStatus);


        ObjectMapper objectMapper = new ObjectMapper();
        File petJson = new File("src/test/java/api_class/serialization/pet2.json");

        objectMapper.writeValue(petJson, pet);

    }


    @Test
    public void postAPet() throws IOException, URISyntaxException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io/v2/pet");

        HttpPost post = new HttpPost(uriBuilder.build());
        post.addHeader("Accept",JsonString);
        post.addHeader("Content-Type",JsonString);

        byte[] bytes = Files.readAllBytes(Paths.get("src/test/java/api_class/serialization/pet.json"));
        String jsonContent = new String(bytes);
        System.out.println(jsonContent);
        HttpEntity entity = new StringEntity(jsonContent);

        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);

    }

    @Test
    public void getThePetIPosted() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io/v2/pet").setPath("1233");

        HttpGet get = new HttpGet(uriBuilder.build());
        get.addHeader("Accept",JsonString);

        HttpResponse response = client.execute(get);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(JsonString));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> parsedPet = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        Assert.assertEquals(parsedPet.get("id"), (int)petId);
        Assert.assertEquals(parsedPet.get("name"),petName);
        Assert.assertEquals(parsedPet.get("status"),petStatus);

    }

    @Test
    public void putThePet() throws URISyntaxException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io/v2/pet").setPath("1233");

        HttpPut put = new HttpPut(uriBuilder.build());
        put.addHeader("Accept",JsonString);
        put.addHeader("Content-Type",JsonString);

        

    }




}
