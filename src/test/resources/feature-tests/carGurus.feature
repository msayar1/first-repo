Feature: Car Guru's Top Menu Bar
  I want to verify all the menus in top menu bar exist

  @CarGuruTopMenuBar
  Scenario: All Menu items from top Menu Bar
    Given I am on CarGuru's Home Page
    Then I now get all menus from top
    And I verify all the menus are exist

 