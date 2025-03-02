Feature: Validate Post Message Apis


Scenario: Verify post Message Api
    Given User calls BaseURL "https://automationintesting.online"
    When User sends headers as
    |Key|Value|
    |Content-Type|application/json|
    When User sends body as "postMessage.json"
    And Using a "post" call with resources "/message/"
    Then User gets a 201 status code 

    


