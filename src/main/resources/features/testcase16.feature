Feature: place order, login before checkout
  Scenario: user is logged in before checkout
    Given user opens home page,and loggs in,adds products to cart,views cart and clicks proceed to checkout
    When user verifies address and order details, enters comment and clicks place order, user enters payment details and clicks pay and confirm button
    Then success message appears to user, user deletes account successfully