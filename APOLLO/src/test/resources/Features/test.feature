Feature: Login Functionality

	Background:  Login Functionality with valid mobile number
		Given User is on Apollo App login page
		When User enters valid mobil number and otp
		And User clicks on the login button
		Then User is in Consult page

  Scenario: check logout link
    Given User select the All Cities from Most Searched Cities
    When  select the City from All Cities dropdown
    Then User can see list of doctors

	Scenario Outline: Choosing the Filters 30 
			Given User is on Consult Page
			When User clicks on Filters
			And Enter <Availability> and <Fees> and <Gender> and <Language>
			Then Filters applied to the Consult page

	Examples:
	
	|Availability 				|Fees				|Gender 	|Language 		|
	|"Next 3 Days"				|"100-500" 	|"Female" |"Telugu"			|
	
	
	Scenario: Choosing the Doctor

 		Given User is on Consult page

		When User click on Book Hospital Visit

 		Then User will Navigate to the Date and Time page
	
	Scenario: Search invalid data

		 Given user is on consult page
		
		 When User enters invalid data
				
		 Then Doctors not found
		 
	Scenario: Selecting Date and Time

				Given User is on Consultpage
				When User enters Date and Time
				And click on procced button and user is on Add New Member page				
				And enter <FullName> and <LastName> and <DateofBirth> and <Gender>
				And click on drop down and select relation
				And enter Gamail and click on save button
				Then User is navigate to payment page
				
		Examples:			
				|FullName		|LastName		|DateofBirth		|Gender		|
				|"Sirisha"	|"K"				|"14/12/1999"		|"Female"	|

	
	
	
	
	
	
	
	
	