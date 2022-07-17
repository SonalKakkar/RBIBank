Feature: Login tests
Launch of the application

Background: Home page - https://www.bausparen.at/de/index.html


  Scenario: User is able to launch the application on the browser and main home page is successfully loaded
   GIVEN Browser is installed on machine and user knows URL
   WHEN   user enter the URL https://www.bausparen.at/de/bausparen.html. on Chrome browser
   AND hit enter
   THEN application is successfully launched and main home page is loaded

