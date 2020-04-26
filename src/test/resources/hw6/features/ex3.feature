Feature: User page web elements test

  Scenario: User Table Page logs test
    Given I open JDI GitHub site
    And  I login as username: 'Roman' pass: 'Jdi1234'
    And I navigate to User Table page through "Service" button in Header
    When I set 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section