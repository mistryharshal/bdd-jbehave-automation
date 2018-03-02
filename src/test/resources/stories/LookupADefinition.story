Scenario: Looking up the homepage and other pages in website

Given the user opens home URL
When the home page is loaded
Then assert that Latest News section is displayed
When user navigates to page [aboutUrl]
Then assert that page title [aboutTitle] is displayed
When user navigates to page [serviceUrl]
Then assert that page title [serviceTitle] is displayed
When user navigates to page [workUrl]
Then assert that page title [workTitle] is displayed

Examples:
|aboutUrl|aboutTitle|serviceUrl|serviceTitle|workUrl|workTitle|
|aboutUrl|aboutTitle|serviceUrl|serviceTitle|workUrl|workTitle|