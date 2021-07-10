Feature: testCase1
  Scenario: Validate Functionality names
    Given user navigates to "http://demo.guru99.com/V4/" using recently saved username and password
    When user log in with userId "mngr294981" and password "jupYjYz"
    Then user should be able to validate all the functionality names and their size
    And all the functionality names must start with upper case