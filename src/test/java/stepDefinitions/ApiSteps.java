package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utils.ApiUtils;

import static org.junit.Assert.assertEquals;

public class ApiSteps {

    private Response response;

    @Given("^I make a GET request to \"([^\"]*)\"$")
    public void iMakeAGetRequestTo(String endpoint) throws Exception {
        response = ApiUtils.getRequest("https://reqres.in/api/users", "page=2");
    }

    @Then("^I should get a successful response$")
    public void iShouldGetASuccessfulResponse() {
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        String responseBody = response.getBody().asString();
    }
}

