Feature: New Window feature

  Scenario: Validate new window opening
    Given User is on 'windows' page
    And user clicks Click here text to open new window
    Then user verifies the 'windows/new' opened window