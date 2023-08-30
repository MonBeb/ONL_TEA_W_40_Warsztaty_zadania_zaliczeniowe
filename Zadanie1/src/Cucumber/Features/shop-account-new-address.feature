Feature: Adding an address to the user account

  Scenario Outline: user has an active account
    Given I'm on shop main page
    When I sign in
    And I login using "hnntbubjozeqduwrcw@cazlg.com" and "superhaslo"
    When I go to my addresses
    And I add new address
    And I enter new address alias <alias> address <address> city <city> zip <zip> country <country> phone <phone>
    Then I can see message "Address successfully added!"
    And I remove the address
    And I close the browser
    Examples:
      | alias     | address          | city        | zip      | country          | phone           |
      | "Alias 1" | "Super street 1" | "Liverpool" | "00-123" | "United Kingdom" | "+46 123456789" |
#      | "Alias 2" | "Super street 2" | "London" | "00-456" | "United Kingdom" | "+46 100200300" |



