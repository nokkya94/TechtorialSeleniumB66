package api_class.get;

import api_class.desserialization.pojo.PetPojo;
import api_class.desserialization.pojo.StarWarsPojo;
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

public class getStarshipsUsingPojo {


    @Test
    public void getStarshipsCount() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        String initialPage = "1";

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http").
                setHost("swapi.dev").
                setPath("api/starships").
                setParameter("page", initialPage);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");

        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);


        ObjectMapper objectMapper = new ObjectMapper();
        StarWarsPojo parsedStarWars = objectMapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);


        int numberOfStarshipsPerPage = parsedStarWars.getResults().size();
        int expectedNumberOfStarships = numberOfStarshipsPerPage;
        int actualNumberOfStarships = parsedStarWars.getCount();
        System.out.println("Number of starships on page " + initialPage + " is : " + numberOfStarshipsPerPage + " sum of starships until now is "+expectedNumberOfStarships+" and total number of starships is " + actualNumberOfStarships);

        String lastValueOfNext="";

        if(parsedStarWars.getNext()!=null) {
            lastValueOfNext = parsedStarWars.getNext().substring(parsedStarWars.getNext().length() - 1);

        }
        initialPage = lastValueOfNext;


        if (expectedNumberOfStarships!=actualNumberOfStarships) {
            uriBuilder.setScheme("http").
                    setHost("swapi.dev").
                    setPath("api/starships").
                    setParameter("page", initialPage);
            HttpGet httpGet1 = new HttpGet(uriBuilder.build());
            response = client.execute(httpGet1);


            parsedStarWars = objectMapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);
            if(parsedStarWars.getNext()!=null) {
                lastValueOfNext = parsedStarWars.getNext().substring(parsedStarWars.getNext().length() - 1);

            }

            numberOfStarshipsPerPage = parsedStarWars.getResults().size();
            expectedNumberOfStarships += numberOfStarshipsPerPage;
            System.out.println("Number of starships on page " + initialPage + " is : " + numberOfStarshipsPerPage + " sum of starships until now is "+expectedNumberOfStarships+" and total number of starships is " + actualNumberOfStarships);

            initialPage = lastValueOfNext;

        }

        if (expectedNumberOfStarships!=actualNumberOfStarships) {
            uriBuilder.setScheme("http").
                    setHost("swapi.dev").
                    setPath("api/starships").
                    setParameter("page", initialPage);
            HttpGet httpGet1 = new HttpGet(uriBuilder.build());
            response = client.execute(httpGet1);


            parsedStarWars = objectMapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);
            if(parsedStarWars.getNext()!=null) {
                lastValueOfNext = parsedStarWars.getNext().substring(parsedStarWars.getNext().length() - 1);

            }

            numberOfStarshipsPerPage = parsedStarWars.getResults().size();
            expectedNumberOfStarships += numberOfStarshipsPerPage;
            System.out.println("Number of starships on page " + initialPage + " is : " + numberOfStarshipsPerPage + " sum of starships until now is "+expectedNumberOfStarships+" and total number of starships is " + actualNumberOfStarships);

            initialPage = lastValueOfNext;

        }
        if (expectedNumberOfStarships!=actualNumberOfStarships) {
            uriBuilder.setScheme("http").
                    setHost("swapi.dev").
                    setPath("api/starships").
                    setParameter("page", initialPage);
            HttpGet httpGet1 = new HttpGet(uriBuilder.build());
            response = client.execute(httpGet1);


            parsedStarWars = objectMapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);
            if(parsedStarWars.getNext()!=null) {
                lastValueOfNext = parsedStarWars.getNext().substring(parsedStarWars.getNext().length() - 1);

            }
            numberOfStarshipsPerPage = parsedStarWars.getResults().size();
            expectedNumberOfStarships += numberOfStarshipsPerPage;
            System.out.println("Number of starships on page " + initialPage + " is : " + numberOfStarshipsPerPage + " sum of starships until now is "+expectedNumberOfStarships+" and total number of starships is " + actualNumberOfStarships);

            initialPage = lastValueOfNext;

        }
        if (expectedNumberOfStarships!=actualNumberOfStarships) {
            uriBuilder.setScheme("http").
                    setHost("swapi.dev").
                    setPath("api/starships").
                    setParameter("page", initialPage);
            HttpGet httpGet1 = new HttpGet(uriBuilder.build());
            response = client.execute(httpGet1);


            parsedStarWars = objectMapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);
            if(parsedStarWars.getNext()!=null) {
                lastValueOfNext = parsedStarWars.getNext().substring(parsedStarWars.getNext().length() - 1);

            }

            numberOfStarshipsPerPage = parsedStarWars.getResults().size();
            expectedNumberOfStarships += numberOfStarshipsPerPage;
            System.out.println("Number of starships on page " + initialPage + " is : " + numberOfStarshipsPerPage + " sum of starships until now is "+expectedNumberOfStarships+" and total number of starships is " + actualNumberOfStarships);



        }

        }
    }
