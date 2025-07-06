
package io.gridy.client.model;

import java.io.Serializable;

/**
 *
 *   
 * @author gridy.io
 */
public class VerifyRequest implements Cloneable, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final String challngeId;
    private final String userName;
    private final String authCode;
    private final VerifyType type;
    private final Expiry expiry;
    private final Status status;
    private final boolean useSSE;
    
    
    public VerifyRequest( final String id, final String code, final String username, VerifyType type, Expiry expiry, Status status   ) {         
        this.challngeId = id; 
        this.authCode = code;
        this.userName = username;
        this.type = type;
        this.expiry = expiry;
        this.status = status;
        this.useSSE = false;
        
    }
    
    
    public static class Builder {
        
        private String id;
        private String username;
        private String code;
        private VerifyType type;
        private Expiry expiry;
        private Status status;
       
        public Builder withId( String  id ){
            this.id = id;
            return this;
        }
        
        public Builder forUser( String u ){
            this.username = u;
            return this;
        }
        
        public Builder withCode( String  code ){
            this.code = code;
            return this;
        }
                
        public Builder withVerifyType( VerifyType type ){
            this.type = type;
            return this;
        }
        
        public Builder withExpiry( Expiry expiry ){
            this.expiry = expiry;
            return this;
        }
        
        public Builder withStatus( Status status ){
            this.status = status;
            return this;
        }
        
      
        
        public VerifyRequest build(){
            return new VerifyRequest( 
                 this.id,
             this.code,
                 this.username, 
                    this.type == null ? 
                            VerifyType.Auto : this.type ,
                    this.expiry == null? 
                            Expiry.ThreeMins : this.expiry ,
                    this.status == null ? 
                            Status.NEW : this.status
            );
        }       
    }
    

    public String getChallngeId() {
        return challngeId;
    }
    
    public String getUserName() {
        return userName;
    }


    public Status getStatus() {
        return status;
    }

    public String getAuthCode() {
        return authCode;
    }

    public VerifyType getType() {
        return type;
    }

    public Expiry getExpiry() {
        return expiry;
    }
    
    public int getExpiryInt() {
        switch (this.expiry) {
            case ThreeMins:
                return 3;
            case FiveMins:
                return 5;
            case TenMins:
                return 10;
            case ThirtyMins:
                return 30;
            case SixtyMins:
                return 60;
            default:
                return 3;
        }
    }

    public boolean isUseSSE() {
        return useSSE;
    }
    
    
    
    
     public String toJson(){

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(" 'challngeId': ").append("'").append(   ( this.challngeId == null ) ? "" : this.challngeId  ).append("'").append(",");
        sb.append(" 'gridyUser': ").append("'").append( (this.userName == null ) ? "" : this.userName  ).append("'").append(",");
        sb.append(" 'authCode': ").append("'").append(  this.authCode  ).append("'").append(",");
        sb.append(" 'verifyType': ").append("'").append(   this.type.name()  ).append("'").append(",");        
        sb.append(" 'expiry': ").append("'").append(   this.expiry.name()  ).append("'").append(",");  
        sb.append(" 'status': ").append("'").append( this.status.name() ).append("'");
        sb.append(" }");
        
        return sb.toString();    
    }
    
    
    
    
}
