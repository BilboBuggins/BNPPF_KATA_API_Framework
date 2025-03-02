Feature: Validate Put Message Apis


Scenario: Verify put Message Api
    Given User calls BaseURL "https://automationintesting.online"
    When User sends headers as
    |Key		|Value|
    |Accept	|*/*|
    And Using a "put" call with resources "/message/1/read"
    Then User gets a 403 status code 
    