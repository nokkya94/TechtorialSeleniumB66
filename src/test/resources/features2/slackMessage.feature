Feature: chek messages in slack
  @PositiveTestingMessagesSlack
  Scenario: Positive test to post message in slack
    Given user checks the specified message in slack
    When user posts the specified message in slack
    Then user will get that message from slack