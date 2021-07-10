package api_class.postAndPut;

import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class createPetTest {

    @Test
    public void createTestPet() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept","application/json");
        httpPost.addHeader("Content-Type","application/json");

        int petId = 1050;
        String petName = "gala";
        String status = "fol sale";
        String postBody = PayloadUtils.getPetStoreUtils(petId,petName,status);
        HttpEntity entity = new StringEntity(postBody);

        httpPost.setEntity(entity);



        HttpResponse response = client.execute(httpPost);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {

        });

        String actualPetName = (String) deserializedResponse.get("name");
        int actualPetId = (int)deserializedResponse.get("id");
        String actualPetStatus =(String) deserializedResponse.get("status");

        Assert.assertEquals(actualPetId,petId);
        Assert.assertEquals(actualPetName, petName);
        Assert.assertEquals(actualPetStatus,status);

    }



}
