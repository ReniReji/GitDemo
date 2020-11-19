Feature: Login into the application

  Scenario Outline: Postive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://www.qaclickacademy.com" site
    And click on Login link in home page to land on Secure Sign In Page
    When User enters '<username>' and '<password>' and log in
    Then Verify that user is successfully logged in

    Examples: 
      | username          | password |
      | test12@gmail.com  |    12345 |
      | test345@gmail.com |    78945 |
