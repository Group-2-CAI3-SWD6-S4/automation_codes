Feature: Login Feature
  @HappyScenario
  Scenario: Register User With Existing Email
    Given User opens home page and press on signuplogin link
    When User enters valid email and password and click on signup button
    Then error message appears

#  Scenario: Contact Us Form
#    Given User opens home page and clicks on contact us
#    When User enters name, name, email, subject and message, uploads file, clicks on submit button, and OK
#    Then Success message appears ,lands in homepage when clicking home button

#  Scenario: Verify TestCases Page
#    Given User opens home page
#    When User clicks on test cases
#    Then test cases page appears