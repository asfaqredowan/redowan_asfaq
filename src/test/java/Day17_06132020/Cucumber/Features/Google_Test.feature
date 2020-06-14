Feature: Google Test Scenarios

  #following use case covers google test scenarios
  Scenario Outline: TC01: Allow user to capture google search number on search result
    Given I navigate to google home
    When I enter keyword <Cars> on search field
    When I click on search icon
    When I capture search result and print it
    When I click on more icon
    When I can select the value <More>


    Examples:
    | Cars |More|
    | BMW |Videos|
    | Honda |Books|

    # each scenario outline are individual test cases. no relation between them
    Scenario: TC02: Allow user to go to google sign in page
