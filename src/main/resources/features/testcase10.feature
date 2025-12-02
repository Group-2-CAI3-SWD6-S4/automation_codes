Feature: Verify Subscription in home page
  Scenario: user successfully subscribed
    Given user opens home page and scrolls to footer
    When user enters email address in input and click arrow button
    Then Success message appears
