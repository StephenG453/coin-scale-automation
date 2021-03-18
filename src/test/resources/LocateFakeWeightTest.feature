Feature: test functionality of locating a fake weight inside the React App

  Scenario: happy path verification that the fake weight can be discovered
    Given React Application is loaded and home page is visible
    When coin 0 is added to first cell in the left grid
    When coin 1 is added to second cell in the left grid
    When coin 2 is added to third cell in the left grid
    When coin 3 is added to first cell in the right grid
    When coin 4 is added to second cell in the right grid
    When coin 5 is added to third cell in the right grid
    When weigh button is pressed
    When latest weight result is checked