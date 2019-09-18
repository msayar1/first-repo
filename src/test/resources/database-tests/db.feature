
@db-test
Feature: Let's do db testing
  

   Scenario: Get PG-13 films
    Given I want to get the number of films which are PG13
    And Retrieve the film called "Babam ve Oglum"
    Then I want to create and delete actor whose name is Roberto
   

 