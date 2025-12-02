Feature: search products and verify cart after login
  Scenario: user can search products successfully after login
    Given user opens home page, clicks on products button, enters product name in search input and clicks search
    When user adds products to cart and clicks cart button and clicks signuplogin button
    Then user navigates to cart page and can see the added products
