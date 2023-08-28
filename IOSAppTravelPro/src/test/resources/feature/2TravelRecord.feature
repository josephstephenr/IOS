Feature: Travel Record Creation
  As a traveler
  I want to create a travel record
  So that I can keep track of my travel details

@withoutStartAndEndDate
Scenario: TravelRecordCreation-Create a new travel record without start date and end date
    When I create a new travel record
    Then the error should appear
@DefaultValues 
Scenario: TravelRecordCreation-In Create a new travel definition of day and alter Threshold Days
    Then Definition of day and alter Threshold Days must be present by default
@SameCountryInFromAndTo  
 Scenario: TravelRecordCreation-Create a new travel record for same country in from and to country
    When I create a new travel record enter same country in from and to country
    Then the error message shown
    
 Scenario: TravelRecordCreation-To create a travel record with valid information
   When Full all the required field to create a record 
   Then Created travel record should be listed in travel list
   
   
   
   
   
   
    