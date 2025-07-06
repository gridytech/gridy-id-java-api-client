

package io.gridy.utils;

import io.gridy.client.model.ModelApiResponse;



/**
 *
 * @author admin
 */
public interface VerifyListener {
    

    void onVerified( ModelApiResponse r );
    void onPending( );
    void onExpired( ModelApiResponse r );    
    void onRejected( ModelApiResponse r );    
    void onError( int code );

}


