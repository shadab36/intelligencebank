Feature: signup Test On Web Application

  @loginValidationTest
  Scenario Outline: Data driving new user sign-up
    Given navigates to intelligencebank.com
    Then he/she provides the username name as "<username>"
    Then he/she provides the password name as "<Password>"
    Then he/she verify login button
    Then he/she click on login button
    Then verify signinError message
    Then he/she Verify "<userNameVal>" for "<userName>" validation message for user name
    Then he/she verify "<PasswordVal>" for "<Password>" validation message for password
    Then then "<SigninErrorMsg>" for "<userName>" for "<Password>" for validation for all invalid credentials

    #Then login with invalid credentials
    Examples: 
      | username           | Password  | userNameVal | PasswordVal | SigninErrorMsg               |
      |                    |           |             |             | Invalid username or password |
      | uday@gmail.com     |           |             |             | Invalid username or password |
      | uday@gmail.com     |Shadab@121 |             |             | Invalid username or password |
      

  @validloginTest
  Scenario Outline: Verify login validlogin
    Given navigates to intelligencebank.com
    Then he/she provides the username name as "<userName>"
    And he/she provides the password name as "<Password>"
    And he/she click on login button
    And he/she click on profile
    And verify Logout button
    And click on Logout button
    
    #Then logout should be successful
    Examples: 
      | userName           | Password  |
      | udaysi99@gmail.com | Uday@9977 |
