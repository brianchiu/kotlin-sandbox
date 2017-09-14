Feature: Portal Smoke

  Scenario: Login
    * I login with email address "test@liferay.com" and password "test"

  Scenario: Adding pages
    * I add a page with name "Test Page 1"
    * I add a page with name "Test Page 2"
    * I add a page with name "Test Page 3"

  Scenario: Adding an app
    * I add the "Blogs" app

  Scenario: Add a web content article
    * I navigate to "Content" > "Web Content" in the Product Menu
    * I add a Web Content article with title "Web Content Title" and content "Web Content Content" in the admin app
    * I view the Web Content article with title "Web Content Title" and content "Web Content Content" in the admin app