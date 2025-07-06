
package io.gridy.client;

import io.gridy.client.model.GridyEnv;



/**
 *
 * @author gridy.io
 */
public class ApiConfig {
 
    
    public static class Builder {
        
        private String apiUser;
        private String apiSecret;
        private GridyEnv apiEnv;
        private String customUrl;           
        
        public Builder withApiUser( String u ){
            this.apiUser = u;
            return this;
        }
        
        public Builder withApiSecret( String s ){
            this.apiSecret = s;
            return this;
        }
        
        public Builder withApiEnv( GridyEnv e ){
            this.apiEnv = e;
            return this;
        }
         
        public Builder withCustomApiUrl( String e ){
            this.customUrl = e;
            return this;
        }
   
      
        public ApiClient build() throws Exception {           
               return new ApiClient( this );
        }

        
        
        public String getApiUser() {
            return apiUser;
        }

        public String getApiSecret() {
            return apiSecret;
        }

        public GridyEnv getApiEnv() {
            return apiEnv;
        }

        public String getCustomApiUrl() {
            return customUrl;
        }

        
          
     }
    

}
