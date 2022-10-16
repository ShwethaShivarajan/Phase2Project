Feature: Login Feature Scenario

  Background: 
    Given I have launched the application

  @Sanity @Regression
  Scenario Outline: This is a positive login flow
    When I enter a correct "<UserName>" and "<Password>"
    And I click on Login button
    Then I should land on home page

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |

  @Sanity @Regression
  Scenario Outline: This is a negative login flow
    When I enter an incorrect "<UserName>" and "<Password>"
    And I click on Login button
    Then I should get an error message "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | UserName      | Password |
      | standard_user | Test@123 |
