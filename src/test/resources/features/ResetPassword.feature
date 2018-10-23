@ResetPassword
Feature: Reset Password
  As a Registered User of the application
  I want to reset my password via Reset Password functionality
  
	@FailedResetPassword
  Scenario: Password reset token is invalid or has expired
    When I navigate to the "Reset Password" page
    Then I should land on the "Forgot Password" page
    And I should see "error" message as "Password reset token is invalid or has expired."