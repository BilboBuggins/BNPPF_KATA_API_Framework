Feature: Validate delete Message Apis


    Scenario: Verify delete Message Api
        Given User calls BaseURL
        When User sends headers as
            |Key		|Value|
            |Accept	|*/*	|
        And Using a "delete" call with resources "/message/1"
        Then User gets a 403 status code