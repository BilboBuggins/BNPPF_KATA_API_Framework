Feature: Validate Put Message Apis


    Scenario: Verify put Message Api
        Given User calls BaseURL
        When User sends headers as
            |Key		|Value|
            |Accept	|*/*|
        And Using a "put" call with resources "putMessageApi"
        Then User gets a 403 status code
    