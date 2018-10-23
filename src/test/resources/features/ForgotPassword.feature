@ForgotPassword
Feature: Forgot Password
  As a Registered User of the application
  I want to reset/regenerate my password via Forgot Password functionality
  
  Background: A Registered User navigates to Login page
  	Given I am a registered user
  	And I navigate to the "Login" page
  	And I navigate to the "Forgot Password" page

	@SuccessfulForgotPassword
  Scenario Outline: Successful submit of forgot password form with valid email
    When I fill in "email" with "<email>"
    And I click on the "Submit" button
    Then I should land on the "Forgot Password" page
    Examples:
	    | email							|
	    |	asdf@example.com	|

	@failedForgotPassword
  Scenario Outline: Failed submit of forgot password form with invalid email
 		When I fill in "email" with "<email>"
    And I click on the "Submit" button
    Then I should land on the "Forgot Password" page
    And I should see "error" message as "<alert>"
    Examples:
	    | email											| alert                               	 		|
	    |	asdf.invalid@example.com	| No account with that email address exists.|