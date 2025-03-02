Feature: Validate Get Message Apis


  Scenario: Verify get Message Api has a particular entry using name
    Given User calls BaseURL "https://automationintesting.online"
    When Using a "get" call with resources "/message"
    Then User gets a 200 status code
    #And Response has a single entry with the name as "James Dean"
    
