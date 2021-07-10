Feature: Add to cart button
  Scenario: Failing to add a product in the shopping cart
    When User enters in the prefered product page
    And User click on "Add to cart button"
    Then Product is not being added to the cart section