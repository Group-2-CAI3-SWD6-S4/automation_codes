Feature: Add products in cart
  Scenario: user adds products in cart
    Given user opens home page and clicks products button, hovers over first product and clicks add to cart
    When user clicks continue shopping button, hovers over second product and clicks add to cart, clicks view cart button
    Then both products are added to cart with the correct prices, quantity and total price