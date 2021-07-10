package api_class.postAndPut;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class slackMessageHW {

    String messagePayLoad = "API message(slack homework) : Hi everyone, Its Alexander !";
    String applicationJson = "application/json";

    @Test
    public void slackMessage() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        //build https://slack.com/api/conversations.history?channel=C01GEQL1GNQ
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").
                setHost("slack.com").
                setPath("api/conversations.history").
                setParameter("channel","C01GEQL1GNQ");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept",applicationJson);
        httpGet.addHeader("Authorization","Bearer xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q");


        HttpResponse response = client.execute(httpGet);

        int statusCode =  response.getStatusLine().getStatusCode();

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(applicationJson));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> parsedData = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        List<Map<String,Object>> allMessagesList = (List<Map<String, Object>>) parsedData.get("messages");
        Map<String,Object> mapFromListWithMessages= allMessagesList.get(0);
        //here we are inside the chat




        for(int i = 0; i< mapFromListWithMessages.size(); i++){

            if(mapFromListWithMessages.get("text").equals(messagePayLoad)){
                System.out.println("Your message is there");
            }else{
                System.out.println("Your message is not there");
            }

        }

    }
    @Test
    public void createAMessageInSlack() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("httpls").setHost("slack.com").setPath("api/chat.postMessage");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept","application/json");
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Authorization","Bearer xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q");

        HttpEntity entity = new StringEntity(messagePayLoad);

        httpPost.setEntity(entity);

        HttpResponse response = client.execute(httpPost);

        int statusCode =  response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(applicationJson));

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String,Object> parsedResponse =  objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        Map<String,Object> messageFromParsedResponse = (Map<String, Object>) parsedResponse.get("message");


    }
}
