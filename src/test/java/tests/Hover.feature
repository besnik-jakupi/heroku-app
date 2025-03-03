Feature: Hover

  Scenario Outline: Check hover over users
    Given User is on 'hovers' page
    And user hovers with mouse on '<user>' user
    Then user can see name user '<user>' properly displayed

    Examples:
      | user |
      |  1   |
      |  2   |
      |  3   |