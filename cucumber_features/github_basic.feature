Feature: ApiDocs basic test
#comment is here - feature description for search testing

#recurrent actions/preconditions go below - in "Background" section
#this section is optional. 
#Uncomment it and delete/comment duplicating step from Scenario description
#Background:
Given user navigates to ApiDocs main page

@smokeTest
Scenario: ApiDocs login
Given user navigates to ApiDocs home page
When  enter Username as "<username>" and Password as "<password>"
Then  ApiDocs main page is displayed

Examples: Different users
| username | password|
| edsdeveloper6@tr.com | Secret12 |
| edsdeveloper7@tr.com| Secret12 |
| edsdeveloper9@tr.com| Secret12 |

