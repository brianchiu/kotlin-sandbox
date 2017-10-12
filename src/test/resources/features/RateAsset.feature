Feature: Rate an asset (https://issues.liferay.com/browse/UC-12)

  Scenario: Setup
    * I am logged in as the admin user
    * I add a page
    * I add the "Blogs" app
    * I add a blogs entry

  Scenario: When viewing a new asset for the first time, the rating icons should be unclicked and the rating counts should be 0
    Given I navigate to the blogs entry
    Then I should see the thumbs up not clicked
      And I should see the thumbs up count display "0"
      And I should see the thumbs down not clicked
      And I should see the thumbs down count display "0"

  Scenario: When viewing an asset, a user should be able to rate the asset as good
    Given I navigate to the blogs entry
    When I rate the entry as good
    Then I should see the thumbs up clicked
      And I should see the thumbs up count display "1"

  Scenario: A good rating should persist when a user navigates away from the asset
    Given I navigate to the blogs entry
    Then I should see the thumbs up clicked
      And I should see the thumbs up count display "1"

  Scenario: A user cannot rate an asset as good twice, so clicking the rate as good button again unrates the asset
    Given I navigate to the blogs entry
    When I unrate the entry as good
    Then I should see the thumbs up not clicked
      And I should see the thumbs up count display "0"

  Scenario: When viewing an asset, a user should be able to rate the asset as bad
    Given I navigate to the blogs entry
    When I rate the entry as bad
    Then I should see the thumbs down clicked
      And I should see the thumbs down count display "1"

  Scenario: A bad rating should persist when a user navigates away from the asset
    Given I navigate to the blogs entry
    Then I should see the thumbs down clicked
      And I should see the thumbs down count display "1"

  Scenario: A user cannot rate an asset as bad twice, so clicking the rate as bad button again unrates the asset
    Given I navigate to the blogs entry
    When I unrate the entry as bad
    Then I should see the thumbs down not clicked
      And I should see the thumbs down count display "0"

  Scenario: Setup
    * I navigate to the blogs entry
    * I rate the entry as bad

  Scenario: A user cannot rate an asset as both good and bad, so rating as a good an asset previously rated as bad removes the rate as bad
    Given I navigate to the blogs entry
      And I should see the thumbs down clicked
    When I rate the entry as good
    Then I should see the thumbs up clicked
      And I should see the thumbs up count display "1"
      And I should see the thumbs down not clicked
      And I should see the thumbs down count display "0"

  Scenario: A user cannot rate an asset as both good and bad, so rating as a bad an asset previously rated as good removes the rate as good
    Given I navigate to the blogs entry
      And I should see the thumbs up clicked
    When I rate the entry as bad
    Then I should see the thumbs down clicked
      And I should see the thumbs down count display "1"
      And I should see the thumbs up not clicked
      And I should see the thumbs up count display "0"