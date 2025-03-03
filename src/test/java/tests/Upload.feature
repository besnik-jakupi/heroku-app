Feature: Upload

  Scenario: Check upload if works properly
    Given User is on 'upload' page
    And user uploads file 'logo.jpg'
    Then user verifies the file is uploaded successfully