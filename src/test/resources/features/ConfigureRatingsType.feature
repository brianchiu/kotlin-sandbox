Feature: Configure Ratings Type and Rate as Other Types (https://issues.liferay.com/browse/UC-25)

  Scenario: Setup
    * I am logged in as the admin user
    * I add a page
    * I add the "Blogs" app
    * I add a blogs entry

  Scenario: User can configure ratings to "Like"
    When I navigate to Configuration > Site Settings > Social
      And I configure "Blogs" ratings to be "Like"
    When I navigate to the blogs entry
    Then I should see the Like rating elements

  Scenario: User can rate using "Like"
    Given I navigate to the blogs entry
    When I "like" the blogs entry
    Then I should see the "like" button activated
      And I should see the like counter display "+1"