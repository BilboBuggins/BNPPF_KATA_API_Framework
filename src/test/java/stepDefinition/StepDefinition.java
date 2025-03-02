package stepDefinition;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import body.GetMessages;
import body.Messages;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.TestDataBuilder;
import resources.Utility;
import io.restassured.path.json.JsonPath;

public class StepDefinition extends Utility{
    private RequestSpecification requestSpecification;
    private Response response;
    private String stringResponse;
    private String capturedStringResponse;
    private GetMessages getMessagesclass;
    TestDataBuilder testDataBuilder= new TestDataBuilder();


    @Given("User calls BaseURL")
    public void user_calls_base_url() throws IOException  {
        requestSpecification =  given().spec(requestSpecBuilder());
    }

    @When("User sends headers as")
    public void user_sends_headers_as(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);
        for(Map<String, String> pairs:data) {
            requestSpecification=requestSpecification.headers(pairs.get("Key"),pairs.get("Value"));
        }
    }

    @When("User sends post api with {string} {string} {string} {string} {string}")
    public void user_sends_post_api_with(String name, String email, String description, String phoneno, String subject) {
        requestSpecification=requestSpecification.body(testDataBuilder.postMessageload(description, email, name, phoneno, subject));
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
        response=response.then().spec(responseSpecBuilder(code)).log().all().extract().response();
    }

    @Then("Response has a single entry with the name as {string}")
    public void response_has_a_single_entry_with_the_name_as(String value) {
        int count=0;
        getMessagesclass=response.as(GetMessages.class);
        List<Messages> getcount=getMessagesclass.getMessages();

        for(int i=0; i<getcount.size();i++) {
            if(getcount.get(i).getName().equals(value)) {
                count++;
            }

        }
        assertEquals(1, count);

    }

    @Then("Response has the {string} as {string}")
    public void response_has_the_as(String key, String value)
    {
        stringResponse=response.asPrettyString();
        JsonPath jp= new JsonPath(stringResponse);
        capturedStringResponse=jp.get(key).toString();
        assertEquals(capturedStringResponse,value);

    }

    @Then("Response has the correct error message {string}")
    public void response_has_the_correct_error(String value)
    {
        stringResponse=response.asPrettyString();
        JsonPath jp= new JsonPath(stringResponse);
        capturedStringResponse=jp.get("fieldErrors").toString();
        System.out.println(capturedStringResponse);
        capturedStringResponse.contains(value);
        assertEquals(capturedStringResponse,value);

    }


}