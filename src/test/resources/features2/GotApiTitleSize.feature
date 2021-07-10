Feature: verify nr of titles from GOT API
  @GetSize
  Scenario: get titles using restAssured
    When user executes "GET" request for GOT
    Then status code is 200 for GOT API
    And find all unique titles and verify the number of titles is more than 15

