Feature: Verify all products and product detail page
  Scenario: user opens detail page
    Given User opens home page and clicks on products button
    When User clicks on view product
    Then user is landed to product detail page and can view product name, category, price, availability, condition and brand
