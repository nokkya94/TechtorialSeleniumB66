Feature: Techtorial academy page login tests

  @neverFails
  Scenario: Happy path(successful) sign in
    When  user navigates to Techtorial academy home page
    And user uses "admin" as username and "admin123" as password
    Then user logged it