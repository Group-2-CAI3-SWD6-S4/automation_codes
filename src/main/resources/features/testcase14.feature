Feature: place order
  Scenario: register while checkout
    Given user opens homepage, adds products to cart,clicks cart button, click proceed to checkout, click register and fill all the details and clicks continue
    When logged in as appears at top,user clicks cart button and proceed to checkout button, verify address details and order, user enters comment and click place order, and enters payment details, user clicks pay and confirm button
    Then success message appears to user, user clicks on delete account,account deleted message appears to user