Feature: Alerts
  Background:
    Given User is on 'javascript_alerts' page

  Scenario Outline: Check Alerts
    When user clicks button with text '<alert>'
    Then user can see text '<alertText>' on alert

    Examples:
      |        alert             |     alertText       |
      |  Click for JS Alert      |   I am a JS Alert   |
      |  Click for JS Confirm    |   I am a JS Confirm |
      |  Click for JS Prompt     |   I am a JS prompt  |