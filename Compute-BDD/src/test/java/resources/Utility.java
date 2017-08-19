package resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import shiver.me.timbers.data.random.RandomStrings;

import java.util.Random;

public class Utility {
    @Value("${service.client.baseurl}")
    static private String url = "http://localhost:8080/";
    static RestTemplate restTemplate = new RestTemplate();

    public static String getRandomNumber(){
        if(Integer.parseInt(getRandomPositiveNumber()) % 2 == 0){
            return getRandomNegativeNumber();
        } else {
            return getRandomPositiveNumber();
        }
    }
    public static String getRandomPositiveNumber(){
        return RandomStrings.someNumericString(1,9);
    }
    public static String getRandomNegativeNumber(){
        return "-".concat(RandomStrings.someNumericString(1,9));
    }
    public static String getRandomString(){
        return RandomStrings.someString(6);
    }
    public static String sendGetRequest(String number1, String number2) {
        try {
            return restTemplate.getForObject(url + "/calculator/add/" + number1 + "/"+number2, String.class);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    public static String sendGetRequest(String number1) {
        try {
            return restTemplate.getForObject(url + "/calculator/add/" + number1, String.class);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    public static String sendGetRequest(String number1,String number2,String number3) {
        try {
            return restTemplate.getForObject(url + "/calculator/add/" + number1+ "/"+number2+ "/"+number3, String.class);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    public static boolean isInt(String d)
    {
        double aDouble = Double.parseDouble(d);
        return aDouble == (long) aDouble;
    }
}
