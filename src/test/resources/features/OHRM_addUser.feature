Feature: OrangeHRM add user

#   Background:

# @smoke @regression
#   Scenario: Add a new user with ESS role
#     Given I navigate to the OrangeHRM login page
#     When I enter valid username "Admin"
#     And I enter valid password "admin123"
#     And I click on Login button
#     Then I should be redirected to the dashboard
#     And I should see the Dashboard
#     When I click on User Management in the Admin menu
#     And I click on Add button
#     And I enter "Azgarkhan  Abdul" in the Employee Name field
#     And I enter "<randomUsername>" in the Username field
#     And I select "ESS" from the User Role dropdown
#     And I select "Enabled" from the Status dropdown
#     And I enter "Password123!" in the Password field
#     And I enter "Password123!" in the Confirm Pass field
#     And I click on the Save button
#     Then I should see the new user in the user list
#     When I click on the user dropdown in the top-right corner
#     And I select Logout
#     Then I should be redirected to the login page
#     And I should see the Login button


# Scenario: Add a new user with Admin role
#   Given I navigate to the OrangeHRM login page
#     When I enter valid username "Admin"
#     And I enter valid password "admin123"
#     And I click on Login button
#     Then I should be redirected to the dashboard
#     And I should see the Dashboard
#     When I click on User Management in the Admin menu
#     And I click on Add button
#     And I enter "Joseph  Evans" in the Employee Name field
#     And I enter "<randomUsername>" in the Username field
#     And I select "Admin" from the User Role dropdown
#     And I select "Enabled" from the Status dropdown
#     And I enter "Password123!" in the Password field
#     And I enter "Password123!" in the Confirm Pass field
#     And I click on the Save button
#     Then I should see the new user in the user list
#     When I click on the user dropdown in the top-right corner
#     And I select Logout
#     Then I should be redirected to the login page
#     And I should see the Login button