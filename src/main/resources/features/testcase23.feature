Feature: verify address details in checkout page
  Scenario: user can successfully verify address details in checkout page
    Given user opens home page, clicks on signuplogin page,fills all the details and creates an account and clicks continue
    When user adds products to cart, clicks cart button and then clicks proceed to checkout, with the delivery and billing address the same as regiteration address
    Then user clicks delete account and success message is shown , user clicks on continue