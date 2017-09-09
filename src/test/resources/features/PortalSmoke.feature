Feature: Portal Smoke

  Scenario: Basic portal smoke - Login, add 3 pages, add a web content
    When I open a browser to "https://localhost:8080"
    Then I click the "Welcome" link