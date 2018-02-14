Feature: ApiDocs basic test

#Background:
Given user navigates to ApiDocs main page

@smokeTest
Scenario: ApiDocs login
Given user navigates to ApiDocs main page
When  enter Username as "<username>" and Password as "<password>"
Then  ApiDocs main page is displayed

Examples: Different users
| username | password|
| edsdeveloper6@tr.com | Secret12 |
| edsdeveloper7@tr.com| Secret12 |
| edsdeveloper9@tr.com| Secret12 |

