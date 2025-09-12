Feature: Cart Checkout - Patient Selection

  Background:
    Given the user is logged in

  Scenario: Proceed to cart
    When the user clicks "Proceed to Cart"
    Then the cart page should be displayed

  Scenario: Select the first patient
    Given the user is on the cart page
    When the user selects the first patient
    

  Scenario: Continue after patient selection
    Given the user clicks "Continue"
    Then the user should be navigated to the address selection page
