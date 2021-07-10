package seleniumAllClasses.TestNGIntro;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

    @Test
    public void useOfProperties(){

        Properties properties = new Properties();
        File propFile = new File("src/test/resources/stuff.properties");
        try {
            FileInputStream inputStream = new FileInputStream(propFile);
            properties.load(inputStream);
        }catch (IOException ex){
            throw  new RuntimeException("ur properties file was not found",ex);

        }

        String email1 = properties.getProperty("email");
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("dob"));

    }

}
