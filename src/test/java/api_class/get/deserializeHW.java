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
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;

public class deserializeHW {

    @Test
    public void deserializeTheResponse() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        //Construct the URL https://reqres.in/api/users/
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/");

        //Define the Http method
        HttpGet get = new HttpGet(uriBuilder.build());
        get.addHeader("accept","application/json");

        //execute a call
        HttpResponse response = client.execute(get);

        //verify status code
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);

        //verify response header : ContentType
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //Deserialization is done by ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> deserializedData = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        Map<String,Object> data = (Map<String, Object>) deserializedData.get("data");
        System.out.println(data);

        /*
        for (int i =0; i<data.length; i++) {
            System.out.println(data[i]);
        }

         */
            /*
            Object [] dataInsideData = {Array.get(data[i],0)};
            System.out.println(dataInsideData);


             */
            /*
            for (int j = 0 ; j< data[i].length; j++){
                System.out.println(Arrays.toString(data[i][j]));
                for (int n = 0; n<data[i][j].length; n++){
                    System.out.println(Arrays.toString(data[i][j][n]));

                }

            }

             */
        }



    }


