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

public class StarWarsAPI {

    @Test
    public void spaceshipsTest() throws URISyntaxException, IOException {

        //initialize the client
        HttpClient httpClient = HttpClientBuilder.create().build();

        //Construct URL http://swapi.dev/api/starships/?page=2
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/starships");
        uriBuilder.setParameter("page","2");

        //Define the Http Method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");

        //execute a call
        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);
    }

    @Test
    public void starWarsPractice() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/films");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");

        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);
    }





}
