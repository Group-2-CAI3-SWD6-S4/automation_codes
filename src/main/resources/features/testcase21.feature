Feature: add review on product
  Scenario: user can successfully add review on product
    Given user opens home page, clicks on products button then view product button
    When user enters name, email and the review and clicks submit button
    Then success message appears to the user