package api_class.get;

import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.Map;


public class ReqResAPI {
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
    public void getUserByIdTest() throws URISyntaxException, IOException {
        //Initialize our client
        HttpClient client = HttpClientBuilder.create().build();
        //Construct the URL https://reqres.in/api/users/1
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

        //Define the Http Method
        HttpGet get = new HttpGet(uriBuilder.build());
        get.addHeader("accept","application/json");

        //execute a call
        HttpResponse response = client.execute(get);

        //verify status code
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);

        //verify response header: ContentType
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //Deserialization is done by ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> dataFromResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String,Object>>() {
        });

        Map<String,Object> data = (Map<String, Object>) dataFromResponse.get("data");
     System.out.println(dataFromResponse.get("data"));




    }
    @Test
    public void getUserByIdTest2() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

        //Define the Http Method
        HttpGet get = new HttpGet(uriBuilder.build());
        get.addHeader("accept","application/json");

        //execute a call
        HttpResponse response = client.execute(get);

        //verify response header: ContentType
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //Deserialization
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> dataFromResponse = objectMapper.readValue(response.getEntity().getContent(),//readValue is an overloaded Method
                new TypeReference<Map<String,Object>>(){});

        Map<String,Object> dataDeserialized = (Map<String,Object>)  dataFromResponse.get("support");
        Object str= dataDeserialized.get("url");
        System.out.println(str);





        System.out.println(dataDeserialized);
    }


}
