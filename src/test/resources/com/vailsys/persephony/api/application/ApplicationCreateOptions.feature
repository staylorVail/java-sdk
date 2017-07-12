Feature: ApplicationCreateOptions

  Scenario: The ApplicationCreateOptions constructor should ensure all the fields are null
    Given an empty ApplicationCreateOptions object
    Then check that all ApplicationCreateOptions fields are null

  Scenario: The ApplicationCreateOptions getters and setters should work
    Given an empty ApplicationCreateOptions object
    Then set alias to appAlias in ApplicationCreateOptions
    Then check that alias is appAlias in ApplicationCreateOptions
    Then set voiceUrl to http://voice.url in ApplicationCreateOptions
    Then check that voiceUrl is http://voice.url in ApplicationCreateOptions
    Then set voiceFallbackUrl to http://voicefallback.url in ApplicationCreateOptions
    Then check that voiceFallbackUrl is http://voicefallback.url in ApplicationCreateOptions
    Then set callConnectUrl to http://callconnect.url in ApplicationCreateOptions
    Then check that callConnectUrl is http://callconnect.url in ApplicationCreateOptions
    Then set statusCallbackUrl to http://statuscallback.url in ApplicationCreateOptions
    Then check that statusCallbackUrl is http://statuscallback.url in ApplicationCreateOptions