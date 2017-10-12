Feature: Rate an asset (https://issues.liferay.com/browse/UC-12)

  Scenario: Setup
    * I am logged in as the admin user
    * I add a page
    * I add the "Blogs" app
    * I add a blogs entry

  Scenario: Clean asset state has counts at 0 and rating icons not clicked
    Given I navigate to the blogs entry
    Then I should see the thumbs up not clicked
      And I should see the thumbs up count display "0"
      And I should see the thumbs down not clicked
      And I should see the thumbs down count display "0"

  Scenario: Rate asset as good
    Given I navigate to the blogs entry
    When I rate the entry as good
    Then I should see the thumbs up clicked
      And I should see the thumbs up count display "1"

  Scenario: Good rating persists
    Given I navigate to the blogs entry
    Then I should see the thumbs up clicked
      And I should see the thumbs up count display "1"

  Scenario: Can click again to unrate as good
    Given I navigate to the blogs entry
    When I unrate the entry as good
    Then I should see the thumbs up not clicked
      And I should see the thumbs up count display "0"

  Scenario: Rate asset as bad
    Given I navigate to the blogs entry
    When I rate the entry as bad
    Then I should see the thumbs down clicked
      And I should see the thumbs down count display "1"

  Scenario: Bad rating persists
    Given I navigate to the blogs entry
    Then I should see the thumbs down clicked
      And I should see the thumbs down count display "1"

  Scenario: Can click again to unrate as bad
    Given I navigate to the blogs entry
    When I unrate the entry as bad
    Then I should see the thumbs down not clicked
      And I should see the thumbs down count display "0"

  Scenario: Setup
    * I navigate to the blogs entry
    * I rate the entry as bad

  Scenario: Rate as bad cancels out when user rates as good
    Given I navigate to the blogs entry
      And I should see the thumbs down clicked
    When I rate the entry as good
    Then I should see the thumbs up clicked
      And I should see the thumbs up count display "1"
      And I should see the thumbs down not clicked
      And I should see the thumbs down count display "0"

  Scenario: Rate as good cancels out when user rates as bad
    Given I navigate to the blogs entry
      And I should see the thumbs up clicked
    When I rate the entry as bad
    Then I should see the thumbs down clicked
      And I should see the thumbs down count display "1"
      And I should see the thumbs up not clicked
      And I should see the thumbs up count display "0"