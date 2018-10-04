@BlogPost
Feature: Add Blog/Post
  As a Looegd in User of the application
  I want to write a Blog/Post successfully
  
  Background: User is logged in and is on Homepage
  	Given I am a logged in user
  	
	@SuccessfulLandOnAddBlogPost
  Scenario: Successful landing on Add a Blog/Post
    When I click on "Add New Post" link on the "Home" page
    Then I should land on the "Add New Post" page
  
  @SuccessfulAddBlogPost
  Scenario Outline: Successful creation of a Blog/Post
    When I click on "Add New Post" link on the "Home" page
    And I fill in "title" with "<title>"
    And I fill in "description" with "<description>"
    And I fill in "body" with "<body>"
    And I click on the "Add Post" button
    Then I should land on the "Home" page
    And I should see "success" message as "Blog Post posted successfully!"
    And I should see the new blog listing on the Homepage
    Examples:
	    | title					|	description										|	body			|
	    |	some title		|	some short description				|	some body	|
	  