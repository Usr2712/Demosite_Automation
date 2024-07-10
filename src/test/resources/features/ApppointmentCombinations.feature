Feature: Appointment Combinations


@Appointment1
  Scenario Outline: NewNew
    Given user is on login page
    And User logged with username and password
    And make appointment "Tokyo CURA Healthcare Center"
  And Select "<healthcareprogram>"
  And Select apppointmentdate "<Month>" and "<Date>" and "<Year>"
  And Book Appointment
Examples:
  | healthcareprogram | Month    | Date | Year |  |
  | Medicare          | November | 12   | 2024 |  |


  @Appointment2
  Scenario Outline: NewNewNew
    Given user is on login page
    And User logged with username and password from db
    And make appointment "Tokyo CURA Healthcare Center"
    And Select "<healthcareprogram>"
    And Select apppointmentdate "<Month>" and "<Date>" and "<Year>"
    And Enter Comments "Book Appoinments"
    And Book Appointment
    And verify Comment in history is matching with comment provided
    Examples:
      | healthcareprogram | Month    | Date | Year |  |
      | Medicare          | November | 12   | 2024 |  |



