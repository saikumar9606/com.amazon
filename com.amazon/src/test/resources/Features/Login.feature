Feature: Feature to Test Login Functionality

  Background: Check login functionality
    Given Browser is in open
    And Navigate to login page
    When user enters valid username and password
    And Cick on login button
    Then Navigate to Home page

  Scenario: Searching the mobile phone
    Given home page is opened
    When user search the redmi note 9 pro mobile
    And click on required mobile
    Then add that mobile to cart

  Scenario: place the order from cart
    Given home page is opened and click on cart
    When user click on proceed to pay
    And enter the address
