package com;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class SummationService {

    @RequestMapping(method=GET,value="/calculator/add/{num1}/{num2}")
    public String summationTwoNumbers(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        return new Summation().sum(num1,num2);
    }
    @RequestMapping(method=GET,value="/calculator/add/{num1}")
    public String summationOneNumber(@PathVariable("num1") String num1) throws Exception{
        return new Summation().sum(num1);
    }
}
