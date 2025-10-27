# Feature: OrangeHRM Add Employee

#   As an HR admin
#   I want to add a new employee
#   So that the employee appears in the Employee List

#   Background:
#     Given I am logged in as an admin
#     And I am on the Employee List page
#  @smoke
#   Scenario: Add a new employee with required details
#     When I click on the "Add" button
#     And I enter "John" into the "First Name" field
#     And I enter "Doe" into the "Last Name" field
#     And I enter "12345" into the "Employee Id" field
#     And I click on the "Save" button
#     Then I should see a success message
#     And I should see "John Doe" in the Employee List