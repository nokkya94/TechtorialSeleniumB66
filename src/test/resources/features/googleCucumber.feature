Feature: Find cucumber on google
  @google @cucumber
  Scenario: Compare the number of results
    When user is navigating to "https://www.google.com/"
    And user is searching for "cucumber cook book"
    Then user should compare the number of results from 1st page and 2nd page