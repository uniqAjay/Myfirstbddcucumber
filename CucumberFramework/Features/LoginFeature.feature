  Feature: login
  		
  Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com"
	And Users enters password as "admin"
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
  #When User click on Log out link 
  #Then Page Title should be "Your store. Login" 
  #And close browser 
  		
  		
  	  
  
  
  
#Scenario Outline: Successful Login with valid creadentials DDT
  #		Given user launch chrome browser 
  #		When User opens URL "https://www.saucedemo.com/"
  #		And User enters email adress as "<email>"
  #		And Users enters password as "<password>"
  #		And click on login 
  #		
  #		
  #	
  #		
  #		
 #Examples:
 #|email|password|
 #|standarduser|someone|
 #
 

