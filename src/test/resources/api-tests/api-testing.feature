Feature: API CRUD
  I want to do api testing using RestAssured

  @ApiTesting
  Scenario: CRUD
    Given I want to go to base URI
    And create an actor
    Then get the actor and delete the same actor
    Then retrieve all actors and print them
