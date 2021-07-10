Feature: Techtorial academy page login tests

  @neverFails
  Scenario: Verify if user is logged in as 'Super Admin'
    When  user navigates to demo.openmrs.org
    And user is logging in Registration Desk "admin" and "Admin123"
    Then verify if user is "Super User (admin)"


  @datatable
  Scenario: Log in with cucumber datatable
    When user navigates to open MRS Home page
    And user logs in using following data:
      | departmentName    | username | password |
      | Registration Desk | admin    | Admin123 |
    Then user is logged in as "Super User (admin)"

  @newPatient
  Scenario: Register a patient
    Given user logged in to demo.openmrs.org as "Super User (admin)"
    When user registers a new patent with following information:
      | GivenName | FamilyName | Gender | Birth Day | Birth Month | Birth Year | Address  | City   | State       | Country | PostalCode | PhoneNumber | RelativeName |
      | Richard   | LionHeart  | Male   | 08        | April       | 2000       | Beaumont | Oxford | Oxfordshire | England | 60606      | 11223344    | John         |
  #TODO provide the values here
    Then new patient is registered

  @lafayette
  Scenario: Register a patient left column map
    Given user logged in to demo.openmrs.org as "Super User (admin)" for a new map
    When user registers a new patent with following information: for a new map
      | Given Name    | Gilbert      |
      | Family Name   | Lafayette    |
      | Gender        | Male         |
      | Birth Day     | 08           |
      | Birth Month   | September    |
      | Birth Year    | 1957         |
      | Address       | Chavaniac    |
      | City          | Auvergne     |
      | State         | South France |
      | Country       | France       |
      | Postal Code   | 60606        |
      | Phone Number  | 777444777    |
      | Relative Name | Washington   |
    Then new patient is registered in the new table

  @outline
  Scenario Outline: Register a patient variant 3
    Given user is logged in to demo.openmrs.org as admin
    When user creates a new patient with following base data: "<GivenName>","<FamilyName>","<Gender>"
    And with extra information "<BirthDay>","<BirthMonth>","<BirthYear>"
    And with address: "<Address>","<City>","<State>","<Country>", and "<PostalCode>"
    Then new patient has beed registered with "<GivenName>" and "<FamilyName>"
    And address of new patient is "<Address>","<City>","<State>"

    Examples:
      | GivenName | FamilyName | Gender | BirthDay | BirthMonth | BirthYear | Address   | City     | State        | Country | PostalCode | PhoneNumber | RelativeName |
      | Richard   | LionHeart  | Male   | 08       | April      | 2000      | Beaumont  | Oxford   | Oxfordshire  | England | 60606      | 11223344    | John         |
      | Gilbert   | Lafayette  | Male   | 08       | September  | 2000      | Chavaniac | Auvergne | South France | France  | 60606      | 11223344    | John         |

  @negativeLogIn
  Scenario Outline: negative Log in
    Given user2 logged in to demo.openmrs.org using negative data
    When user is using given data:"<username>","<password>","<location>"
    Then "<error-message>" is shown
    And user is still on login page
    Examples:
      | username   | password | location | error-message                                |
      | adminnn    | Admin123 | Pharmacy | Invalid username/password. Please try again. |
      | admin      |          | Pharmacy | Invalid username/password. Please try again. |
      |            | Admin123 | Pharmacy | Invalid username/password. Please try again. |
      | techtorial | techno   | Pharmacy | Invalid username/password. Please try again. |
      |            |          | Pharmacy | Invalid username/password. Please try again. |
      | a          | 12345    | Pharmacy | Invalid username/password. Please try again. |
      |            | ##@@@    | Pharmacy | Invalid username/password. Please try again. |


