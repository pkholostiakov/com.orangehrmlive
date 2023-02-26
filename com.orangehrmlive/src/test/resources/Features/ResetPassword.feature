Feature: Test reset password functionality

  Background: 
    #Given browser is open
    #And user is on the login page
    When user press forgot password button
    Then user is navigated to the reset password page

  Scenario: Check reset password functionality with valid username
    When user enters username
    And user press reset password button
    Then it appears sent a new password to the e-mail message
