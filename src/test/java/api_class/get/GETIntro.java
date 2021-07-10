package api_class.get;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GETIntro {
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
    public void getTest() throws URISyntaxException, IOException {

        //Initialize the client(postman)
        HttpClient client= HttpClientBuilder.create().build();

        //Construct URL : https://petstore.swagger.io/v2/store
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/store/inventory");

        //Define the HTTP methods
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //Add parameters
        httpGet.addHeader("accept","application/json");

        //execute API call
        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);



    }
    @Test
    public void getTest2() throws URISyntaxException, IOException {
        //initialize http client

        HttpClient client = HttpClientBuilder.create().build();

        //construct the URL https://reqres.in/api/users/2
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/2");

        //Define HTTP method
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //adding hearder parameter
        httpGet.addHeader("accept","application/json");

        //execute Get call
        HttpResponse response = client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);



    }




}