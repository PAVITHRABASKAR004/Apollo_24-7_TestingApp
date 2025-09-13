Feature: Logout after adding test

  Background:
    Given the user is logged in

  Scenario: Navigate to cart and logout
    When the user clicks the Back button
    And the user clicks on the My Account icon
    
