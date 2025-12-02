Feature: contact us feature
  Scenario: Contact Us Form
    Given User opens home page and clicks on contact us
    When User enters name, name, email, subject and message, uploads file, clicks on submit button, and OK
    Then Success message appears ,lands in homepage when clicking home button