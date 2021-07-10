package api_class.get;

import api_class.desserialization.pojo.PokemonPojo;
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

public class PokemonAPI {

    @Test
    public void getAbilityTest() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").
                setHost("pokeapi.co").
                setPath("api/v2/ability");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");

        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        //deserialization

        ObjectMapper objectMapper = new ObjectMapper();
        PokemonPojo abilityPojo = objectMapper.readValue(response.getEntity().getContent(), PokemonPojo.class);

        System.out.println(abilityPojo.getNext());
        System.out.println(abilityPojo.getCount());

    }

}
