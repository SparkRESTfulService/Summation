package resources;

import shiver.me.timbers.data.random.RandomStrings;

import java.util.Random;

public class Utility {

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
        return RandomStrings.someString();
    }
    public static String getRandomAlphaNumeric(){
        return RandomStrings.someAlphanumericString();
    }
    public static String getRandomDouble(){
        if(Integer.parseInt(getRandomPositiveNumber()) % 2 == 0){
            return getRandomNegativeDouble();
        } else {
            return getRandomPositiveDouble();
        }
    }
    public static String getRandomNegativeDouble(){
        return "-".concat(getRandomPositiveDouble());
    }
    public static String getRandomPositiveDouble(){
        Random r = new Random();
        int rangeMin = 0;
        int rangeMax = 100;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return String.valueOf(randomValue);
    }




}
