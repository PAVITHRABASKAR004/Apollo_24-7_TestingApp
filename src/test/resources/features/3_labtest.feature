@LabTestPackage
Feature: Lab Test Package Selection

  Background:
    Given the user clicks on Lab Tests tab
    Then the user should be navigated to the Lab Tests page

  @TS05
  Scenario: Verify selecting a lab test package (Full Body Checkup)
    When the user browses the categories
    And the user selects "Full Body Checkup" under Doctor Created Health Checks
    
