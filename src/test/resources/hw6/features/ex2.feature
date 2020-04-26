Feature: User page web elements test

  Scenario: User Table Page test
    Given I open JDI GitHub site
    And  I login as username: 'Roman' pass: 'Jdi1234'
    When I navigate to User Table page through "Service" button in Header
    Then User Table page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
      | numberType | user             | description                       |
      | 1          | Roman            | Wolverine                         |
      | 2          | Sergey Ivan      | Spider Man                        |
      | 3          | Vladzimir        | Punisher                          |
      | 4          | Helen Bennett    | Captain America\nsome description |
      | 5          | Yoshi Tannamuri  | Cyclope\nsome description         |
      | 6          | Giovanni Rovelli | Hulk\nsome description            |
    And droplist should contain values in column Type for user Roman
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |