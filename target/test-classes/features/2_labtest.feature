Feature: Lab Tests Navigation

  Scenario: Navigate to Lab Tests after login
    Given user is on the login page
    When the user enter the valid Mobile Number as "9876543210"
    And user request an otp
    And user enter the otp
    And the user clicks on Lab Tests tab
    Then the user should be navigated to the Lab Tests page
