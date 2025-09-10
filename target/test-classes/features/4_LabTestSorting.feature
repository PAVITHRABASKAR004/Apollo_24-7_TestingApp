Feature: Verify sorting of lab tests
  As a user
  I want to sort lab test packages by price
  So that I can see them in ascending or descending order

  Background:
    Given the user is on the Lab Tests page with "Full Body Checkup" already selected

  @LabTestSorting @TS06
  Scenario: Sort by Price Low to High
    When the user opens the Sort By dropdown
    And the user chooses Price Low to High
    Then the lab tests should be sorted in ascending order of price

  @LabTestSorting @TS07
  Scenario: Sort by Price High to Low
    When the user opens the Sort By dropdown
    And the user chooses Price High to Low
    Then the lab tests should be sorted in descending order of price
