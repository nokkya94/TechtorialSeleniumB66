Feature: Find cucumber on amazon
  @amazon
  Scenario: Validating search results for cucumber on amazon page
    When user navigates to "https://www.amazon.com/" home page
    And user is searching for cucumber in searchbox
    Then user should validate the number of search results under the search bar to be more than 100

  @test
  Scenario: Negative search scenario
    When user navigates to "https://www.amazon.com/" home page
    And user enters "java basics" in search field
    Then the result page will not have topics about "python"

