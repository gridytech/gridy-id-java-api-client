/*
 * Gridy ID API
 * Gridy ID is a Multi-Factor authentication (MFA) API service & Authenticator application for Android, IOS, Windows, MacOS, Linux & Web. 

   Use Gridy to replace your existing username/password authentication or Integrate Gridy ID into your adaptive authentication workflow in minutes using our API service and clients</p><p>When using the API Explorer, you will need to use the HMAC tool to generate the required headers for each request. <p>
 *

 */


package io.gridy.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.gridy.client.JSON;

/**
 * ModelApiResponse
 */

public class ModelApiResponse {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_UTC_TIME = "utcTime";
  @SerializedName(SERIALIZED_NAME_UTC_TIME)
  private String utcTime;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private Integer status;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message;

  public static final String SERIALIZED_NAME_CODE = "code";
  @SerializedName(SERIALIZED_NAME_CODE)
  private Integer code;

  public static final String SERIALIZED_NAME_MORE_INFO = "moreInfo";
  @SerializedName(SERIALIZED_NAME_MORE_INFO)
  private String moreInfo;

  public ModelApiResponse() {
  }

  public ModelApiResponse id(String id) {
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


  public ModelApiResponse utcTime(String utcTime) {
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


  public ModelApiResponse status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nonnull
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public ModelApiResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  @javax.annotation.Nonnull
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public ModelApiResponse code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  @javax.annotation.Nonnull
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }


  public ModelApiResponse moreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
    return this;
  }

  /**
   * Get moreInfo
   * @return moreInfo
   */
  @javax.annotation.Nullable
  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelApiResponse _apiResponse = (ModelApiResponse) o;
    return Objects.equals(this.id, _apiResponse.id) &&
        Objects.equals(this.utcTime, _apiResponse.utcTime) &&
        Objects.equals(this.status, _apiResponse.status) &&
        Objects.equals(this.message, _apiResponse.message) &&
        Objects.equals(this.code, _apiResponse.code) &&
        Objects.equals(this.moreInfo, _apiResponse.moreInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, utcTime, status, message, code, moreInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelApiResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    utcTime: ").append(toIndentedString(utcTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
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
    openapiFields.add("status");
    openapiFields.add("message");
    openapiFields.add("code");
    openapiFields.add("moreInfo");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("utcTime");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("message");
    openapiRequiredFields.add("code");
    
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ModelApiResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ModelApiResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ModelApiResponse is not found in the empty JSON string", ModelApiResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ModelApiResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ModelApiResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ModelApiResponse.openapiRequiredFields) {
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
      if (!jsonObj.get("message").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `message` to be a primitive type in the JSON string but got `%s`", jsonObj.get("message").toString()));
      }
      if ((jsonObj.get("moreInfo") != null && !jsonObj.get("moreInfo").isJsonNull()) && !jsonObj.get("moreInfo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `moreInfo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("moreInfo").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ModelApiResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ModelApiResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ModelApiResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ModelApiResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<ModelApiResponse>() {
           @Override
           public void write(JsonWriter out, ModelApiResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ModelApiResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ModelApiResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ModelApiResponse
   * @throws IOException if the JSON string is invalid with respect to ModelApiResponse
   */
  public static ModelApiResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ModelApiResponse.class);
  }

  /**
   * Convert an instance of ModelApiResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

