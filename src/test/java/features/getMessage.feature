Feature: Validate Get Message Apis


  Scenario: Verify get Message Api has a particular entry using name
    Given User calls BaseURL
    When Using a "get" call with resources "/message"
    Then User gets a 200 status code
    And Response has a single entry with the name as "James Dean"




  Scenario: Verify get Message Api for a particular message id and validate email
    Given User calls BaseURL
    When Using a "get" call with resources "/message/1"
    Then User gets a 200 status code
    And Response has the "messageid" as "1"





  Scenario: Verify get Message Api for the count of messages
    Given User calls BaseURL
    When Using a "get" call with resources "/message/count"
    Then User gets a 200 status code
    And Response has the "count" as "4"