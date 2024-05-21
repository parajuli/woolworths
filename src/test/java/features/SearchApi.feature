Feature: Search API Test

  Scenario: Verify search count response with valid search term
    Given I perform a GET request to the search endpoint with searchTerm "deli"
    Then the response status code should be 200
    And the response should have ArticleCount and Total greater than 0

  Scenario: Verify search count response with empty search term
    Given I perform a GET request to the search endpoint with searchTerm ""
    Then the response status code should be 400

  Scenario: Verify search count response with special characters in search term
    Given I perform a GET request to the search endpoint with searchTerm "!@#$%"
    Then the response status code should be 200
    And the response should have ArticleCount and Total