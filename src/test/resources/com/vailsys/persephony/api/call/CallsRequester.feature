@Mockserver
Feature: CallsRequester

	Scenario: Can create a CallsRequester
		Given a CallsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then check the acting accountId is AC1234567890123456789012345678901234567890
		Then check the path is /Accounts/AC1234567890123456789012345678901234567890/Calls
		
	Scenario: Place a new call using an applicationID
		Given a CallsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then place a call from +13125551234 to +17735556789 using application AP1234567890123456789012345678901234567890
		Then place a call from +13125551234 to +17735556789 using application AP1234567890123456789012345678901234567890 with options

	Scenario: Place a new call using a callConnectUrl
		Given a CallsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then place a call from +13125551234 to +17735556789 using callConnectUrl
		Then place a call from +13125551234 to +17735556789 using callConnectUrl with options
		Then place a call from +13125551234 to +17735556789 using callConnectUrl and statusCallbackUrl
		Then place a call from +13125551234 to +17735556789 using callConnectUrl and statusCallbackUrl with options

	Scenario: Getting a list of calls
		Given a CallsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then get a list of calls
		Then get a list of calls with filters

	Scenario: Getting a single call by callId
		Given a CallsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then get a call by it's callId

	Scenario: Complete a call
		Given a CallsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then update a call with id CA1234567890123456789012345678901234567890 to status completed
