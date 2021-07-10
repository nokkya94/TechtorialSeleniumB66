package Utils;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {


    public static String readPropertyByKey(String key){

        Properties properties = new Properties();
        File propFile= new File("src/test/resources/credentials.properties");
        try{
            FileInputStream inputStream = new FileInputStream(propFile);
            properties.load(inputStream);
        } catch (IOException ex){
            throw new RuntimeException("credentials.properties file was not found",ex);
        }

         return  properties.getProperty(key);

    }




    @Test
    public void test1() throws IOException {

        Properties properties = new Properties();

        File propertiesFile = new File("src/test/resources/credentials.properties");
        FileInputStream input = new FileInputStream(propertiesFile);

        properties.load(input);

        String username = properties.getProperty("username");
        System.out.println("Username from properties file: "+username);

        String password = properties.getProperty("password");
        System.out.println("Password is : "+password);

        String browser = properties.getProperty("browser");
        System.out.println("Browser is : "+browser);




    }



}
