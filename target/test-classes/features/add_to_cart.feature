Feature: Add to cart functionality 
Scenario: User adds a product to the cart successfully
Given user is on login page
When user enters username "standard_user" and password "secret_sauce"
And user clicks login button
And user adds product to cart
And user navigates to cart page
Then user should see the added product
