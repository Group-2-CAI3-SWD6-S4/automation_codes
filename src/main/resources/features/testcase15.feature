Feature:  place order, register before checkout
  Scenario: user registers before checkout
    Given User opens home page and clicks signuplogin, fills all details in signup and creates account,adds products to cart and clicks cart button
    When User clicks proceed to checkout, enters comment and click place order, enters payment details and click on pay and confirm order button
    Then success message appears to user and user deletes account successfully