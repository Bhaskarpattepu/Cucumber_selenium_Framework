Feature: Place the order for products
  @PlaceOrder
  Scenario Outline: Search Experience for Product Search in both home and offers page
    Given User is on GreenCart Landing Page
    When user searched with shortname <Name> and Extracted actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      | Name |
      | Pot |
      | Tom |
