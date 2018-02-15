Feature: ApiDocs basic test

#Background:
Given user navigates to ApiDocs main page

@smokeTest
Scenario Outline: user login into ApiDocs
Given ApiDocs main page is opened
When  user login into system as <type>
Then  ApiDocs main page is displayed

Examples: Types of users
| type |
| admin |
| superadmin|


