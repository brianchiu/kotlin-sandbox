Feature: WebDriverTester

#Scenario: OpenURL
#	When I open a browser to "https://www.google.com"
#	Then I close the browser
#
Scenario: Login
	When I open a browser to "http://localhost:8080"
	And I click the "Sign In" link
	And I enter "test@liferay.com" in the "Email Address" field
	And I enter "test" in the "Password" field
	And I click the "Sign In" button
    And I can see the user avatar image
    Then I close the browser

Scenario: Login with one step
	When I login with email "test@liferay.com" and password "test"
	And I add a page named "Test Page"
	And I navigate to "Content" > "Web Content" in the Product Menu
	Then I add a web content with title "Web Content Title" in the Admin Portlet