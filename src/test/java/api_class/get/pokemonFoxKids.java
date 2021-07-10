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
import java.util.List;
import java.util.Map;

public class pokemonFoxKids {

    @Test
    public void deserializeThePokemon() throws URISyntaxException,IOException {

        HttpClient client = HttpClientBuilder.create().build();
        //Construct the URL pokeapi.co/api/v2/ability
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").
                setHost("pokeapi.co").
                setPath("api/v2/ability");

        //Define the Http method
        HttpGet get = new HttpGet(uriBuilder.build());
        get.addHeader("accept","application/json");

        //execute a call
        HttpResponse response = client.execute(get);

        ObjectMapper objectMapper = new ObjectMapper();

        //verify status code
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        Map<String,Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        List<Map<String,String>> result = (List<Map<String,String>>) deserializedResponse.get("results");

        for(int i = 0; i<result.size(); i++){

           Map<String,String> map = result.get(i);
            System.out.println(map.get("name"));

        }

    }


}
