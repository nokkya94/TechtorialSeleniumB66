package api_class.serialization;

import api_class.desserialization.pojo.PetPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class serializationIntro {

    @Test
    public void test1() throws IOException {

        PetPojo pet = new PetPojo(890l,"Snoopy","monster");


        ObjectMapper objectMapper = new ObjectMapper();
        File petJson = new File("src/test/java/api_class/serialization/pet3.json");

        objectMapper.writeValue(petJson, pet);

    }

    @Test
    public void test2() throws IOException, URISyntaxException {

        PetPojo pet = new PetPojo(5544l,"Snoopy","do no delete");
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();

        objectMapper.writeValue(stringWriter,pet);


        System.out.println(stringWriter);

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost post = new HttpPost(uriBuilder.build());
        post.addHeader("Accept","application/json");
        post.addHeader("Content-Type","application/json");

        HttpEntity entity = new StringEntity(stringWriter.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);

    }

    @Test
    public void test3() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost post = new HttpPost(uriBuilder.build());
        post.addHeader("Accept","application/json");
        post.addHeader("Content-Type","application/json");

        byte[] bytes = Files.readAllBytes(Paths.get("src/test/java/api_class/serialization/pet.json"));
        String jsonContent = new String(bytes);

        HttpEntity entity = new StringEntity(jsonContent);

        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);


    }

}
