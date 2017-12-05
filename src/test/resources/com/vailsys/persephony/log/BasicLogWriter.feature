Feature: BasicLogWriter

  Scenario: Output logs with level greater than or equal to the currently set level
    Given a log writer with level DEBUG and a log entry with level INFO
    When the BasicLogWriter write is called
    Then the BasicLogWriter should output the text to stdout

   Scenario: Filter out logs with level below the currently set level
    Given a log writer with level ERROR and a log entry with level DEBUG
    When the BasicLogWriter write is called
    Then the BasicLogWriter should not output the text to stdout