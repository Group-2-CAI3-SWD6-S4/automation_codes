Feature: view cart brand products
  Scenario: user views cart brand products
    Given user opens home page, clicks on any brand name
    When user is nagvigated to the brand page and brand products are displayed,user clicks on any other link on left side bar
    Then user is navigated to that brand page and can see products