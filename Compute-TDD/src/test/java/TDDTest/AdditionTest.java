package TDDTest;

import com.BadRequestException;
import com.Summation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import resources.Utility;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = {TestConfiguration.class})
@RunWith(MockitoJUnitRunner.class)
public class AdditionTest extends Utility {
    Summation summation;

    @Before
    public void setUp(){
        summation = new Summation();
    }

    @After
    public void tearDown(){
        summation = null;
    }

//EXCEPTION SCENARIOS - Hardcoded Values

    @Test(expected = BadRequestException.class)
    public void test_add_number_names_instead_of_numbers() throws Exception{
        summation.sum("one","two");
    }

    @Test(expected = BadRequestException.class)
    public void test_add_with_special_characters() throws Exception{
        summation.sum("@","$");
    }

    @Test(expected = BadRequestException.class)
    public void test_add_with_both_strings() throws Exception{
        summation.sum("num1","num2");
    }

    @Test(expected = BadRequestException.class)
    public void test_add_string_and_number() throws Exception{
        summation.sum("2","num");
        summation.sum("num","3");
    }

    @Test(expected = BadRequestException.class)
    public void test_add_string_and_special_character() throws Exception{
        summation.sum("#","num");
        summation.sum("num","#");
    }

    @Test(expected = BadRequestException.class)
    public void test_add_number_and_special_character() throws Exception{
        summation.sum("#","54");
        summation.sum("54","*");
    }

    @Test(expected = BadRequestException.class)
    public void test_add_double_and_special_character() throws Exception{
        double num1 = Double.parseDouble(getRandomDouble());
        summation.sum(String.valueOf(num1),"#");
    }

    @Test(expected = BadRequestException.class)
    public void test_add_empty_input() throws Exception{
        summation.sum("","54");
        summation.sum("-2374.836","");
    }

//SUCCESS SCENARIOS - Random Values

    //Integer and Long Scenarios
    @Test
    public void test_add_positive_integers() {
        int num1 = Integer.parseInt(getRandomPositiveNumber());
        int num2 = Integer.parseInt(getRandomPositiveNumber());
        String expected = String.valueOf(num1 + num2);

        String actual = summation.sum(String.valueOf(num1),String.valueOf(num2));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_positive_number_with_zero() {
        int num1 = Integer.parseInt(getRandomPositiveNumber());
        String expected = String.valueOf(num1);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(0));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_negative_integers() {
        int num1 = Integer.parseInt(getRandomNegativeNumber());
        int num2 = Integer.parseInt(getRandomNegativeNumber());
        String expected = String.valueOf(num1 + num2);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(num2));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_negative_number_with_zero() {
        int num1 = Integer.parseInt(getRandomNegativeNumber());
        String expected = String.valueOf(num1);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(-0));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_positive_and_negative_integers(){
        int num1 = Integer.parseInt(getRandomNegativeNumber());
        int num2 = Integer.parseInt(getRandomPositiveNumber());
        String expected = String.valueOf(num1 + num2);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(num2));
        assertEquals(expected,actual);
    }

    //Double and Float Scenarios
    @Test
    public void test_add_positive_double() {
        double num1 = Double.parseDouble(getRandomPositiveDouble());
        double num2 = Double.parseDouble(getRandomPositiveDouble());
        String expected = String.valueOf(num1 + num2);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(num2));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_negative_double() {
        double num1 = Double.parseDouble(getRandomNegativeDouble());
        double num2 = Double.parseDouble(getRandomNegativeDouble());
        String expected = String.valueOf(num1 + num2);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(num2));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_positive_and_negative_doubles(){
        double num1 = Double.parseDouble(getRandomNegativeDouble());
        double num2 = Double.parseDouble(getRandomPositiveDouble());
        String expected = String.valueOf(num1 + num2);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(num2));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_negative_double_with_zero() {
        double num1 = Double.parseDouble(getRandomNegativeDouble());
        String expected = String.valueOf(num1);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(-0.0));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_positive_double_with_zero() {
        double num1 = Double.parseDouble(getRandomPositiveDouble());
        String expected = String.valueOf(num1);
        String actual = summation.sum(String.valueOf(num1),String.valueOf(0.0));
        assertEquals(expected,actual);
    }

    //Mixed
    @Test
    public void test_add_integer_and_double() {
        int num1 = Integer.parseInt(getRandomNumber());
        double num2 = Double.parseDouble(getRandomDouble());

        String expected = String.valueOf(num1 + num2);

        String actual = summation.sum(String.valueOf(num1),String.valueOf(num2));
        assertEquals(expected,actual);
    }

//SUCCESS SCENARIOS - Hardcoded Values

    //Int range
    @Test
    public void test_add_negative_integer_to_negative_long_after_addition(){
        int minInt = Integer.MIN_VALUE;
        String expected = String.valueOf(Long.valueOf(minInt) - 1);
        String actual = summation.sum(String.valueOf(minInt),String.valueOf(-1));
        assertEquals(expected,actual);
    }
    @Test
    public void test_add_integer_to_long_after_addition(){
        int maxInt = Integer.MAX_VALUE;
        String expected = String.valueOf(Long.valueOf(maxInt) + 1);
        String actual = summation.sum(String.valueOf(maxInt),String.valueOf(1));
        assertEquals(expected,actual);
    }



}
