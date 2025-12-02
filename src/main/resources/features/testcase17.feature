Feature: remove products from cart
  Scenario: user removes products from cart
    Given user opens home page, adds products to cart
    When user clicks cart button and cart page is displayed and user clicks X button corresponding to a product
    Then that product is removed from cart