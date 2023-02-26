Feature: Test Admin management functionalities

  Background: 
    #Given browser is open
    #And user is on the login page
    When user enters username and password
    And user press login button
    Then user is navigated to the home page
    When user clicks admin button in main menu
    Then user is navigated to the admin management page

  Scenario: Check remove user record functionality
    When user press delete button near particular user
    And user confirm to delete the record in the allert message
    Then the particular user record is deleted

  Scenario: Check counter of user records work properly
    When user press delete button near some user
    And user confirm to delete the record in the allert message
    Then the counter of user records becomes less by one
