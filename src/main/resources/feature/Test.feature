Feature: Verify Banggood Easy Online Shopping app

  Scenario: Verify product name and COD icon
    Given Open Banggood Easy Online Shopping app
    When Click to the Category on footer menu
    And Scroll and click to Home and Garden in Left menu
    And After the right category dsplayed , click to the Home Decor
    And Click to the Filter and select COD
    And Click Done
    And Click first product
    Then Verify Product name should be displayed
    And Verify COD icon should be displayed

  Scenario: Verify detail product and cart
    Given Open Banggood Easy Online Shopping app
    When At the Home Screen  , scroll to Hot Categories
    And  Click to the SmartPhone category
    And Click to the  "Ulefone Armor 26 Ultra 5G 200MP Quad Camera 64MP" " product
    And The Product detail page should be display : Product name , product price , Buy now and Add to cart button
    And Scroll to Shipping and Change Shipping Address to Alabama, United States and click continue
    And Click Add to cart
    And Click Add to cart button
    And Click con Cart icon on top
    Then Verify product name , product size , product price and quatity should be displayed

  Scenario: Verify login screen
    Given Open Banggood Easy Online Shopping app
    When Click Account on footer menu
    And Click View All Order
    Then Verify login screen should be displayed with : Email , password and sing-in button

