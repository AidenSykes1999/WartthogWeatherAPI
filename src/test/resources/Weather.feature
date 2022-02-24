Feature: Weather

  Scenario: Valid City
    Given the user with ID "ID" for the API
    When I send "GET" HTTP request
    When I set Header param request "Content-Type" as "application/json"
    When I set query param "q" as "London"
    Then status code is 200

    Scenario:
      Given the user with ID "ID" for the API
      When I send "GET" HTTP request
      When I set Header param request "Content-Type" as "application/json"
      When I set query param "q" as ""
      Then status code is 400


      #If user is entering lat and long that are valid (-90 to 90) and (-180 to 180)

  Scenario Outline:
    Given the user with ID "ID" for the API
    And I send <input1> longitude and <input2> latitude
    When I set Header param request "Content-Type" as "application/json"
    Then status code is <result>
    Examples:
      | input1 | input2 | result |
      | 1      | 1      | 200    |
      | 0      | 1      | 200    |
      | 1000   | 1      | 406    |

      #If user is entering lang that is not supported by the API


  Scenario:

    Given the user with ID "ID" for the API
    When I send "GET" HTTP request
    When I set Header param request "Content-Type" as "application/json"
    When I set query param "lang" as "en"
    Then status code is 200

  Scenario:

    Given the user with ID "ID" for the API
    When I send "GET" HTTP request
    When I set Header param request "Content-Type" as "application/json"
    When I set query param "lang" as "spain"
    Then status code is 400
