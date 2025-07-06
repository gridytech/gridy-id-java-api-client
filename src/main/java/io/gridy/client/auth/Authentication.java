/*
 * Gridy ID API
 *
 * Gridy ID is a Multi-Factor authentication (MFA) API service & Authenticator application for Android, IOS, Windows, MacOS, Linux & Web. 
 *
 * Use Gridy to replace your existing username/password authentication or Integrate Gridy ID into your adaptive authentication workflow in minutes using our API service and clients.
 */


package io.gridy.client.auth;

import java.net.URI;
import java.util.Map;
import java.util.List;
import io.gridy.client.ApiException;

public interface Authentication {
    /**
     * Apply authentication settings to header and query params.
     *
     * @param headerParams Map of header parameters   
     * @param payload HTTP request body
     * @param method HTTP method
     * @param uri URI
     * @throws ApiException if failed to update the parameters
     */
    void applyToParams(Map<String, String> headerParams, String payload, String method, URI uri) throws ApiException;
}
