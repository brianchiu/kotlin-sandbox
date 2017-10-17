Feature: Portal Smoke

  Scenario: Basic portal smoke - Login, add 3 pages, add a web content
    When I open a browser to "http://test-6-1-2:8080/web/guest"
    Then I click the "Sign In" link