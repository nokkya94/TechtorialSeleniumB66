package api_class.postAndPut;

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
import org.testng.internal.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class createAnOrderPetStore {
    @Test
    public void createAnOrder() throws IOException, URISyntaxException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder();

        //build https://petstore.swagger.io/v2/store/order
        builder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/store/order");

        HttpPost httpPost = new HttpPost(builder.build());
        httpPost.addHeader("accept","application/json");
        httpPost.addHeader("content-Type","application/json");


        String postBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"petId\": 12,\n" +
                "  \"quantity\": 1,\n" +
                "  \"shipDate\": \"2020-12-05T21:27:48.564Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": false\n" +
                "}";

        HttpEntity entity = new StringEntity(postBody);
        httpPost.setEntity(entity);

        HttpResponse response = client.execute(httpPost);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> desentrializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        int petActualId= (int)desentrializedMap.get("petId");
        int petQuantity = (int)desentrializedMap.get("quantity");
        String petStatus = (String) desentrializedMap.get("status");
        boolean isComplete = (boolean) desentrializedMap.get("complete");

        Assert.assertEquals(petActualId,12);
        Assert.assertEquals(petQuantity,1);
        Assert.assertEquals(petStatus,"placed");
        Assert.assertEquals(isComplete,false);

    }
    @Test
    public void createAnUser() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/user");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("accept","application/json");
        httpPost.addHeader("content-Type","application/json");

        String postBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Alexxx\",\n" +
                "  \"firstName\": \"Alex\",\n" +
                "  \"lastName\": \"Tanasiev\",\n" +
                "  \"email\": \"alex@mail.com\",\n" +
                "  \"password\": \"blabla123\",\n" +
                "  \"phone\": \"123456\",\n" +
                "  \"userStatus\": 2\n" +
                "}";



        HttpEntity entity = new StringEntity(postBody);
        httpPost.setEntity(entity);

        HttpResponse response = client.execute(httpPost);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        String actualUserName = (String) deserializedResponse.get("username");
        String actualFirstName = (String) deserializedResponse.get("firstName");
        String actualLastName = (String) deserializedResponse.get("lastName");
        String actualEmail = (String) deserializedResponse.get("email");
        String actualPhone = (String) deserializedResponse.get("phone");
       // int actualUserStatus = (int) deserializedResponse.get("userStatus");

        Assert.assertEquals(actualUserName,"Alexxx");
        Assert.assertEquals(actualFirstName,"Alex");
        Assert.assertEquals(actualLastName,"Tanasiev");
        Assert.assertEquals(actualEmail,"alex@mail.com");
        Assert.assertEquals(actualPhone,"123456");
      //  Assert.assertEquals(actualUserStatus,2);

    }


}
