Feature: Find Iphones on amazon
  @results
  Scenario: Validate the number of results from iphone page on amazon
    Given user navigates to "https://amazon.com" for searching
    When user is searching for "Iphones" in search box
    Then number of results should be more than 0
  @prices
  Scenario: Validate the prices of all phones from previous given page
    Given user navigates to "https://amazon.com" for searching
    When user is searching for "Iphones" in search box
    Then sum of the result's prices must be > than 0