


Feature:ShoppingTest
Background: User Launch browser
Given User lanches chrome browser 

Scenario: Add to cart validation
Given I add four different products to my wish list
When I view my wishlist table
Then I find total four selected items in my Wishlist
When I search for lowest price product
And I am able to add the lowest price item to my cart
Then I am able o verify the item in my cart
