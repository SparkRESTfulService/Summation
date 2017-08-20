package cucumberTest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.context.annotation.PropertySource;
import resources.Utility;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static resources.Utility.getRandomNumber;
import static resources.Utility.getRandomString;
import static resources.Utility.isInt;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@PropertySource("classpath:application.properties")
public class addition {
    private static final Log log = LogFactory.getLog(addition.class);

    String number1;
    String number2;
    String number3;

    String result;



    @Given("^I have two numbers \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iHaveTwoNumbersAnd(String number1, String number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @When("^I request the addition of both$")
    public void iRequestTheAdditionOfBoth() {
        log.info("integration test call:"+number1+":"+number2);
        this.result = Utility.sendGetRequest(number1,number2);

    }

    @Then("^the result should be the total of both$")
    public void theResultShouldBeTheTotalOfBoth() {
        Number expected;
            if (!isInt(number1) || !isInt(number2)) {
                BigDecimal bd1 = new BigDecimal(number1);
                BigDecimal bd2 = new BigDecimal(number2);
                expected = bd1.add(bd2);

            } else {
                expected = Long.parseLong(number1) + Long.parseLong(number2);

            }
           log.info("integration test result:"+expected);
        assertEquals(expected.toString(),result);
    }

    @Given("^I have one number$")
    public void iHaveOneNumber() {
        this.number1 =getRandomNumber();
    }

    @When("^I send the request with only that number$")
    public void iSendTheRequestWithOnlyThatNumber() {
        this.result = Utility.sendGetRequest(number1);
    }

    @Then("^I should get \"([^\"]*)\" exception$")
    public void iShouldGetException(String exceptionMessage) {
        assertEquals(exceptionMessage,result);
    }

    @Given("^I have three numbers$")
    public void iHaveThreeNumbers() {
        this.number1 = getRandomNumber();
        this.number2 = getRandomNumber();
        this.number3 = getRandomNumber();

    }

    @When("^I send the request to add all of them$")
    public void iSendTheRequestToAddAllOfThem() {
        this.result = Utility.sendGetRequest(number1,number2,number3);

    }

    @Given("^I have a number and a string$")
    public void iHaveANumberAndAString() {
        number1 = getRandomNumber();
        number2 = getRandomString();

    }

    @Given("^I have a number and a special character$")
    public void iHaveANumberAndASpecialCharacter(){
        number1 = "!@#$%";
        number2 = getRandomNumber();
    }

    @Then("^I should get the same number in response$")
    public void iShouldGetTheSameNumberInResponse()  {
        assertEquals(number1,result);
    }
}
