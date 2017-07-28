Feature: Portal Smoke

Background:
    Given I open a browser to "http://localhost:8080"

Scenario: Login
	When I click the "Sign In" link
	And I enter "test@liferay.com" in the "Email Address" field
	And I enter "test" in the "Password" field
	And I click the "Sign In" button
    Then I can see the user avatar image

Scenario: Add a web content
	And I add a page named "Test Page"
	And I navigate to "Content" > "Web Content" in the Product Menu
	Then I add a web content with title "Web Content Title" in the Admin Portlet