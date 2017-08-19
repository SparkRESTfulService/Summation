package cucumberTest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Do;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import resources.Utility;
import shiver.me.timbers.data.random.RandomStrings;

import java.text.DecimalFormat;

import static org.apache.commons.lang3.math.NumberUtils.isParsable;
import static org.junit.Assert.assertEquals;
import static resources.Utility.getRandomNumber;
import static resources.Utility.getRandomString;
import static resources.Utility.isInt;

@PropertySource("classpath:application.properties")
public class addition {

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
        this.result = Utility.sendGetRequest(number1,number2);

    }

    @Then("^the result should be the total of both$")
    public void theResultShouldBeTheTotalOfBoth() {
        String expected = "";
            if (!isInt(number1) || !isInt(number2)) {
                expected = String.valueOf(Double.parseDouble(number1) + Double.parseDouble(number2));
            } else {
                expected = String.valueOf(Long.parseLong(number1) + Long.parseLong(number2));

            }
        assertEquals(expected,result);
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
        assertEquals(result,exceptionMessage);
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
        number1 = getRandomNumber();
        number2 = "!@#$%";
    }

    @Then("^I should get the same number in response$")
    public void iShouldGetTheSameNumberInResponse()  {
        assertEquals(result,number1);
    }
}
