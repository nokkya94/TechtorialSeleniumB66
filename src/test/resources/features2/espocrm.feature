Feature: testing demo.eposcrm.com

  @acceptance_criteria1
  Scenario: Validate the functionality names from demo.espocrm
    Given user navigate to "https://demo.espocrm.com/"
    When user logs in demo.espocrm
    Then user should see the function names
      | Home          |
      | Accounts      |
      | Contacts      |
      | Leads         |
      | Opportunities |
      | Reports       |
      | Quotes        |
      | Sales Orders  |
      | Invoices      |
      | Products      |
      | Emails        |
      | Cases         |
      | Calendar      |
      | Tasks         |

  @acceptance_criteria2
  Scenario Outline: creatining accounts in demo.espocrm
    Given user navigates to "https://demo.espocrm.com/" for creating an account
    When user opens the Accounts
    Then user clicks the Create Account button
    And the user creates 4 new accounts with following data:"<Name>","<Web site>","<Email>","<Phone>"
    And with billing Address: "<Street>","<City>","<State>","<Postal Code>","<Country>"
    And with Shipping Address: "<Street>","<City>","<State>","<Postal Code>","<Country>"
    And with Details "<Type>" and "<Industry>" writing this "<Description>"
    And with "<Assigned User>" and "<Teams>"
    And the user validate the new users are created
    Examples:
      | Name           | Web site   | Email          | Phone     | Street          | City       | State | Postal Code | Country | Street          | City       | State | Postal Code | Country | Type     | Industry  | Description | Assigned User | Teams            |
      | John3 Depp     | www.jd.com | jd91@yahoo.com | 111222333 | NCumberland.Ave | Chicago    | IL    | 60606       | USA     | NCumberland.Ave | Chicago    | IL    | 60606       | USA     | Partner  | Aerospace | Good Guy    | Admin         | Sales Department |
      | Vincent1 Venn  | www.vv.com | vv@yahoo.com   | 222333444 | STonneDr        | Schaumburg | IL    | 67606       | USA     | STonneDr        | Schaumburg | IL    | 67606       | USA     | Investor | Banking   | Rich        | Admin         | Sales Department |
      | Michael1 Moore | www.mm.com | mm@yahoo.com   | 333444555 | W California Rd | Seattle    | WA    | 67777       | USA     | W California Rd | Seattle    | WA    | 67777       | WA      | Reseller | Banking   | Nice        | Admin         | Support          |
      | Victor1 Hugo   | www.vh.com | vh@yahoo.com   | 444555666 | N Ponderosa St  | Boston     | MA    | 70707       | USA     | N Ponderosa St  | Boston     | MA    | 70707       | MA      | Reseller | Aerospace | Good        | Admin         | Support          |

  @acceptance_criteria3
  Scenario: Validate all users
    Given user navigates to "https://demo.espocrm.com/?lang=en_US#" to validate users
    When user click the three dots at the end of functionality names
    Then user clicks the Users
    Then user should see given table of Name and Email columns
      | Admin           | espocrm.demo@gmail.com              |
      | Ben Parter      | ben.parter@example.com.ko           |
      | Bill Chan       | bill_chan@example-demo.so           |
      | Brendon Lewis   | brendon.lewis@re-example.org        |
      | Emma Bard       | emma_bard@rio.demo.su               |
      | Gabliel Brie    | gabrielbrie@exmpl.org.pi            |
      | Jake Forester   | jake_forester@example-espo.demo.com |
      | Jim Williams    | jim-williams@example.com.ca         |
      | Rebecca Maer    | rebecca.maer@demoexmpl.org          |
      | Richard Pan     | richard_pan@read.exmpl-dd.com       |
      | Thomas Peterson | thomas.peterson@demo-user.exmpl.com |
