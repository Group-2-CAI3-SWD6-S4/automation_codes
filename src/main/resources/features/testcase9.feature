Feature: Search Product
  Scenario: User searches for a product
    Given User opens homepage and clicks on products button
    When User enters product name in search input and clicks search button
    Then Products related to search are visable