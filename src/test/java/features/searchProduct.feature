Feature: Search and place the order for products

  Scenario Outline: Search Experience for Product Search in both home and offers page
    Given User is on GreenCart Landing Page
    When user searched with shortname <Name> and Extracted actual name of product
    Then user searched for <Name> shortname in offers page to check if product exist with same name
    And Validate product name in offers page matches with Landing page

    Examples:
    | Name |
    | Tom |
    | Pot |
