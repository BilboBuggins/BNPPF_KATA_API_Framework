Feature: Validate Post Message Apis


    Scenario: Verify post Message Api
        Given User calls BaseURL
        When User sends headers as
            |Key|Value|
            |Content-Type|application/json|
        When User sends post api with "<name>" "<email>" "<description>" "<phoneno>" "<subject>"
        And Using a "post" call with resources "postMessageApi"
        Then User gets a 201 status code


        Examples:
            |name		|email  		|description  							|phoneno  			|subject    |
            |Test		|Testtcs@tcs.com|Query to book a room for a night		|+918765312261		|Query		|







    Scenario: Verify post Message Api fails with appropirate error on passing empty name and email field
        Given User calls BaseURL
        When User sends headers as
            |Key|Value|
            |Content-Type|application/json|
        When User sends post api with "<name>" "<email>" "<description>" "<phoneno>" "<subject>"
        And Using a "post" call with resources "postMessageApi"
        Then User gets a 400 status code
        And Response has the correct error message "<error>"

        Examples:
            |name		|email  				|description  											|phoneno  				|subject    |error																			|
            |				|Testtcs@tcs.com|Query to book a room for a night		|+918765312261		|Query			|[Name may not be blank]										|
            |test		|								|Query to book a room for a night		|+918765312261		|Query			|[Email may not be blank]										|