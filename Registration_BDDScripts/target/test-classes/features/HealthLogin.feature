#Author: Jaspal Aujla
Feature: HealthLink login
  I want to verify login functionality and other elements on this page

  Background: 
    Given I am on HealthLink Login page

  Scenario: All required elements should be displayed at Login page
    Then I should see all required elements

  Scenario: Verify login with valid credentials
    When I login with valid Username: "sree@qa.healthlink.net" and Password: "password"
    Then I should see user dashboarh page

  Scenario: Verify Remember me functionality
    When I click on Remember me checkbox
    And I login with valid Username: "sree@qa.healthlink.net" and Password: "password"
    And I logged out
    Then At login page I should see username: "sree@qa.healthlink.net" in enter username textbox

  @ignore
  Scenario Outline: Verify login with invalid credentials
    When I login with invalid Username: "<username>" and Password: "<password>"
    Then I should see error message "<errorMessage>" or "<errorMessage2>" and captcha image

    Examples: 
      | username               | password | errorMessage                                                                  | errorMessage2           |
      |                        |          | The username and/or password you have entered is incorrect. Please try again. | This field is required. |
      | abcde                  | abc123   | The username and/or password you have entered is incorrect. Please try again. | This field is required. |
      | sree@qa.healthlink.net |          | The username and/or password you have entered is incorrect. Please try again. | This field is required. |
      | sree@qa.healthlink.net | abcd123! | The username and/or password you have entered is incorrect. Please try again. | This field is required. |

  Scenario: Verify Contact Us linktext functionality
    When I click on Contact Us linktext
    Then I should see Contect US page in a new browser window

  Scenario: Verify Create account linktext functionality
    When I click on Create account linktext
    Then I should see Registration page

  Scenario: Verify Forgotten password/username linktext functionality
    When I click on Forgotten password/username linktext
    Then I should see forgot password page
