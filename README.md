# gridy-id-java-client

Gridy ID is a Multi-Factor authentication (MFA) API service & Authenticator application for Android, IOS, Windows, MacOS, Linux & Web.

Use Gridy to replace your existing username/password authentication or Integrate Gridy ID into your adaptive authentication workflow inminutes using our API service and clients


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.gridy</groupId>
  <artifactId>gridy-id-java-client</artifactId>
  <version>0.5.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'gridy-id-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'gridy-id-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "io.gridy:gridy-id-java-client:0.5.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/gridy-java-client-0.5.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

  import io.gridy.client.ApiClient;
  import io.gridy.client.ApiException;
  import io.gridy.client.Configuration;
  import io.gridy.client.auth.HmacSha512Auth;
  import io.gridy.client.model.*;
  import io.gridy.client.api.GridyIdServiceApi

  ApiClient defaultClient = new ApiConfig.Builder()             
         # Configure API User Id                       
        .withApiUser( System.getEnv("GRIDY_API_USER")  )                
         # Configure API User Secret
        .withApiSecret( System.getEnv("GRIDY_API_SECRET")  )                
         # Configure API Environment
        .withApiEnv(GridyEnv.LIVE)
            .build(); 

  GridyIdServiceApi apiInstance = new GridyIdServiceApi(defaultClient);
      ApiRequest apiRequest = new ApiRequest()
            .id("YOUR ID REFERENCE")
            .apiUser( defaultClient.getApiUser() )
            .type(ApiReqstType.CHALLENGE_NEW )
            .body( new ChallengeRequest.Builder()                      
                .forUser( "<USER EMAIL ADDRESS>" )
                .challengeType( ChallengeType.UserKeyAndPattern ) 
                .enableAutoVerify( false )
                .enableQRcode( true )    
                .withExpiry( Expiry.ThirtyMins  )
                .withStatus( Status.NEW )
                .withProfile( Profile.DEFAULT )
                .withIPAddress("")
                .build().toJson()
               );

      try {

        ModelApiResponse result = apiInstance.challenge(apiRequest);
        System.out.println(result);

      } catch (ApiException e) {

        System.err.println("Exception when calling GridyIdServiceApi#challenge");
        System.err.println("Status code: " + e.getCode());
        System.err.println("Reason: " + e.getResponseBody());
        System.err.println("Response headers: " + e.getResponseHeaders());

        e.printStackTrace();
}




```

## Documentation for API Endpoints

All URIs are relative to *https://api.gridy.io*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
[*GridyIDServiceApi*] | [**challenge**](https://support.gridy.io/docs/api/challenge.html) | **POST** /v1/svc/challenge | Send or Cancel a Gridy ID MFA challenge request.
[*GridyIDServiceApi*] | [**status**](https://support.gridy.io/docs/api/status.html) | **POST** /v1/svc/status | Check a Gridy ID MFA challenge status
[*GridyIDServiceApi*] | [**time**](https://support.gridy.io/docs/api/time.html) | **GET** /v1/svc/time | Get current UTC time
[*GridyIDServiceApi*] | [**verify**](https://support.gridy.io/docs/api/verify.html) | **POST** /v1/svc/verify | Verify a Gridy ID authentication code
[*GridyIDServiceApi*] | [**blocked**](https://support.gridy.io/docs/api/blocked.html) | **POST** /v1/svc/blocked | Check IPv4 & User Blocked Rules.


## Documentation For Models

 - [ApiRequest](doc/ApiRequest.md)
 - [ApiResponse](doc/ApiResponse.md)


## Documentation For Authorization


[Authentication](https://support.gridy.io/docs/api/security.html) schemes defined for the API:

### x-gridy-apiuser

- **Type**: Hmac512
- **parameter name**: x-gridy-apiuser
- **Location**: HTTP header

### x-gridy-cnonce

- **Type**: Hmac512
- **parameter name**: x-gridy-cnonce
- **Location**: HTTP header

### x-gridy-utctime

- **Type**:  Hmac512
- **parameter name**: x-gridy-utctime
- **Location**: HTTP header

### GridyHmacAuth

- **Type**: Hmac512
- **parameter name**: Authorization
- **Location**: HTTP header




## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author
Gridy.io
