Feature: Search and place the order for products

  Scenario: Search Experience for Product Search in both home and offers page

    Given User is on GreenCart Landing Page
    When user searched with shortname "Tom" and Extracted actual name of product
    Then user searched for "Tom" shortname in offers page to check if product exist with same name
    And Validate product name in offers page matches with Landing page