Feature: add to cart from recommended items
  Scenario: user can successfully add items from recommended
    Given user opens home page, scrolls to the bottom of page
    When user clicks on add to cart on recommended product and click on view cart
    Then that product is displayed in cart page