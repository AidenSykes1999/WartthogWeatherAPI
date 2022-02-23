Feature: Weather

  Scenario:
    Given the user with ID "ID" for the API
    When I send "GET" HTTP request
    When I set Header param request "Content-Type" as "application/json"
    When I set query param "q" as "London"
    Then status code is "200"

    Scenario:
      Given the user with ID "ID" for the API
      When I send "GET" HTTP request
      When I set Header param request "Content-Type" as "application/json"
      When I set query param "q" as ""
      Then status code is "400"


      #If user is entering lat and long that are valid (-90 to 90) and (-180 to 180)

    Scenario:
      Given the user with ID "ID" for the API
      And I send {int} longitude and {int} latitude
      When I set Header param request "Content-Type" as "application/json"
      When I set query param "q" as ""
      Then status code is "406"


