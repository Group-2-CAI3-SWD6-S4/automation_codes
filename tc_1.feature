Feature: User Signup and Account Deletion

  Scenario: Create new user account and delete it successfully
    Given user launches the browser and user navigates to "http://automationexercise.com" and home page is visible successfully
    When user clicks on "Signup / Login" button
    Then "New User Signup!" section is visible
    When user enters name and email address and user clicks on "Signup" button
    Then "ENTER ACCOUNT INFORMATION" section is visible
    When user fills account details including Title, Name, Email, Password, and Date of Birth and user selects "Sign up for our newsletter!" checkbox and user selects "Receive special offers from our partners!" checkbox and user fills address details including First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, and Mobile Number and user clicks on "Create Account" button
    Then "ACCOUNT CREATED!" message is visible



