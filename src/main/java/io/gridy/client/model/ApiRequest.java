/*
 * Gridy ID API
 *
 * Gridy ID is a Multi-Factor authentication (MFA) API service & Authenticator application for Android, IOS, Windows, MacOS, Linux & Web.
 *
 * Use Gridy to replace your existing username/password authentication or integrate Gridy ID into your adaptive authentication workflow 
   in minutes using our API service and clients
*/


package io.gridy.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gridy.client.JSON;
import java.io.IOException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.gridy.client.JSON;

/**
 * ApiRequest
 */

public class ApiRequest {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_UTC_TIME = "utcTime";
  @SerializedName(SERIALIZED_NAME_UTC_TIME)
  private String utcTime;

  public static final String SERIALIZED_NAME_API_USER = "apiUser";
  @SerializedName(SERIALIZED_NAME_API_USER)
  private String apiUser;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private Integer type;

  public static final String SERIALIZED_NAME_BODY = "body";
  @SerializedName(SERIALIZED_NAME_BODY)
  private String body;

  public ApiRequest() {
  }

  public ApiRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public ApiRequest utcTime(String utcTime) {
    this.utcTime = utcTime;
    return this;
  }

  /**
   * Get utcTime
   * @return utcTime
   */
  @javax.annotation.Nonnull
  public String getUtcTime() {
    return utcTime;
  }

  public void setUtcTime(String utcTime) {
    this.utcTime = utcTime;
  }


  public ApiRequest apiUser(String apiUser) {
    this.apiUser = apiUser;
    return this;
  }

  /**
   * Get apiUser
   * @return apiUser
   */
  @javax.annotation.Nonnull
  public String getApiUser() {
    return apiUser;
  }

  public void setApiUser(String apiUser) {
    this.apiUser = apiUser;
  }


  public ApiRequest type(Integer type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nonnull
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }


  public ApiRequest body(String body) {
    this.body = body;
    return this;
  }

  /**
   * Get body
   * @return body
   */
  @javax.annotation.Nonnull
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiRequest apiRequest = (ApiRequest) o;
    return Objects.equals(this.id, apiRequest.id) &&
        Objects.equals(this.utcTime, apiRequest.utcTime) &&
        Objects.equals(this.apiUser, apiRequest.apiUser) &&
        Objects.equals(this.type, apiRequest.type) &&
        Objects.equals(this.body, apiRequest.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, utcTime, apiUser, type, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiRequest {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    utcTime: ").append(toIndentedString(utcTime)).append("\n");
    sb.append("    apiUser: ").append(toIndentedString(apiUser)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("id");
    openapiFields.add("utcTime");
    openapiFields.add("apiUser");
    openapiFields.add("type");
    openapiFields.add("body");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("utcTime");
    openapiRequiredFields.add("apiUser");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("body");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ApiRequest
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ApiRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ApiRequest is not found in the empty JSON string", ApiRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ApiRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ApiRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ApiRequest.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("utcTime").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `utcTime` to be a primitive type in the JSON string but got `%s`", jsonObj.get("utcTime").toString()));
      }
      if (!jsonObj.get("apiUser").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `apiUser` to be a primitive type in the JSON string but got `%s`", jsonObj.get("apiUser").toString()));
      }
      if (!jsonObj.get("body").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `body` to be a primitive type in the JSON string but got `%s`", jsonObj.get("body").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ApiRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ApiRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ApiRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ApiRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<ApiRequest>() {
           @Override
           public void write(JsonWriter out, ApiRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ApiRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ApiRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ApiRequest
   * @throws IOException if the JSON string is invalid with respect to ApiRequest
   */
  public static ApiRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ApiRequest.class);
  }

  /**
   * Convert an instance of ApiRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
  
  
  
  
  
}

