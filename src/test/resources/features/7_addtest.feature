Feature: Add Test Flow in Cart Checkout

  Background:
    Given the user is logged in
  
  Scenario: Scroll down and click Add Test
    When the user scrolls down to the "Add Test" button
    And the user clicks on the "Add Test" button
    Then the Add Test section should be displayed

  
  Scenario: Select PCOD Screening under WomenCare
    When the user scrolls up to the WomenCare category
    And the user selects "PCOD Screening" from WomenCare
    

  
  Scenario: select test 
    Given the user clicks first test from "PCOD Screening"
    When the user selects the first available test

  
  Scenario: Navigate to cart after adding test
    When the user clicks on the "Go to Cart" button
    Then the cart page should display the newly added test
