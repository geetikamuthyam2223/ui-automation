
@tag
Feature: Hotel booking flow

  @tag1
  Scenario: When I select city and other details, I should navigate to Hotels list page
    Given I am on AirCanada home page as a Guest
    And user click on hotels tab
    When user select the <sun destination city> of destination
    And user selects <start date> and <end date>
    And user selects <no. of passengers>
    And user clicks on search button
    Then user navigates to the hotels list page
    | sun destination city  | start date | end date  | no. of passengers |
    | cancun |     25 Nov | 28 Nov | 2 |

