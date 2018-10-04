@Profile
Feature: View/Edit Profile
  As a Registered User of the application
  I want to view and update my profile
  
  Background: User is logged in and is on Homepage
  	Given I am a logged in user
  	And I navigate to the "Homepage" page

	@ViewProfile
  Scenario: Successful View Profile
    When I click on "My Profile" link on the "Home" page
    Then I should land on the "My Profile" page
    And I should see "Your Profile" heading on the Profile page
    And "My Profile" link should be active on the Profile page
    And "User Name" field should be prepopulated and set as "readonly" on the Profile page
    And "email" field should be prepopulated on the Profile page
    
	@EdiProfile
  Scenario Outline: Successful Edit Profile
	  When I click on "My Profile" link on the "Home" page
	  And I fill in First Name as "<firstname>"
	  And I fill in Last Name as "<lastname>"
	  And I fill in Age as "<age>"
	  And I fill in Gender as "<gender>"
	  And I fill in Address as "<address>"
	  And I fill in Website as "<website>"
	  And I click on the "Update Profile" button
	  Then I should land on the "Home" page
	  And I should see "success" message as "Profile updated successfully!"
    Examples:
      | firstname    | lastname   | age	|	gender	|	address	|	website							|
      | ashis        | raj			 	| 25	| Male		|	E-605		|	https://example.com	|    
    
    