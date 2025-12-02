Feature: verify scroll up using arrow button and scroll down functionality
  Scenario: user can scroll up and down using the arrow button
    Given user opens home page, user scroll down page to bottom
    When user clicks on arrow at bottom right to move upward
    Then page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screenT