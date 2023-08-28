Feature: Settings Page
  As a registered user
  I want to view and update settings information
 
 Scenario: Settings-To check default values for my location check and alter threshold
   When I navigate to the settings page
   Then Default values must be present for  my location check and alter threshold
 
 Scenario: Settings-To make sure updated changes in settings are reflected while user create a travel record 
   When Make changes in maximum stay date
   Then Changes made in maximum stay date must be reflected in travel record
 
 
 
 