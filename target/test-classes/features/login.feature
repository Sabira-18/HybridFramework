Feature: Login Functionality 
Scenario Outline: Login with multiple credentials
Given user is on login page
When user enters username "<username>" and password "<password>"
And user clicks login button
Then user should see "<result>"

Examples:
|username     |  |password    |  |result |
|standard_user|  |secret_sauce|  |success|
|locked_out_user| |secret_sauce| |error|



