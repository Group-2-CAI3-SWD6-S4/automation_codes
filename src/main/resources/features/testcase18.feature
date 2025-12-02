Feature: view category products
  Scenario: user can view category products
    Given user opens home page and clicks on women category under categories
    When user clicks on any category link under women, that category page is displayed
    Then user clicks on subcategory link men category and the user is navigated to that page