Feature: Automate Falabella website

  As a tester
  I want to automate the Falabella website

  Scenario: Validate selected products in the cart
    Given the user is on the Falabella website
    When the user searches through the search bar
    And randomly selects products
    Then they will validate that the products in the cart are the selected ones and the chosen quantities