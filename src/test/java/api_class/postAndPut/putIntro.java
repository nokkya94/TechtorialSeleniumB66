package api_class.postAndPut;

import Utils.PayloadUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class putIntro {

    @Test
    public void putPet() throws URISyntaxException, IOException {


        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPut httpPut = new HttpPut(uriBuilder.build());
        String applicationJ = "application/json";
        httpPut.addHeader("Accept",applicationJ);
        httpPut.addHeader("Content-Type",applicationJ);

        int id = 2222;
        String name= "Dogname";
        String status = "likes meat";
        String putRequestPayLoad = PayloadUtils.getPetStoreUtils(id,name,status);

        HttpEntity entity = new StringEntity(putRequestPayLoad);
        httpPut.setEntity(entity);

        HttpResponse response = client.execute(httpPut);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(applicationJ));




    }

}
