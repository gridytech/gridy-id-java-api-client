

package io.gridy.utils;

import io.gridy.client.model.ModelApiResponse;



/**
 *
 * @author gridy.io
 */
public interface AutoVerifyListener {
    
    void onChallenge( ModelApiResponse r );
    void onChallengeError( int code );
    
    void onVerified( ModelApiResponse r );
    void onPending( );
    void onExpired( ModelApiResponse r );    
    void onRejected( ModelApiResponse r );    
    void onError( int code );

}


