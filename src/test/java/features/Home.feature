Feature: Home Feature Scenario

  Background: 
    Given I have launched the application

  @Sanity @Regression
  Scenario Outline: Add product to the cart
    And I enter a correct "<UserName>" and "<Password>"
    And I click on Login button
    When I select the "<Product>" and click on the Add to cart button
    Then I should see the cart number increased by 1

    Examples: 
      | UserName      | Password     | Product               |
      | standard_user | secret_sauce | Sauce Labs Bike Light |
