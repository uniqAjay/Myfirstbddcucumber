
Feature: Add new Customer

Background: 
Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com"
	And Users enters password as "admin"
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
  Then Page Title should be "Your store. Login" 

#@Sanity @Regression
Scenario: Successfully add customer 
	When User click on Customer menu
  And Click on customers menu
  And Click on customers menu item
  And Click on add new button 
  Then User can view add customer page
  When User enters info for new customer
  And Click on save button
  Then User can view confirmation message "The new customer has been added successfully."
  And close browser 
 
 #@Regression
 Scenario: Search Customer By Email
   When User click on Customer menu
   And Click on customers menu
   And Click on customers menu item
   And Enter customer email
   When User click on search button
   And user should found result in the search table
   And Close browser
   
   
 
  		