Feature: User Login

  Scenario: Login with valid credentials
    Given user launches the browser and navigates to "http://automationexercise.com" and home page is visible successfully
    When user clicks on "Signup / Login" button
    Then "Login to your account" section is visible
    When user enters valid email and password and clicks on "Login" button
