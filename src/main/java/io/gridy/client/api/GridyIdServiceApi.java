/*
 * Gridy ID API
 * 
 * Gridy ID is a Multi-Factor authentication (MFA) API service & Authenticator application for Android, IOS, Windows, MacOS, Linux & Web . 
 *  
 * Use Gridy to replace your existing username/password authentication or integrate Gridy ID into your adaptive authentication workflow in minutes using our API service and clients
 *

 */


package io.gridy.client.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.gridy.client.ApiCallback;
import io.gridy.client.ApiClient;
import io.gridy.client.ApiException;
import io.gridy.client.ApiResponse;
import com.google.gson.reflect.TypeToken;
import io.gridy.client.model.ApiReqstType;
import io.gridy.client.model.ApiRequest;
import io.gridy.client.model.BlockedRequest;
import io.gridy.client.model.ChallengeRequest;
import io.gridy.client.model.ModelApiResponse;
import io.gridy.client.model.Status;
import io.gridy.client.model.StatusRequest;
import io.gridy.client.model.SysTime;
import io.gridy.client.model.VerifyRequest;
import io.gridy.utils.AutoVerifyListener;
import io.gridy.utils.HttpStatus;
import io.gridy.utils.ResponseListener;
import io.gridy.utils.SnowflakeID;
import io.gridy.utils.StatusCode;
import io.gridy.utils.VerifyListener;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class GridyIdServiceApi {
    
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;
    private SnowflakeID apiIDGen; 

  

    public GridyIdServiceApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
        this.apiIDGen = apiClient.createDefaultIDGenerator();
        
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }


    private String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    private void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for challenge
     * @param apiRequest The JSON body of the request. Contains the Gridy ID challenge request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Accepted - Your Gridy ID API request has been accepted.&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private okhttp3.Call challengeCall(ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = apiRequest;
        // create path and map variables
        String localVarPath = "/v1/svc/challenge";
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json; charset=utf-8"
        };
        
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        return localVarApiClient.buildCall(basePath, localVarPath, "POST",  localVarPostBody, localVarHeaderParams, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call challengeValidateBeforeCall(ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiRequest' is set
        if (apiRequest == null) {
            throw new ApiException("Missing the required parameter 'apiRequest' when calling challenge(Async)");
        }

        return challengeCall(apiRequest, _callback);

    }

    /**
     * Send a Gridy ID MFA auto verify challenge request.
     * 
     * @param challengeRequest The body of the request. Contains the Gridy ID challenge request. (required)
     * @param listener
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Accepted - Your Gridy ID API request has been accepted.&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public void challengeWithAutoVerify( ChallengeRequest challengeRequest, AutoVerifyListener listener ) throws ApiException {
        
        if( challengeRequest.getStatus().equals(Status.NEW ) ){   
          if( challengeRequest.getUserName() == null || challengeRequest.getChallngeType() == null ){
              throw new ApiException("Missing the required parameter 'userName' or 'challengeType' when calling challenge");
          }
        }

        if( challengeRequest.getStatus().equals(Status.CANCEL ) ){          
              throw new ApiException("Invalid challenge status 'CANCEL' ");           
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( challengeRequest.toJson() )  
            .type( ApiReqstType.CHALLENGE_NEW );
                       
        ApiResponse<ModelApiResponse> r = challengeWithHttpInfo(apiRequest);
        
        switch ( r.getStatusCode()  ){                                                                                                                                                                                                   
                case HttpStatus.ACCEPTED:   
                    
                    listener.onChallenge(r.getData());
                    
                     String challengeID = JsonParser
                             .parseString(r.getData().getMessage() )
                             .getAsJsonObject().get("challengeId")
                             .getAsString();
                                          
                     verifyAuto( new VerifyRequest.Builder()
                             .forUser( challengeRequest.getUserName() )
                             .withId(challengeID )
                             .build(), new VerifyListener(){
                                    @Override
                                    public void onVerified(ModelApiResponse r) {
                                      listener.onVerified(r);
                                    }
                                    
                                    @Override
                                    public void onPending() {
                                       listener.onPending();
                                    }

                                    @Override
                                    public void onExpired(ModelApiResponse r) {
                                        listener.onExpired(r);
                                    }

                                    @Override
                                    public void onRejected(ModelApiResponse r) {
                                        listener.onRejected(r);
                                    }

                                    @Override
                                    public void onError(int code) {
                                       listener.onError(code);
                                    }
                                }
                            );
                    
                    break;
                case HttpStatus.BADREQUEST:                    
                    listener.onChallengeError( r.getData().getCode() );
                    break;
                case HttpStatus.SERVERERROR:
                    listener.onChallengeError( r.getStatusCode() );
                    break;
                default:
                    listener.onChallengeError( r.getStatusCode() );
                    break;
                    
          }
        
    }
    
    
    
    /**
     * Send or Cancel a Gridy ID MFA challenge request.
     * 
     * @param challengeRequest The body of the request. Contains the Gridy ID challenge request. (required)
     * @param listener
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Accepted - Your Gridy ID API request has been accepted.&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    
    public void challenge( ChallengeRequest challengeRequest, ResponseListener listener ) throws ApiException {
        
        if( challengeRequest.getStatus().equals(Status.NEW ) ){   
          if( challengeRequest.getUserName() == null || challengeRequest.getChallngeType() == null ){
              throw new ApiException("Missing the required parameter 'userName' or 'challengeType' when calling challenge");
          }
        }

        if( challengeRequest.getStatus().equals(Status.CANCEL ) ){ 
            if( challengeRequest.getId() == null ){
              throw new ApiException("Missing the required parameter 'id' when calling challenge cancel");
          } 
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( challengeRequest.toJson() )  
            .type( ( challengeRequest.getStatus() == Status.NEW )? ApiReqstType.CHALLENGE_NEW  
                    :  ApiReqstType.CHALLENGE_CANCEL  );
        
        
        
        ApiResponse<ModelApiResponse> localVarResp = challengeWithHttpInfo(apiRequest);
        listener.onResponse(  localVarResp.getData() );
    }
    
    
    
    
    
     /**
     * Send or Cancel a Gridy ID MFA challenge request.
     * 
     * @param challengeRequest The body of the request. Contains the Gridy ID challenge request. (required)
     * @return 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Accepted - Your Gridy ID API request has been accepted.&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public ModelApiResponse challenge( ChallengeRequest challengeRequest ) throws ApiException {
        
        if( challengeRequest.getStatus().equals(Status.NEW ) ){   
          if( challengeRequest.getUserName() == null || challengeRequest.getChallngeType() == null ){
              throw new ApiException("Missing the required parameter 'userName' or 'challengeType' when calling challenge");
          }
        }

        if( challengeRequest.getStatus().equals(Status.CANCEL ) ){ 
            if( challengeRequest.getId() == null ){
              throw new ApiException("Missing the required parameter 'id' when calling challenge cancel");
          } 
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( challengeRequest.toJson() )  
            .type( ( challengeRequest.getStatus() == Status.NEW )? ApiReqstType.CHALLENGE_NEW  
                    :  ApiReqstType.CHALLENGE_CANCEL  );
        
        
        
        ApiResponse<ModelApiResponse> localVarResp = challengeWithHttpInfo(apiRequest);
        return localVarResp.getData();
    }
    
    
    
    
    /**
     * Send or Cancel a Gridy ID MFA challenge request.
     * 
     * @param apiRequest The JSON body of the request. Contains the Gridy ID challenge request. (required)
     * @return ApiResponse&lt;ModelApiResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Accepted - Your Gridy ID API request has been accepted.&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private ApiResponse<ModelApiResponse> challengeWithHttpInfo(ApiRequest apiRequest) throws ApiException {
        okhttp3.Call localVarCall = challengeValidateBeforeCall(apiRequest, null);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Send or Cancel a Gridy ID MFA challenge request. (asynchronously)
     * 
     * @param challengeRequest The body of the request. Contains the Gridy ID challenge request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Accepted - Your Gridy ID API request has been accepted.&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call challengeAsync(ChallengeRequest challengeRequest, final ApiCallback<ModelApiResponse> _callback) throws ApiException {
        
        if( challengeRequest.getStatus().equals(Status.NEW ) ){  
          if( challengeRequest.getUserName() == null || challengeRequest.getChallngeType() == null ){
              throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeType' when calling challenge");
          }
        }

        if( challengeRequest.getStatus().equals(Status.CANCEL ) ){ 
            if( challengeRequest.getId() == null ){
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling challenge cancel");
          }             
        }
        
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( challengeRequest.toJson() )  
            .type( ( challengeRequest.getStatus() == Status.NEW )? ApiReqstType.CHALLENGE_NEW  
                    :  ApiReqstType.CHALLENGE_CANCEL  );
         
        okhttp3.Call localVarCall = challengeValidateBeforeCall(apiRequest, _callback);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    
    
    
    /**
     * Build call for status
     * @param apiRequest The JSON body of the request. Contains the Status request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private okhttp3.Call statusCall(ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = apiRequest;

        // create path and map variables
        String localVarPath = "/v1/svc/status";
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json; charset=utf-8"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        return localVarApiClient.buildCall(basePath, localVarPath, "POST",  localVarPostBody, localVarHeaderParams, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call statusValidateBeforeCall(ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiRequest' is set
        if (apiRequest == null) {
            throw new ApiException("Missing the required parameter 'apiRequest' when calling status(Async)");
        }

        return statusCall(apiRequest, _callback);

    }

    /**
     * Check a Gridy ID MFA challenge status
     * 
     * @param apiRequest The JSON body of the request. Contains the Status request. (required)
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public void status( StatusRequest statusRequest, ResponseListener listener ) throws ApiException {
        
        if( statusRequest.getUserName() == null && statusRequest.getChallngeId() == null  ){
               throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeId' when calling status");
        }
      
        
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body(  statusRequest.toJson() )
            .type( ApiReqstType.CHECKSTATUS );
        
        
        ApiResponse<ModelApiResponse> localVarResp = statusWithHttpInfo(apiRequest);
        listener.onResponse( localVarResp.getData());
    }
    
    
    
     /**
     * Check a Gridy ID MFA challenge status
     * 
     * @param statusRequest The JSON body of the request. Contains the Status request. (required)
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public ModelApiResponse status( StatusRequest statusRequest ) throws ApiException {
        
        if( statusRequest.getUserName() == null && statusRequest.getChallngeId() == null  ){
               throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeId' when calling status");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body(  statusRequest.toJson() )
            .type( ApiReqstType.CHECKSTATUS );
        
        
        ApiResponse<ModelApiResponse> localVarResp = statusWithHttpInfo(apiRequest);
        return localVarResp.getData();
    }
    

    /**
     * Check a Gridy ID MFA challenge status
     * 
     * @param apiRequest The JSON body of the request. Contains the Status request. (required)
     * @return ApiResponse&lt;ModelApiResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private ApiResponse<ModelApiResponse> statusWithHttpInfo(ApiRequest apiRequest) throws ApiException {
        okhttp3.Call localVarCall = statusValidateBeforeCall(apiRequest, null);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Check a Gridy ID MFA challenge status (asynchronously)
     * 
     * @param statusRequest The JSON body of the request. Contains the Status request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call statusAsync( StatusRequest statusRequest, final ApiCallback<ModelApiResponse> _callback) throws ApiException {

        if( statusRequest.getUserName() == null && statusRequest.getChallngeId() == null  ){
               throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeId' when calling status");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body(  statusRequest.toJson() )
            .type( ApiReqstType.CHECKSTATUS );
        
        okhttp3.Call localVarCall = statusValidateBeforeCall(apiRequest, _callback);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for time
     * @param _callback The callback to be executed when the API call finishes
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below:&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private okhttp3.Call timeCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/svc/time";

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarPostBody, localVarHeaderParams, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call timeValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return timeCall(_callback);

    }

    /**
     * Get current UTC time
     * 
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below:&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public void time( ResponseListener listener ) throws ApiException {
        ApiResponse<ModelApiResponse> localVarResp = timeWithHttpInfo();
        listener.onResponse( localVarResp.getData() );
    }
    
    
      /**
     * Get current UTC time
     * 
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below:&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public ModelApiResponse time() throws ApiException {
        ApiResponse<ModelApiResponse> localVarResp = timeWithHttpInfo();
        return  localVarResp.getData() ;
    }

    /**
     * Get current UTC time
     * 
     * @return ApiResponse&lt;ModelApiResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below:&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private ApiResponse<ModelApiResponse> timeWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = timeValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get current UTC time (asynchronously)
     * 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below:&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call timeAsync(final ApiCallback<ModelApiResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = timeValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for verify
     * @param apiRequest The JSON body of the request. Contains the Gridy ID Verify request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify code expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify challenge id match error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3082 &lt;/a&gt; &amp;emsp;Verify challenge expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3088 &lt;/a&gt; &amp;emsp;Verify challenge already verified error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3089 &lt;/a&gt; &amp;emsp;Verify challenge already authenticated error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private okhttp3.Call verifyCall( ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
       
       
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  }; 
        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }
        
        Object localVarPostBody = apiRequest;
        // create path and map variables
        String localVarPath = "/v1/svc/verify";
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
       
        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json; charset=utf-8"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarPostBody, localVarHeaderParams, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call verifyValidateBeforeCall(ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiRequest' is set
        if (apiRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'apiRequest' when calling verify(Async)");
        }

        return verifyCall(apiRequest, _callback);

    }

    /**
     * Verify a Gridy ID authentication code
     * 
     * 
     * @param  verifyRequest The body of the request. Contains the Gridy ID Verify request. (required)
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify code expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify challenge id match error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3082 &lt;/a&gt; &amp;emsp;Verify challenge expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3088 &lt;/a&gt; &amp;emsp;Verify challenge already verified error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3089 &lt;/a&gt; &amp;emsp;Verify challenge already authenticated error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public void verify( VerifyRequest verifyRequest, ResponseListener listener) throws ApiException {
        
        
         if( verifyRequest.getUserName() == null || verifyRequest.getChallngeId() == null || verifyRequest.getAuthCode() == null ){
               throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeId' or 'authCode' when calling verify");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( verifyRequest.toJson() )
            .type( ApiReqstType.VERIFY_AUTHCODE ); 
        
        
        ApiResponse<ModelApiResponse> localVarResp = verifyWithHttpInfo(apiRequest);
        listener.onResponse( localVarResp.getData() );
    }
    
    
     /**
     * Verify a Gridy ID authentication code
     * 
     * 
     * @param  verifyRequest The body of the request. Contains the Gridy ID Verify request. (required)
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     * <table summary="Response Details" border="1">
     *   <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     *   <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     *   <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify code expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify challenge id match error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3082 &lt;/a&gt; &amp;emsp;Verify challenge expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3088 &lt;/a&gt; &amp;emsp;Verify challenge already verified error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3089 &lt;/a&gt; &amp;emsp;Verify challenge already authenticated error&lt;/p&gt; </td><td>  -  </td></tr>
     *   <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     * </table>
     */
    public ModelApiResponse verify( VerifyRequest verifyRequest) throws ApiException {
                
        if( verifyRequest.getUserName() == null || verifyRequest.getChallngeId() == null || verifyRequest.getAuthCode() == null ){
               throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeId' or 'authCode' when calling verify");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( verifyRequest.toJson() )
            .type( ApiReqstType.VERIFY_AUTHCODE ); 
        
        
        ApiResponse<ModelApiResponse> localVarResp = verifyWithHttpInfo(apiRequest);
        return localVarResp.getData();
    }
    
    
    
    /**
     * AutoVerify a Gridy ID authentication code
     * 
     * @param verifyRequest The body of the request. Contains the Gridy ID Verify request. (required)
     * @param verifyListener
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     * 
     * <table summary="Response Details" border="1">
     *   <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     *   <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     *   <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify code expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify challenge id match error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3082 &lt;/a&gt; &amp;emsp;Verify challenge expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3088 &lt;/a&gt; &amp;emsp;Verify challenge already verified error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3089 &lt;/a&gt; &amp;emsp;Verify challenge already authenticated error&lt;/p&gt; </td><td>  -  </td></tr>
     *   <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     * </table>
     */
    
     public void verifyAuto( VerifyRequest verifyRequest, VerifyListener verifyListener ) throws ApiException {
                
        if( verifyRequest.getUserName() == null || verifyRequest.getChallngeId() == null ){
            throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeId' when calling autoverify");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( verifyRequest.toJson() )
            .type( ApiReqstType.CHECKSTATUS 
            
            ); 
                
         if( !verifyRequest.isUseSSE() ){
            final Timer timer = new Timer();       
                timer.scheduleAtFixedRate(new TimerTask() {

                    long tickTime = 10000L;
                    long startTime = 0L;
                    long currentTime = 0L;
                    long maxTimeout = verifyRequest.getExpiryInt()*60*1000; 
                    boolean shutdown = false;
                    
                    void setCurrentTime(){
                       currentTime = currentTime + tickTime;
                    }

                    @Override
                    public void run() {
                      setCurrentTime();  
                      if ( currentTime >= maxTimeout ){                          
                          timer.cancel();
                      }  
                      
                      if( shutdown ){
                           timer.cancel();
                      }
                      
                      try{   
                          
                         ApiResponse<ModelApiResponse> localVarResp = statusWithHttpInfo(apiRequest);
                         switch (localVarResp.getStatusCode()){                                 
                             case HttpStatus.BADREQUEST:                                  
                                 switch( localVarResp.getData().getCode() ) {                                 
                                     case StatusCode.ERROR_ACCTLOCK_ENABLED:
                                          verifyListener.onRejected(  localVarResp.getData() );
                                          shutdown = true;  
                                         break;
                                     case StatusCode.ERROR_VERIFY_REJECTED:
                                          verifyListener.onRejected(  localVarResp.getData() );
                                          shutdown = true; 
                                         break;
                                     case StatusCode.ERROR_VERIFY_WAITING:
                                         verifyListener.onPending( );                                                                                    
                                         break;
                                         
                                     default:
                                         break;                                            
                                 }                                 
                                 break;                                 
                             case HttpStatus.NOTFOUND:  
                                 verifyListener.onError( HttpStatus.NOTFOUND );
                                 shutdown = true;   
                                 break;                             
                             case HttpStatus.OK:            
                                    verifyListener.onVerified( localVarResp.getData() );
                                    shutdown = true;                              
                                 break;                                 
                             case HttpStatus.SERVERERROR:
                                  verifyListener.onError( HttpStatus.SERVERERROR );
                                  shutdown = true;   
                                 break;
                         }                                                                        
                      } catch (ApiException ex ){
                            System.out.println( ex.fillInStackTrace() );                     
                            //throw new ApiException();                            
                      }
                    }
                }, 1000, 10000 );
          }        
    }
    
    

    /**
     * Verify a Gridy ID authentication code
     * 
     * @param apiRequest The JSON body of the request. Contains the Gridy ID Verify request. (required)
     * @return ApiResponse&lt;ModelApiResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify code expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify challenge id match error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3082 &lt;/a&gt; &amp;emsp;Verify challenge expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3088 &lt;/a&gt; &amp;emsp;Verify challenge already verified error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3089 &lt;/a&gt; &amp;emsp;Verify challenge already authenticated error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private ApiResponse<ModelApiResponse> verifyWithHttpInfo(ApiRequest apiRequest) throws ApiException {
        okhttp3.Call localVarCall = verifyValidateBeforeCall(apiRequest, null);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Verify a Gridy ID authentication code (asynchronously)
     * 
     * @param verifyRequest The body of the request. Contains the Gridy ID Verify request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify code expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3081 &lt;/a&gt; &amp;emsp;Verify challenge id match error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3082 &lt;/a&gt; &amp;emsp;Verify challenge expired error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3088 &lt;/a&gt; &amp;emsp;Verify challenge already verified error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -3089 &lt;/a&gt; &amp;emsp;Verify challenge already authenticated error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call verifyAsync( VerifyRequest verifyRequest, final ApiCallback<ModelApiResponse> _callback) throws ApiException {

          if( verifyRequest.getUserName() == null || verifyRequest.getChallngeId() == null || verifyRequest.getAuthCode() == null ){
               throw new IllegalArgumentException("Missing the required parameter 'userName' or 'challengeId' or 'authCode' when calling verify");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body( verifyRequest.toJson() )
            .type( ApiReqstType.VERIFY_AUTHCODE ); 
        
        
        
        okhttp3.Call localVarCall = verifyValidateBeforeCall(apiRequest, _callback);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    
    
    
    
      /**
     * Build call for blocked
     * @param apiRequest The JSON body of the request. Contains the Gridy ID blocked request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; OK - Your Gridy ID API request has been accepted.&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private okhttp3.Call blockedCall(ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = apiRequest;

        // create path and map variables
        String localVarPath = "/v1/svc/blocked";
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json; charset=utf-8"
        };
        
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        
        return localVarApiClient.buildCall(basePath, localVarPath, "POST",  localVarPostBody, localVarHeaderParams, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call blockedValidateBeforeCall(ApiRequest apiRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiRequest' is set
        if (apiRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'apiRequest' when calling challenge(Async)");
        }

        return blockedCall(apiRequest, _callback);

    }

    /**
     * Check API User defined Blocked Rules
     * 
     * @param blockedRequest The body of the request. Contains the Gridy ID blocked request. (required)
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; OK - Blocked Rules Checks OK  .&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public void blocked(BlockedRequest blockedRequest, ResponseListener listener ) throws ApiException {
        
          if( blockedRequest.getUserName() == null && blockedRequest.getIpv4Address() == null  ){
               throw new IllegalArgumentException("Missing the required parameter 'userName' or 'ipv4Address' when calling blocked");
        
          }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body(  blockedRequest.toJson() )
            .type( ApiReqstType.BLOCKED_RULES_CHECK );
        
        ApiResponse<ModelApiResponse> localVarResp = challengeWithHttpInfo(apiRequest);
        listener.onResponse( localVarResp.getData() );
    }
    
    
      /**
     * Check API User defined Blocked Rules
     * 
     * @param blockedRequest The body of the request. Contains the Gridy ID blocked request. (required)
     * @return ModelApiResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; OK - Blocked Rules Checks OK  .&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public ModelApiResponse blocked(BlockedRequest blockedRequest ) throws ApiException {
        
        if( blockedRequest.getUserName() == null && blockedRequest.getIpv4Address() == null  ){
             throw new IllegalArgumentException("Missing the required parameter 'userName' or 'ipv4Address' when calling blocked");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body(  blockedRequest.toJson() )
            .type( ApiReqstType.BLOCKED_RULES_CHECK );
        
        ApiResponse<ModelApiResponse> localVarResp = challengeWithHttpInfo(apiRequest);
        return localVarResp.getData();
    }
    

    /**
     * Check API User defined Blocked Rules.
     * 
     * @param apiRequest The JSON body of the request. Contains the Gridy ID challenge request. (required)
     * @return ApiResponse&lt;ModelApiResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 209 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; OK - Blocked Rules Checks OK .&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    private ApiResponse<ModelApiResponse> blockedWithHttpInfo(ApiRequest apiRequest) throws ApiException {
        okhttp3.Call localVarCall = blockedValidateBeforeCall(apiRequest, null);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Check API User defined Blocked Rules. (asynchronously)
     * 
     * @param blockedRequest The body of the request. Contains the Gridy ID blocked request. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; OK - Blocked Rules Checks OK .&lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;  &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2025 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Accepted &lt;br&gt; &amp;emsp; &lt;a href&#x3D;\&quot;\&quot;&gt; 2028 &lt;/a&gt; &amp;emsp; New Gridy ID Challenge Cancelled </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> &lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 15px;\&quot;&gt; Bad Request - Your Gridy ID API request was rejected. &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 14px;\&quot;&gt; See list of all API status codes below: &lt;/p&gt;&lt;p style&#x3D;\&quot;font-family: &#39;Montserrat&#39;; font-size: 13px;\&quot;&gt;   &lt;a href&#x3D;\&quot;\&quot;&gt; -4004 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4005 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-utctime format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4006 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4007 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-nonce format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4008 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4009 &lt;/a&gt; &amp;emsp;HTTP Header x-gridy-apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4000 &lt;/a&gt; &amp;emsp;HTTP Authorization Header missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4001 &lt;/a&gt; &amp;emsp;HTTP Authorization Header format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4026 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature missing  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4027 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4028 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4029 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC apiuser format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4030 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4031 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC algorithm format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4032 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers missing error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4033 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC headers format error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4034 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC nonce reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4035 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC timestamp reused error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4036 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC utctime clock drift error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -4037 &lt;/a&gt; &amp;emsp;HTTP Authorization Header HMAC signature error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1001 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1003 &lt;/a&gt; &amp;emsp;API User validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -1026 &lt;/a&gt; &amp;emsp;API User permissions error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -6021 &lt;/a&gt; &amp;emsp;API request blocked - IP address location blocked based on user defined rules  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2003 &lt;/a&gt; &amp;emsp;Account validation error  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2004 &lt;/a&gt; &amp;emsp;Account blocked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2005 &lt;/a&gt; &amp;emsp;Account too many failed attempts  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2006 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2007 &lt;/a&gt; &amp;emsp;Account disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2008 &lt;/a&gt; &amp;emsp;Account not active  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2009 &lt;/a&gt; &amp;emsp;Account locked  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2010 &lt;/a&gt; &amp;emsp;Account temporarily disabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2017 &lt;/a&gt; &amp;emsp;Account lock enabled  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2038 &lt;/a&gt; &amp;emsp;Account lockdown activated  &amp;emsp;&lt;br&gt; &lt;a href&#x3D;\&quot;\&quot;&gt; -2035 &lt;/a&gt; &amp;emsp;Challenge cancelled error&lt;/p&gt; </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Error - Your Gridy ID API request was rejected due to an Internal error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call blockedAsync( BlockedRequest blockedRequest, final ApiCallback<ModelApiResponse> _callback) throws ApiException {

        
        if( blockedRequest.getUserName() == null && blockedRequest.getIpv4Address() == null  ){
           throw new IllegalArgumentException("Missing the required parameter 'userName' or 'ipv4Address' when calling blocked");
        }
      
        ApiRequest apiRequest = new ApiRequest()
            .id( apiIDGen.getIdStr() )
            .utcTime(new SysTime().getSystemUtcTimeMsStr() )
            .apiUser( localVarApiClient.getApiUser() )
            .body(  blockedRequest.toJson() )
            .type( ApiReqstType.BLOCKED_RULES_CHECK );
              
        okhttp3.Call localVarCall = blockedValidateBeforeCall(apiRequest, _callback);
        Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    
    
    
    
    
    
    
    
    
    
    
}
