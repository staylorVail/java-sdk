Feature: Logger

  Scenario: Test the Logger object
    When the Logger logs an entry it should call the writer's write method with the entry
    When the logger logs with all the components of an entry it should call the writer's write method with an entry matching the arguments
    When the logger writes a debug log the level should be debug
    When the logger writes an info log the level should be info
    When the logger writes a warning log the level should be warn
    When the logger writes an error log the level should be error