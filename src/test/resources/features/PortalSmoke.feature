Feature: Portal Smoke

  Scenario: Login
    Given I am logged in as the admin user

  Scenario: Adding pages
    Then I should be able to add pages

  Scenario: Adding an app
    Then I should be able to add apps

  Scenario: Add a web content article
    When I add web content
    Then I should be able to see the web content