Feature: Validate Post Message Apis


    Scenario: Verify post Message Api
        Given User calls BaseURL "https://automationintesting.online"
        When User sends headers as
            |Key|Value|
            |Content-Type|application/json|
        When User sends post api with "<name>" "<email>" "<description>" "<phoneno>" "<subject>"
        And Using a "post" call with resources "/message/"
        Then User gets a 201 status code


        Examples:
            |name		|email  		|description  							|phoneno  			|subject    |
            |Test		|Testtcs@tcs.com|Query to book a room for a night		|+918765312261		|Query		|

    


