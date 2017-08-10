## Introduction
The Persephony Java SDK will allow you to easily use the Persephony API in a Java application.

## SDK Installation
Install the SDK by downloading a release or building it from source.

### Download
Download the latest SDK `jar` from the [Releases](https://github.com/PersephonyAPI/java-sdk/releases/latest) page.

### Build
- Clone this repo, install [gradle](https://gradle.org/), then run `gradle build`. The `jar` will be created in the `build` directory. 
- Add the file as a dependency of your project, depending on the IDE and build system in use.

## Testing your Installation

Test the SDK is working by sending yourself a phone call.

```java
import com.vailsys.persephony.api.PersyClient;
import com.vailsys.persephony.api.PersyException;

public class Example {

    public static final String accountId = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String authToken = "your_auth_token";
    public static final String To = "your_phone_number";
    public static final String From = "a_persephony_phone_number_in_your_account";

    public static void main(String[] args) throws PersyException {
        PersyClient client = new PersyClient(accountId, authToken);

        client.calls.create(To, From, "https://www.persephony.com/testApp/voice", (String)null);
    }
}
```

When you run this code you should get a phone call. On answering the call, you should hear a short message ("Thanks for using Persephony!"). This indicates that you've successfully setup your SDK.

`https://persephony.com/testApp/voice` contains a small Persephony application that also uses the Persephony Java SDK. When a request is made to its `/voice` endpoint, it will respond with the following PerCL script, which produces the message you heard.

```json
[{"Say": {"text": "Thanks for using Persephony!"}}]
```

## Documentation

The [Persephony documentation](/docs) has guides on [getting started](/docs/getting-started/) with Persephony, as well as the [API reference](/docs/api/), [PerCL reference](/docs/percl/), and several useful [tutorials.](/docs/tutorials/).

## Getting Help

If you are experiencing difficulties, contact our support team at [support@persephony.com](mailto:support@persephony.com).

## Dependencies
This SDK targets Java 7.

Import these dependencies:
  
- com.google.code.gson:gson:2.6.2