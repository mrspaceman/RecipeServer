# Created by andy aspell-clark at 10/11/2021

Feature: the version can be retrieved

  Scenario: client makes call to GET /ingredients
    When the client calls /ingredients
    Then the client receives status code of 200
    And the client receives list of ingredients {"name":"Recipe Server","version": "0.0.1-SNAPSHOT"}

  Scenario: Correct non-zero number of books found by author
    Given I have the following ingredients in the store
      | title                                | author      |
      | The Devil in the White City          | Erik Larson |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
      | In the Garden of Beasts              | Erik Larson |
    When I search for books by author Erik Larson
    Then I find 2 books

  https://www.baeldung.com/cucumber-data-tables