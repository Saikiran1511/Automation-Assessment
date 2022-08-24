
Feature: Search Product Feature

  @UIAssessment
  Scenario Outline: Search Product
    Given user lands on application
    And user searches for product "<productName>"
    When user clicks on the product "<productName>"
    Then user verifies price and description are present
    And product information is displayed

    Examples:
    |productName|
    |Safari Prune Juice|




