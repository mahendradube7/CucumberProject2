Feature: Place the Order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offer page

Given User is on GreenCart Landing Page
When User searched with Shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And verify User has ability to enter the promo code and place the order

Examples:
|Name|
|Tom |
