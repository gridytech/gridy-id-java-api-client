
package io.gridy.utils;

import io.gridy.client.model.ModelApiResponse;



/**
 *
 * @author admin
 */
public interface ResponseListener {
    
    void onResponse( ModelApiResponse r );
    
}


