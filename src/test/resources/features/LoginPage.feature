Feature: Login Functionality

  @Sanity1
  Scenario: Verify user able to logged to application by using credentials in excel sheet
    Given user is on login page
    And User logged with username and password
    When user gets the title of the page
    And make appointment


@Sanity2
  Scenario Outline: Verify user able to logged to application by using scenario outline
  Given user is on login page
    And User logged with "<username>" and "<password>"
    When user gets the title of the page
  And validate "<Expected Error msg>"


  Examples:
    | username | password           | Expected Error msg                                               |
    | Sai      | Ragh               | Login failed! Please ensure the username and password are valid. |
    | John Doe | ThisIsNotAPassword |                                                                  |

  @Sanity3
  Scenario: Verify user able to logged to application by using credentials thorugh Datatble with List
    Given user is on login page
    And User logged with username and password by Datatable
      | John Doe | ThisIsNotAPassword |
    When user gets the title of the page
    And make appointment


  @Sanity4
  Scenario: Verify user able to logged to application by using credentials thorugh Datatble with Map
    Given user is on login page
    And User logged with username and password by Datatable with map
      | Username | Password           |
      | John Doe | ThisIsNotAPassword |
    When user gets the title of the page
    And make appointment