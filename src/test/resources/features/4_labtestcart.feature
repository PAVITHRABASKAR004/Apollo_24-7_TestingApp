Feature: Lab Test Cart Flow

  @TS08 @LabTestCartFlow
  Scenario: View Details, Proceed to Cart, and Add Members
    Given the user is logged in
    When the user clicks View Details
    And the user clicks Proceed to Cart
    And the user adds 1 member
