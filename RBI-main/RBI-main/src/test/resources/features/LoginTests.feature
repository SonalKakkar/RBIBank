Feature: Login tests
  As a user, I should be able to login to the application

Background: Home page - https://www.bausparen.at/de/index.html


  Scenario: User should log in by filling details like Bank name, signatory number and pin number to access some information
    GIVEN user is on main page
    WHEN user clicks on search box
    AND enters a keyword "Online home saving in my ELBA"
    AND hit enter
    THEN login form opens up in other window
    AND user fills all details like bank name, signatory number, PIN number



    When Input credentials to login with headers table
    | bank name   | signatory number | PIN number  |
    | Salzburg    | ELOOE03V         | 1234 |
    And Click continue button
