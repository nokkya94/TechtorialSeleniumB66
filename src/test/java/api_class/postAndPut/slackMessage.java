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

public class slackMessage {

    @Test
    public void createMessageSlack() throws URISyntaxException, IOException {



        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("slack.com").setPath("api/chat.postMessage");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept","application/json");
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Authorization","Bearer xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q");

        String message = "This is the message from API POST call. Hello everybody. Alexander";
        String messagePayload = PayloadUtils.getSlackMessagePayload(message);

        HttpEntity entity = new StringEntity(messagePayload);

        httpPost.setEntity(entity);



        HttpResponse response = client.execute(httpPost);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> parsedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        boolean isOk = (boolean)parsedResponse.get("ok");

        if(!isOk){
            Assert.fail("Failed to post a message");
        }

        Map<String,Object> messageData = (Map<String, Object>) parsedResponse.get("message");
        String messageText = (String) messageData.get("text");
        Assert.assertEquals(messageText,message);


    }
}
