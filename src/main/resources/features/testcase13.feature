Feature: Verify product quantity in cart
  Scenario: user verifies quantity in cart
    Given User opens homepage, clicks view product and increases the quantity to four
    When User clicks add to cart then clicks view cart
    Then product is displayed in cart page with exact quantity