Feature: Shopping on user account

  Scenario: user has an active account
    Given I'm on shop main page
    When I sign in
    And I login using "hnntbubjozeqduwrcw@cazlg.com" and "superhaslo"
    And I go to the clothes window
    Then I choose new product
    And I choose the size "M" number of pieces "5" and add products to the basket
    And I go to basket to proceeded to checkout
    When I confirm address, method of delivery and payment and complete the order
    Then I take a screenshot with confirmed message
    And I close the browser


