Feature:Cart Selection and Modification 

    Background:
    Given the user is logged in
    And the user has added at least one test to the cart
 

  Scenario: Select a test  in cart
    When the user clicks "Select" for a test
    Then the selection should be highlighted or confirmed

    