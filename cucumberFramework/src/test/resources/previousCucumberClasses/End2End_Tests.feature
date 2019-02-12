Feature: Automated End2End Tests 
	Description: The purpose of this feature is to test End 2 End Configuration.

Scenario: Customer place an order by purchasing an item from search 
	Given user is on Home page 
	When he search for "dress" 
	And choose to buy the first item 
	And moves to checkout from mini cart 
	And enter personal details on checkout page 
	And Select same delivery address 
	And Select payment method as "check" payment 
	And place the order 
	Then browser close