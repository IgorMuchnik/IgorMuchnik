Feature: Different Elements page

  Scenario: Get to Different Element Page and check the selectors
    Given I open JDI GitHub site
    And I login as username: 'Roman' pass: 'Jdi1234'
    And I navigate to Different Elements page through "Service" button in Header
    When I set checkboxes
      | Checkboxes |
      | Water      |
      | Wind       |
    And  I set radio 'Selen'
    And  I set dropdown 'Yellow'
    Then There is an individual log row for each checkbox
      | Checkboxes |
      | Water      |
      | Wind       |
    And There is a log row for radio button 'Selen'
    And There is a log row for dropdown value 'Yellow'