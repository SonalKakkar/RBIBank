Feature: Search Functionality
  As a user I want to search for something
   from search box
   And get relevant details

  Background: Home page - https://www.bausparen.at/de/index.html

  @ScenarioOutline
  Scenario Outline: User is able to search on search box with valid keyword from home page
    GIVEN User is on website https://www.bausparen.at/de/bausparen.html.
    WHEN user Search product with {"Home office"} keyword
    AND clicks on Enter
    THEN relevant results regarding searched keyword are displayed

    Then Search product link with "<Home office>" data is displayed
    Examples:
      | Home office: Health aspects   |
