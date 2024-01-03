Feature: Jdoodle Application Test Feature

  Background: 
    And Validate the title "Online Java Compiler - Online Java Editor - Java Code Online" in Jdoodle Application Page

  Scenario: Validate Login & Execute Button is Displayed in DashBoard Page
    Then Verify Login Button is Displayed once Jdoodle Application is Opened
    Then Validate "Execute" Button is Displayed in Jdoodle Application

  Scenario: Validate all the Fields Email, UserName, PassWord & Confirm Password Displayed Or Not
    Then Click on Login Button in Jdoodle Application
    Then Click on Sign up Button in Sign up Jdoodle Application Page
    Then Verify "Email" field is Displayed as "email" in Signup Jdoodle Application
    Then Verify "Display Name" field is Displayed as "username" in Signup Jdoodle Application
    Then Verify "Password" field is Displayed as "password" in Signup Jdoodle Application
    Then Verify "Confirm Password" field is Displayed as "password" in Signup Jdoodle Application
    Then Verify "SearchBar" field is Displayed as "searchBar" in Signup Jdoodle Application

  Scenario: Verify Default Java Complier is Displayed in Jdoodle Application
    Then Verify Default Header "Online Java Compiler IDE" in Jdoodle Application
