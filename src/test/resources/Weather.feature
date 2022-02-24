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
      | 1000   | 1      | 400    |

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


    #If user enters wrong format for parameters i.e int  instead of String

  #  When I set query param "q" as "50"
  # Then status code is 400


  # If user enters a city name in a foreign language, then the API should translate the city name to its' native language

  Scenario Outline: Foreign City
    Given the user with ID "ID" for the API
    When I send "GET" HTTP request
    When I set Header param request "Content-Type" as "application/json"
    When I set query param "q" as <city>
    Then status code is <result>

    Examples:
      | city   | result |
      | Roma   | 200    |
      | Kiev   | 200    |
      | Москва | 200    |
      | 鹿児島市   | 200    |


    # If user enters a city name with a space, then the API should handle the city name without throwing an error


  Scenario Outline: City with Multiple Words
    Given the user with ID "ID" for the API
    When I send "GET" HTTP request
    When I set Header param request "Content-Type" as "application/json"
    When I set query param "q" as <city>
    Then status code is <result>

    Examples:
      | city             | result |
      | St. Petersburg   | 200    |
      | New York         | 200    |
      | Stoke Upon Trent | 200    |