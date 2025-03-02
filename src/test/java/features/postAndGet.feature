Feature: Validate Post Message Api and retrive that api using the Get Api call.


  Scenario: Verify post Message Api
    Given User calls BaseURL
    When User sends headers as
      |Key|Value|
      |Content-Type|application/json|
    When User sends post api with "<name>" "<email>" "<description>" "<phoneno>" "<subject>"
    And Using a "post" call with resources "postMessageApi"
    Then User gets a 201 status code
    And User captures the "messageid"


    Examples:
      |name		|email  			|description  											|phoneno  				|subject    |
      |Test		|Test@testsite.com	|Query to book a room for a night		|+918765312261		|Query			|



  Scenario: Verify get Message Api for a particular message id and validate email
    Given User calls BaseURL
    When Using a get call with the captured resources id
    Then User gets a 200 status code
    And Response has the "name" as "Test"
    And Response has the "email" as "Test@testsite.com"