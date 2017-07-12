Feature: BasicLogWriter

  Scenario: Create a BasicLogWriter and check that it writes in the correct format
    Given a BasicLogWriter object
    When the BasicLogWriter write is called
    Then the BasicLogWriter should output the correct text to stdout