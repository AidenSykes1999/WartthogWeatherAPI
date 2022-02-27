Feature: Weather

      #If user is entering lat and long that are valid (-90 to 90) and (-180 to 180)

  Scenario Outline: Valid Latitude and Longitude
    Given the user with ID "ID" for the API
    And I send HTTP request with <lon> longitude and <lat> latitude
    Then status code is <result>
    Examples:
      | lon | lat | result |
      | 0      | 0      | 200    |
      | 0      | 1      | 200    |
      | 1000   | 1      | 400    |

  # If user enters a city name in a foreign language, then the API should translate the city name to its' native language

  Scenario Outline: Different cities
    Given the user with ID "ID" for the API
    When I set query param "q" as "<city>"
    Then status code is <result>

    Examples:
      | city                     | result |
      | Roma                     | 200    |
      | Kiev                     | 200    |
      | Москва                   | 200    |
      | 鹿児島市                     | 200    |
      |                          | 400    |
      | London                   | 200    |
      | Stoke-on-Trent           | 200    |
      | Neuvéglise-sur-Truyère   | 200    |
      | Голубинка                | 200    |
      | St. Petersburg           | 200    |
      | New York                 | 200    |
      | Seven Sisters            | 200    |
      | Neussargues en Pinatelle | 200    |

    # If user enters a city name with a space, then the API should handle the city name without throwing an error

  Scenario Outline: City with Multiple Words
    Given the user with ID "ID" for the API
    When I set query param "q" as "<city>"
    Then status code is <result>

    Examples:
      | city                     | result |
      | St. Petersburg           | 200    |
      | New York                 | 200    |
      | Seven Sisters            | 200    |
      | Neussargues en Pinatelle | 200    |

  Scenario Outline: Invalid cities
    Given the user with ID "ID" for the API
    When I set query param "q" as "<city>"
    Then status code is <result>
    Then message "city not found" should appear

    Examples:
      | city | result |
      | up   | 404    |

  Scenario: Different temperature in different units
    Given the user with ID "ID" for the API
    When I set query param "q" as "London", "units" as "metric"
    Then status code is 200
    Then take "temperature" in "metric"
    When I set query param "q" as "London", "units" as "imperial"
    Then status code is 200
    Then take "temperature" in "imperial"
    Then temperature in metric and imperial are different

    Scenario: Different feels like in different units
      Given the user with ID "ID" for the API
      When I set query param "q" as "London", "units" as "metric"
      Then take "feelslike" in "metric"
      When I set query param "q" as "London", "units" as "imperial"
      Then take "feelslike" in "imperial"
      Then feels like in metric and imperial are different

  Scenario: Different temperature min in different units
    Given the user with ID "ID" for the API
    When I set query param "q" as "London", "units" as "metric"
    Then take "temperatureMin" in "metric"
    When I set query param "q" as "London", "units" as "imperial"
    Then take "temperatureMin" in "imperial"
    Then temperature min in metric and imperial are different

  Scenario: Different temperature max in different units
    Given the user with ID "ID" for the API
    When I set query param "q" as "London", "units" as "metric"
    Then take "temperatureMax" in "metric"
    When I set query param "q" as "London", "units" as "imperial"
    Then take "temperatureMax" in "imperial"
    Then temperature max in metric and imperial are different

    Scenario Outline: The country where city is needs to be listed
      Given the user with ID "ID" for the API
      When I set query param "q" as "<city>"
      Then status code is 200
      Then country should be "<country>"

      Examples:
      |city|country|
      |Izmir|TR    |
      |London|GB   |



        
        
        
        
        
        
        
        