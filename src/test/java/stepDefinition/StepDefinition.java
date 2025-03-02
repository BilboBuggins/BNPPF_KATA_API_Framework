package stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
public class StepDefinition {
    private RequestSpecification requestSpecification;
    private Response response;
    private
    @Given("User calls BaseURL {string}")
    public void user_calls_base_url(String baseurl)  {

        requestSpecification=given().log().all().baseUri(string);
    }

    @When("Using a {string} call with resources {string}")
    public void using_a_call(String call, String resources) {
        if(call.equalsIgnoreCase("get")) {
            response=requestSpecification.when().get(resources);
        }
        else if(call.equalsIgnoreCase("post")) {
            response=requestSpecification.when().post(resources);
        }
        else if(call.equalsIgnoreCase("put")) {
            response=requestSpecification.when().put(resources);
        }
        else if(call.equalsIgnoreCase("patch")) {
            response=requestSpecification.when().patch(resources);
        }
        else if(call.equalsIgnoreCase("delete")) {
            response=requestSpecification.when().delete(resources);
        }
    }

    @Then("User gets a {int} status code")
    public void user_gets_a_status_code(Integer code) {
        response=response.then().statusCode(statusCode).log().all().extract().response();

    }

}
