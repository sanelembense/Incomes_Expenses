# Author: Sanele Mbense
  # Date: 5 April 2022
  # Description:The following User Scenarios are bases off Income Expenses, the user is instructed to do.
  #    This test feature file executes the following:
  # - Creating a new user
  # - Creating a budget
  # - Adding couple of transactions in different categories
  # - Making sure the totals and subtotals match
  # - Deleting a transactions/category
  # - Create 2nd user (Multi-user) and assign an already created budget list

@Registration
Feature:
  Scenario:
    Given new user completes sign up
    When sign up successful
    Then returned to login page
      #user creates a new user

  Scenario:
    Given create multi user completes sign up
    When multi user successful
    Then multi user can login
      # Creates the second user

  Scenario:
    Given The user enters incorrect User details
    #When user enters incorrect details "Invalid username or password." is displayed and user is not logged in

  Scenario:
    Given user creates a new budget
    When user opens a new budget page
    And user adds Budget name
    And user clicks on the add button
    Then user confirm my budget list
      # Opens the budget page
      # Creates a new budget
      # Verifies if the new budget was created successfully

  Scenario:
    Given Totals and Expenses match
    When user opens stats page
    Then all total income and total expenses are displayed
     # Goes into the statistics page
      # Selects the empty filter option (to show all) on the "Filter by List" filter
      # Selects the empty filter option (to show all) on the "Filter by User" filter
      # Checks the Total Income and Total Expenses values
      # Checks if the graphs are displayed
      # Checks if the amounts on the graphs are correct
      # Checks if the totals are correct from the Income and Expenses values


  Scenario:
    Given user can add multiple users to a budget
    When user assigns another user to the budget
    Then confirm successful assignment
      # Opens the budget page
      # adds a multi_users onto the budget
      #checks if the second user was added successfully
