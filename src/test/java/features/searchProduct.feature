Feature: Search and Place the order for Products

@OfferPage
Scenario Outline: Search Experience for product search in both home and offer page

Given User is on GreenCart Landing Page
When User searched with Shortname <Name> and extracted actual name of product
Then User searched for <Name>  shortname in offers page 
And  Validate product name in offer page matches with landing page

Examples:
|Name|
|Tom |
|Beet|