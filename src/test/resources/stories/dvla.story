Scenario: Car colour check

Given a config directory with many files
When the user scans the directory for file details using service bean
Then all the file details under that directory are displayed
When the user reads the excel file [fileName] for Car Registration details
And the user is on the dvla webpage
And the user enters car details for row
Then the car details are validated
When user clicks back button
And the user enters car details for row
Then the car details are validated
When user clicks back button
And the user enters car details for row
Then the car details are validated
Examples:
|fileName  	   |
|CarDetails.csv|

