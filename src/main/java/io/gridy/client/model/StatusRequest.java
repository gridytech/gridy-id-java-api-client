
package io.gridy.client.model;

import java.io.Serializable;

/**
 *   
 * @author gridy.io
 */
public class StatusRequest implements Cloneable, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final String challngeId;
    private final String userName;
    
    private final boolean useSSE;
    
    public StatusRequest( final String id, final String username   ) {         
        this.challngeId = id; 
        this.userName = username;
        this.useSSE = false;
        
    }
    
    
    public static class Builder {
        
        private String id;
        private String username;
       
        public Builder withId( String  id ){
            this.id = id;
            return this;
        }
        
        public Builder forUser( String u ){
            this.username = u;
            return this;
        }
        
        
        public StatusRequest build(){
            return new StatusRequest( 
                 this.id,
                 this.username
            );
        }       
    }
    

    public String getChallngeId() {
        return challngeId;
    }
    
    public String getUserName() {
        return userName;
    }


    public boolean isUseSSE() {
        return useSSE;
    }
    
    
     public String toJson(){

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(" 'challngeId': ").append("'").append(   ( this.challngeId == null ) ? "" : this.challngeId  ).append("'").append(",");
        sb.append(" 'gridyUser': ").append("'").append(    (this.userName==null) ? "" : this.userName ).append("'").append(",");
        sb.append(" }");
        
        return sb.toString();    
    }
    
    
    
    
}
