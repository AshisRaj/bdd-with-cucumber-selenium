@Comment
Feature: Add Comment on a Blog/Post
  As a Looegd in User of the application
  I want to write a comment to a Blog/Post successfully
  
  Background: User sees a blog on Homepage and clicks on it
  	Given I am a logged in user
  	And I see a blog listing on the Homepae
  	
	@SuccessfulAddComment
  Scenario Outline: Successful Add Comment to a Blog/Post
  	When I click on "Blog listing" link on the "Home" page
  	Then I should land on the "Blog Details" page
  	When I fill in "name" with "<name>"
    And I fill in "message" with "<message>"
    And I click on the "Add Comment" button
    Then I should land on the "Home" page
    And I should see "success" message as "Comment added to the Post successfully!"
    And I should see the comment added to the blog
    Examples:
	    | name					|	message			|
	    |	asdf					|	asdf				|