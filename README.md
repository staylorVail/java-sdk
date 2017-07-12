## Introduction
The Persephony Java SDK will allow you to easily use the Persephony API in a Java application.

## Getting Started with Maven
To use the SDK with Maven you can specify the dependency in your **pom.xml** file.

```xml
<dependency>
  <groupId>com.vailsys.persephony</groupId>
  <artifactId>persy-java-sdk</artifactId>
  <version>0.1.2</version>
</dependency>
```
## Getting Started with Gradle
To use the SDK with Gradle you can specify the dependency in your **build.gradle** file.

```groovy
repositories {
    mavenCentral()
}

dependencies {
  compile 'com.vailsys.persephony:persy-java-sdk:0.1.2'
}
```
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

        client.calls.create(To, From, "", "");
    }

}
```

When you run this code you should get a phone call. Answering it won't do anything, but you'll know the SDK is installed correctly.

## Documentation

The SDK documentation is available [here](https://gitlab.vailsys.com/vail-cloud-services/persy-java-sdk/tree/master) and you'll find example use cases in our tutorials [here](https://persy-stable.vail/docs/tutorials/list-calls/)

## Getting Help

Contact our support team at [support@persephony.com](mailto:support@persephony.com)
