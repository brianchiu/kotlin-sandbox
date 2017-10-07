Feature: Rate an asset

  Scenario: Setup
    * I am logged in as the admin user
    * I add a page
    * I add the "Blogs" app
    * I add a blogs entry

  Scenario: Rate asset as good
    Given I navigate to the blogs entry
    When I rate the entry as good
    Then I should see the thumbs up activated
      And I should see the thumbs up count display "1"

  Scenario: Rate asset as bad
    Given I navigate to the blogs entry
    When I rate the entry as bad
    Then I should see the thumbs down activated
      And I should see the thumbs down count display "1"

  Scenario: Good rating persists
    Given I navigate to the blogs entry
      And I rate the entry as good
      And I navigate to the page named "Welcome"
      And I navigate to the page named "Ratings Test Page"
    When I navigate to the blogs entry
    Then I should see the thumbs up activated
      And I should see the thumbs up count display "1"

  Scenario: Bad rating persists
    Given I navigate to the blogs entry
      And I rate the entry as bad
      And I navigate to the page named "Welcome"
      And I navigate to the page named "Ratings Test Page"
    When I navigate to the blogs entry
    Then I should see the thumbs down activated
      And I should see the thumbs down count display "1"