Feature: download invoice after purchase order
  Scenario: user can successfully download invoice after purchase order
    Given user opens home page, adds products to cart, clicks cart button, clicks proceed to checkout, clicks registerlogin button and creates an account
    When when user clicks cart button, then clicks proceed to checkout, enters comment and click place order button, enters payment details and click pay and confirm order
    Then success message appears to user, user clicks download invoice, clicks continue and deletes account successfully