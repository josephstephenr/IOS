Feature: My Profile Page
  As a registered user
  I want to view and update my profile information
  So that my profile is up to date

@myprofile
  Scenario: MyProfilePage-View Profile Information
    When I navigate to the Profile section
    Then I should see name, email, and profile picture

@profileInformation
  Scenario: MyProfilePage-Update Profile Information
    When I click on the Edit Profile button ,Update first name , last name and click save button
    Then my profile information should be updated with the new first name and last first name
   
