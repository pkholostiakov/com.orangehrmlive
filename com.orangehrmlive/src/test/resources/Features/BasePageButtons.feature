Feature: Test all the base page button works at the home page

  Scenario: Base page buttons works at the home page
    #Given browser is open
    #And user is on the login page
    When user enters username and password
    And user press login button
    Then user is navigated to the home page
    Then all the button works at the home page
    Then user is logout
