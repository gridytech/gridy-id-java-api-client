
package io.gridy.client.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 *
 * @author gridy.io
 */

public class SysTime implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final Instant systemUtcTime;

            
    public SysTime( final Instant time ){
        this.systemUtcTime = time; 
    }

     public SysTime(  ){
        this.systemUtcTime = Instant.now();        
    }
    
    
    /* Getters */
    
    public Instant getSystemUtcTime() {
        return systemUtcTime;
    }

     public String getSystemUtcTimeStr() {
        return systemUtcTime.toString();
    }
    
    
    
    public long getSystemUtcTimeSecs() {
        return systemUtcTime.toEpochMilli()/1000;
    }
   
    public String getSystemUtcTimeSecsStr() { 
        return Long.toString( systemUtcTime.toEpochMilli()/1000 );
    }
    
    public String getSystemUtcTimeMsStr() { 
        return Long.toString( systemUtcTime.toEpochMilli() );
    }
    
    public long getSystemUtcTimeMillis() {
        return systemUtcTime.toEpochMilli();
    }
    
    public long getSystemUtcTimeMillisNow() {
        return Instant.now().toEpochMilli();
    }
    
    
    public LocalDateTime getLocalDateTime(){
        return LocalDateTime.ofInstant(this.systemUtcTime, ZoneId.of("UTC"));
    }
    
    /* Setters */

   
    
}
