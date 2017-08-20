package com;

import java.math.BigDecimal;
import java.text.Bidi;
import java.text.DecimalFormat;

import static org.apache.commons.lang3.math.NumberUtils.isParsable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Summation {
    private static final Log log = LogFactory.getLog(Summation.class);
    public Summation(){
    }

    public String sum (String num1, String num2) throws BadRequestException{
        log.info("String received  num1:"+num1);

        if(isParsable(num1) && isParsable(num2)){
            log.info("int  num1:"+num1+": checking if Int"+isInt(num1));
            log.info("int  num2:"+num2+": checking if Int"+isInt(num2));
                if (!isInt(num1) || !isInt(num2)) {
//                    double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    BigDecimal bd1 = new BigDecimal(num1);
                    BigDecimal bd2 = new BigDecimal(num2);
                    BigDecimal result = bd1.add(bd2);

                    String result1 = String.valueOf(result);
                    log.info("not int reslt:"+result);
                    return result1;
                } else {
                    long result = Long.parseLong(num1) + Long.parseLong(num2);
                    String result1 = String.valueOf(result);
                    log.info("int result:"+result);
                    return result1;
                }
//            return "-2147488478.34382";
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
