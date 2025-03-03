Feature: Drag and drop

  Scenario: Check drag and drop if works properly
    Given User is on 'drag_and_drop' page
    And user drags 'column-a' element to element 'column-b' position
    Then user verifies column 'A' is in second position