Feature: Configure Ratings (https://issues.liferay.com/browse/UC-24)

  Scenario: Setup
    * I am logged in as the admin user
    * I add a page
    * I add the "Blogs" app
    * I add a blogs entry

  Scenario: User cannot rate if ratings are disabled
    When I disable "Enable Ratings" in app configuration
    Then I should not see the ratings elements

  Scenario: User can rate if ratings are re-enabled
    When I enable "Enable Ratings" in app configuration
    Then I should see the ratings elements
