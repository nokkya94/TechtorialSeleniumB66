package Utils;

public class PayloadUtils {





    public static String getSlackMessagePayload(String message){

        String messagePayload = "{\n" +
                "\t\"channel\": \"C01GEQL1GNQ\",\n" +
                "\t\"text\": \""+message+"\"\n" +
                "}";

        return messagePayload;
    }
   
    public static String getPetStoreUtils(int id,String name,String status) {

        String petstorePayload = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 700,\n" +
                "    \"name\": \"Spaniel\"\n" +
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

        return petstorePayload;
    }


}
