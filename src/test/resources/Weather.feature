Feature: Weather

  Scenario:
    Given the user with ID "863445a5747eda38906e8e845142b45a" for the API
    When I send "GET" HTTP request
    When I set Header param request "Content-Type" as "application/json"
    When I set query param "q" as "London"
    Then status code is "200"

    Scenario:
      Given the user with ID "863445a5747eda38906e8e845142b45a" for the API
      When I send "GET" HTTP request
      When I set Header param request "Content-Type" as "application/json"
      When I set query param "q" as ""
      Then status code is "400"
