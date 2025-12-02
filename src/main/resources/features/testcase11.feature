Feature: Verify subscription in cart page
  Scenario: user verifies subscription in cart page
    Given user opens home page and clicks on cart button and scrolls down to footer
    When user enters email address in input and clicks arrow button
    Then success message appears to user