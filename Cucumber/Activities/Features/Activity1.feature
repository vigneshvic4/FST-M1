@activity1
Feature: First Test

@smoketest
Scenario: Opening a webpage using Selenium
    Given User is on Google home page
    When User types in Cheese and hits ENTER
    Then Show how many search results were shown
    And Close the browser