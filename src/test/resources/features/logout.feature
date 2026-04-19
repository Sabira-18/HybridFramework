Feature: Logout Functionality 
Scenario: User logs out successfully
Given user is on login page
When user enters username "standard_user" and password "secret_sauce"
And user clicks login button
And user clicks menu button
And user clicks logout button
Then user should be navigated to login page


