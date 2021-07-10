package api_class.delete;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetstoreAPI {

    HttpClient client = HttpClientBuilder.create().build();
    URIBuilder uriBuilder = new URIBuilder();

    @BeforeMethod
    public void setup() throws URISyntaxException, IOException {

        uriBuilder.setScheme("https").setHost("petstore.swagger.io/v2/pet");

        HttpPost post = new HttpPost(uriBuilder.build());

        post.addHeader("Accept","application/json");
        post.addHeader("Content-Type","application/json");

        byte[] bytes = Files.readAllBytes(Paths.get("src/test/java/api_class/serialization/pet.json"));
        String jsonContent = new String(bytes);

        HttpEntity entity = new StringEntity(jsonContent);

        post.setEntity(entity);

        HttpResponse response = client.execute(post);
    }


    @Test
    public void deletePetTest() throws URISyntaxException, IOException {

        uriBuilder.setPath("1020");

        HttpDelete delete = new HttpDelete(uriBuilder.build());
        delete.addHeader("accept","application/json");

        HttpResponse response = client.execute(delete);
        int statusCode= response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

    }

}
