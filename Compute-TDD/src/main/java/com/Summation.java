package com;

import java.text.DecimalFormat;

import static org.apache.commons.lang3.math.NumberUtils.isParsable;

public class Summation {
    public Summation(){
    }

    public String sum (String num1, String num2) throws BadRequestException{

        if(isParsable(num1) && isParsable(num2)){
                if (!isInt(num1) || !isInt(num2)) {
                    double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    return String.valueOf(result);
                } else {
                    long result = Long.parseLong(num1) + Long.parseLong(num2);
                    return String.valueOf(result);
                }
        }
        else {
            throw new BadRequestException("Bad Request","Invalid Argument Exception");
        }
    }
    public String sum (String num1) throws BadRequestException{

        if(isParsable(num1)){
            return num1;
        }
        else {
            throw new BadRequestException("Bad Request","Invalid Argument Exception");
        }
    }

    public static boolean isInt(String d)
    {
        double aDouble = Double.parseDouble(d);
        return aDouble == (long) aDouble;
    }

}
