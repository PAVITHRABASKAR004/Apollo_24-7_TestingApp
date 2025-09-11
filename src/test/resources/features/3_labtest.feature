Feature: Lab Test Package Selection

  
  Scenario: Verify complete lab test selection flow
    Given the user is logged in
    When the user clicks on Lab Tests tab
    Then the user should be navigated to the Lab Tests page
    When the user selects "Full Body Checkup" under Doctor Created Health Checks
    And the user selects the first test
    Then the selected test should be displayed in the cart or selection area