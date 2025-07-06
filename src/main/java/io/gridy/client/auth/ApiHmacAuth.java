
package io.gridy.client.auth;

/**
 *
 * @author gridy.io
 */
import io.gridy.client.ApiException;
import io.gridy.client.model.SysTime;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.apache.commons.codec.binary.Hex;


/*
 * 
 * Authorization: <auth-scheme> <authorization-parameters> 
 * Gridy
 * 
 *   Authorization: gridy-hmac: apiuser=, signedheaders=x-gridy-utctime;x-gridy-cnonce,signature=fe5f80f77d5fa3beca038a248ff027d0445342fe2855ddc963176630326f1024
 * 
 *     
 * 
 */


public class ApiHmacAuth {
     
    private final String HMAC_SHA512_ALGORITHM = "HmacSha512";

    private String utcTime;
    private String cNonce;
    private String hmacAuthHdr;
    private String apiUser = "";
    private String secretKey = "";
    private boolean retryOnTimeError;
        
    public ApiHmacAuth( final String apiuser, final String secretkey ) {
        this.apiUser = apiuser;
        this.secretKey = secretkey;        
                      
    }
    
    public ApiHmacAuth() {             
                      
    }
    
    
    public void generateNewHmac() throws ApiException {
        this.utcTime = new SysTime().getSystemUtcTimeMsStr();
        this.cNonce = UUID.randomUUID().toString();
        this.hmacAuthHdr = String.format( "gridy-hmac: apiuser=%s,signedheaders=x-gridy-utctime;x-gridy-cnonce,algorithm=gridy-hmac512,signature=%s", this.apiUser, generateHmacSig() );
    
    }
    
    /*
     * 
     *
     */
   
    private String generateHmacSig() throws ApiException {       
        
        validateFields();
        String data = String.format("x-gridy-utctime: %s\nx-gridy-cnonce: %s", this.utcTime , this.cNonce);   
        return calculateHmac( data );
    }
    
    
    
        
    /*
     * 
     * 
     */
  
    private String calculateHmac(final String content ) throws ApiException {
        
        String hmac = null;
        byte[] rawHmac = null;
       
        try {
    
            SecretKeySpec signingKey = new SecretKeySpec( this.secretKey.getBytes(), HMAC_SHA512_ALGORITHM );
            Mac mac = Mac.getInstance(HMAC_SHA512_ALGORITHM);
            mac.init(signingKey);
            rawHmac = mac.doFinal(content.getBytes());
            hmac = Hex.encodeHexString(rawHmac);
             
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
             throw new ApiException("Failed to generate HMAC : " + e.getMessage());
        }
               
        return hmac;
    }


    private void validateFields() {
        
        if (this.apiUser == null) {
            throw new IllegalStateException("API User required for GridyHmacAPI Auth");
        }
        
        if (this.secretKey == null) {
            throw new IllegalStateException("Secret Key required for GridyHmacAPI Auth");
        }
        
        
        if (this.utcTime == null) {
            throw new IllegalStateException("UTC Time required for GridyHmacAPI Auth");
        }
         
        if (this.cNonce == null) {
            throw new IllegalStateException("CNonce required for GridyHmacAPI Auth");
        } 
        
    }
    
    
    /* Getters */

    public String getApiUser() {
        return apiUser;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public String getcNonce() {
        return cNonce;
    }

    public String getHmacAuthHdr() {
        return hmacAuthHdr;
    }

    public boolean isRetryOnTimeError() {
        return retryOnTimeError;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


    
    


    public void setRetryOnTimeError(boolean retryOnUTCTimeError) {
        this.retryOnTimeError = retryOnUTCTimeError;
    }

    
      
    


}
