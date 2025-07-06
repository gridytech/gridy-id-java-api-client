
package io.gridy.client.model;

import java.io.Serializable;

/**  
 * 
 *   
 * @author gridy.io
 */
public class ChallengeRequest implements Cloneable, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final String id;
    private final String userName;
    private final ChallengeType challngeType;
    private final boolean enableQRCode;    
    private final boolean enableAutoVerify;
    private final Expiry challngeExpiry;
    private final Status status;
    private final Profile profile;
    private final String profileName;
    private final String ipAddress;
    private final int pollFreq;
    
    
    public ChallengeRequest( final String id, final String username, final ChallengeType type, 
            boolean qrcode, boolean autoverify, Expiry expiry, Status status, Profile authz, String custom, 
            String ipaddr, int pollfreq ) {         
        
                this.id = id; 
                this.userName = username;
                this.challngeType = type;
                this.enableQRCode = qrcode;
                this.enableAutoVerify = autoverify;
                this.challngeExpiry = expiry;
                this.status = status;
                this.profile = authz;
                this.profileName = custom;
                this.ipAddress = ipaddr;
                this.pollFreq = pollfreq;
        
    }
    
    
    public static class Builder {
        
        private String id;
        private String username;
        private ChallengeType challngeType;
        private boolean enableQRCode;    
        private boolean enableAutoVerify;
        private Expiry challngeExpiry;
        private Status status;
        private Profile profile;
        private String profileName;
        private String ipAddress;
        private int pollFreq;

        public Builder withId( String  id ){
            this.id = id;
            return this;
        }
        
        public Builder forUser( String u ){
            this.username = u;
            return this;
        }
        
        public Builder challengeType( ChallengeType  t ){
            this.challngeType = t;
            return this;
        }
        
        
         public Builder enableQRcode( boolean t ){
            this.enableQRCode = t;
            return this;
        }
        
        
        public Builder enableAutoVerify( boolean v ){
            this.enableAutoVerify = v;
            return this;
        } 
        
         
        public Builder withExpiry( Expiry mins ){
            this.challngeExpiry = mins;
            return this;
        } 
        
    
        public Builder withStatus( Status status ){
            this.status = status;
            return this;
        }
        
        public Builder withProfile( Profile a ){
            this.profile = a;
            return this;
        }
        
        public Builder withProfileName( String n ){
            this.profileName = n;
            return this;
        }
        
         public Builder withIPAddress( String i ){
            this.ipAddress = i;
            return this;
        }
         
        
         public Builder withPollFreq( int i ){
            this.pollFreq = i;
            return this;
        }
         
        
        public ChallengeRequest build(){
            return new ChallengeRequest( 
                    ( this.id == null ) 
                            ? "" : this.id,                    
                    (this.username == null) 
                            ? "": this.username , 
                    (this.challngeType == null )
                            ? ChallengeType.None : this.challngeType ,                            
                     this.enableQRCode , 
                    this.enableAutoVerify, 
                    (this.challngeExpiry == null )
                            ? Expiry.ThreeMins 
                            : this.challngeExpiry ,
                    (this.status == null ) 
                            ? Status.NEW : this.status ,
                    (this.profile == null)
                        ? Profile.NONE 
                        : this.profile,
                    (this.profileName == null)
                        ? "" 
                        : this.profileName,
                    (this.ipAddress == null)
                        ? "" 
                        : this.ipAddress,
                    (this.pollFreq == 0)
                        ? 3000 
                        : this.pollFreq
                    
                    
            );
            
            
        }       
    }

    public String getId() {
        return id;
    }
    
    public String getUserName() {
        return userName;
    }

    public ChallengeType getChallngeType() {
        return challngeType;
    }

    public boolean isEnableQRCode() {
        return enableQRCode;
    }

    public boolean isEnableAutoVerify() {
        return enableAutoVerify;
    }

    public Expiry getChallngeExpiry() {
        return challngeExpiry;
    }

    public Status getStatus() {
        return status;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    
     public int getPollFreq() {
        return pollFreq;
    }
    
    
    
    
    
     public String toJson(){

        StringBuilder sb = new StringBuilder();
        
        if( status.equals( Status.NEW ) ){            
            sb.append("{");
            sb.append(" 'gridyUser': ").append("'").append(   this.userName  ).append("'").append(",");
            sb.append(" 'ipAddress': ").append("'").append(   this.ipAddress ).append("'").append(",");            
            sb.append(" 'challengeType': ").append("'").append( this.challngeType.name() ).append("'").append(",");
            sb.append(" 'challengeExpiry': ").append("'").append( this.challngeExpiry.name()  ).append("'").append(",");
            sb.append(" 'enableQRCode': ").append("'").append( this.enableQRCode ).append("'").append(",");
            sb.append(" 'enableAutoVerify': ").append("'").append( this.enableAutoVerify ).append("'").append(","); 
            sb.append(" 'profile': ").append("'").append( this.profile.name() ).append("'").append(",");         
            sb.append(" 'status': ").append("'").append( this.status.name() ).append("'");           
            sb.append(" }");
        }
        
 
        if( status.equals( Status.CANCEL ) ){
            sb.append("{");
            sb.append(" 'challengeId': ").append("'").append(   ( this.id == null ) ? "" : this.id  ).append("'").append(",");
            sb.append(" 'gridyUser': ").append("'").append(   this.userName  ).append("'").append(",");
            sb.append(" 'status': ").append("'").append( this.status.name() ).append("'");  
            sb.append(" }");
        }
        
        
        return sb.toString();
        
    }
    
    
    
    
}
