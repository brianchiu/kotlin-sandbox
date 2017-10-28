Feature: Portal Smoke

  Scenario: User can log in
    When I open a browser to "http://localhost:8080/"
      And I click the "Sign In" link
      And I enter "test@liferay.com" in the "Email Address" field
      And I enter "test" in the "Password" field
      And I click the "Sign In" button
    Then I should see the user avatar with the initials "TT"