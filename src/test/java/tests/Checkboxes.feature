Feature: Checkboxes

  Scenario: User validates if checkboxes work
    When User is on 'checkboxes' page
    And user checks the 'checkbox 1'
    Then the 'checkbox 1' should be checked