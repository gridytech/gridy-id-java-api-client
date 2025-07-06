
package io.gridy.client.model;

import java.io.Serializable;

/**
 *
 *   
 * @author gridy.io
 */
public class BlockedRequest implements Cloneable, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final String userName;
    private final String ipv4Address;
    private final boolean useSSE;
    
    public BlockedRequest( final String username, final String ip   ) {         
       
        this.userName = username;
        this.ipv4Address = ip;
        this.useSSE = false;
        
    }
    
    
    public static class Builder {
        
        private String ipv4Address;
        private String username;
       
        public Builder withIPv4Address( String  ipaddr ){
            this.ipv4Address = ipaddr;
            return this;
        }
        
        public Builder forUser( String u ){
            this.username = u;
            return this;
        }
        
        
        public BlockedRequest build(){
            return new BlockedRequest( 
                 this.username,
                 this.ipv4Address
            );
        }       
    }
    
    
    public String getUserName() {
        return userName;
    }

    public String getIpv4Address() {
        return ipv4Address;
    }
    
    
    public boolean isUseSSE() {
        return useSSE;
    }
    
    
     public String toJson(){

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(" 'ipAddress': ").append("'").append(   ( this.ipv4Address == null ) ? "" : this.ipv4Address  ).append("'").append(",");
        sb.append(" 'gridyUser': ").append("'").append(  (this.userName == null) ? "" : this.userName ).append("'").append(",");
        sb.append(" }");
        
        return sb.toString();    
    }
    
    
    
    
}
