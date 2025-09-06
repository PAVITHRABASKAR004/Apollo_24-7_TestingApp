Feature: Launch Apollo 24/7 Website

Scenario: Launch website in Chrome
  Given I open "Chrome" browser
  When I navigate to "https://www.apollo247.com"
  Then the homepage should load successfully
