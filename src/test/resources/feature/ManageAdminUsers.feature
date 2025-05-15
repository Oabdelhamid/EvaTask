Feature: Manage Admin Users

  Scenario: Add a new admin user
    Given the user logs in with username "Admin" and password "admin123"
    When the user navigates to the Admin page
    And the user adds a new admin user with username "Omar1234"
    Then the total number of admin records should increase by 1
