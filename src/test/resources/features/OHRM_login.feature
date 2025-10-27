Feature: OrangeHRM Login
   
   @smoke @regression
  Scenario: Successful login with valid credentials
    Given I navigate to the OrangeHRM login page
    When I enter valid username "Admin"
    And I enter valid password "admin123"
    And I click on Login button
    Then I should be redirected to the dashboard
    And I should see the Dashboard
    When I click on the user dropdown in the top-right corner
    And I select Logout
    Then I should be redirected to the login page
    And I should see the Login button