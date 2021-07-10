package api_class.HWForSlack;

import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class stepDefForSlackPositiveMessageTesting {

    HttpClient client = HttpClientBuilder.create().build();
    URIBuilder uriBuilder ;
    HttpResponse response ;

    String messagePayLoad = "API message(slack homework) : Hi everyone, Its Alexander !";
    String applicationJson = "application/json";


    @Given("user checks the specified message in slack")
    public void user_checks_the_specified_message_in_slack() throws IOException, URISyntaxException {

        //build https://slack.com/api/conversations.history?channel=C01GEQL1GNQ
        uriBuilder = new URIBuilder();
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
            }
        }

    }


    @When("user posts the specified message in slack")
    public void user_posts_the_specified_message_in_slack() throws URISyntaxException, IOException {


        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("slack.com").setPath("api/chat.postMessage");

        //https://slack.com/api/chat.postMessage
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept",applicationJson);
        httpPost.addHeader("Content-Type",applicationJson);
        httpPost.addHeader("Authorization","Bearer xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q");

        HttpEntity entity = new StringEntity(PayloadUtils.getSlackMessagePayload(messagePayLoad));

        httpPost.setEntity(entity);

        response = client.execute(httpPost);



    }

    @Then("user will get that message from slack")
    public void user_will_get_that_message_from_slack() throws IOException {



        int statusCode =  response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(applicationJson));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> parsedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        boolean isOk = (boolean)parsedResponse.get("ok");
        if(!isOk){
            Assert.fail("Failed to create a message");
        }

        Map<String,Object> messageData = (Map<String,Object>) parsedResponse.get("message");
        String messageText = (String) messageData.get("text");
        Assert.assertEquals(messageText,messagePayLoad);


    }

}
