## POC Based on mock service simulating a Subscription Service
#
## User creation

Feature: Final Exam Exercises

  Scenario: Testing an Endpoint - Get action and DELETE data if exists
    Given I get the response from the endpoint
    When I get the response, if we have any data I DELETE it
    Then I get the response code equals to 200

  Scenario: Initialize the POJO with 10 random data, make a code verification to check if there are repeated emails.
    Given I initialize the POJO with 10 random data verifying there are not emails repeated
    Then I perform a POST request of the 10 random data

  Scenario: Testing an Endpoint - Get request and make sure the are not duplicate email accounts
    Given I get the response from the endpoint
    Then I verify there are not duplicate email accounts


  Scenario: Testing an Endpoint - Update an existing AccountNumber
    Given I get the response from the endpoint
    Then I Update the last user's account number