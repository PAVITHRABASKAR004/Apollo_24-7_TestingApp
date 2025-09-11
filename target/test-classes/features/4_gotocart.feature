@TS08 @CartFlow
Feature: Cart page functionality

  Scenario: Add a new family member after selecting a test
    Given the selected test is displayed in the cart or selection area
    When the user clicks on "View Details"
    And the user clicks "Proceed to Cart"
    And the user clicks on "+ Add Member"
    And the user enters the following details:
      | Name     | John Doe    |
      | DOB      | 01-01-1990  |
      | Gender   | Male        |
      | Relation | Brother     |
    And the user clicks "Save"
    Then the new member "John Doe" should be added in the cart
