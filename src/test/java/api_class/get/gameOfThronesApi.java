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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class gameOfThronesApi {


    @Test
    public void gameOfThrones() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        //Construct the URL api.got.show/api/show/characters
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").
                setHost("api.got.show").
                setPath("api/show/characters");

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

        List<Map<String, Object>> deserializedGOT= objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String, Object>>>() {
        });


        List<Object> names = new ArrayList<>();

        for(int i = 0;i<deserializedGOT.size(); i++){

            Map<String,Object> mapp = deserializedGOT.get(i);
            names.add(mapp.get("name"));

        }
        Assert.assertTrue(names.size()>100);
        System.out.println(names);

    }
}
