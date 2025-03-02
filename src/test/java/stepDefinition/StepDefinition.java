package stepDefinition;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class StepDefinition {
    private RequestSpecification requestSpecification;
    private Response response;
    @Given("User calls BaseURL {string}")
    public void user_calls_base_url(String baseurl)  {

        requestSpecification=given().log().all().baseUri(baseurl);
    }

    @When("User sends headers as")
    public void user_sends_headers_as(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);
        for(Map<String, String> pairs:data) {
            requestSpecification=requestSpecification.headers(pairs.get("Key"),pairs.get("Value"));
        }
    }

    @When("User sends body as {string}")
    public void user_sends_body_as(String body) throws IOException {
        requestSpecification=requestSpecification.body(new String(Files.readAllBytes(Paths.get("src/main/java/body/"+body))));
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
        response=response.then().statusCode(code).log().all().extract().response();

    }

}
