Feature: Test update password functionality

  Background: 
    #Given browser is open
    #And user is on the login page
    When user enters username and password
    And user press login button
    Then user is navigated to the home page
    When user clicks change password button
    Then user is navigated to the update password page

  Scenario: Check update password functionality with providing valid password
    When user enters valid password
    And user enters password and confirms password
    And user clicks save button
    Then success message is apears

  Scenario: Check update password functionality with providing invalid password
    When user enters invalid password
    And user enters password and confirms password
    And user clicks save button
    Then invalid parameter message is apears
