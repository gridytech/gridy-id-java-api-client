
package io.gridy.client.model;

 /* 
 * 
 * @author gridy.io
 */
public enum ChallengeType { 
            None,
            UserKey, 
            UserKeyAndPattern, 
            UserKeyPatternAndPin, 
            UserKeyAndUserPin,
            UserKeyAndUserFace,
            UserKeyAndUserVoice,
            UserKeyAndTOTP,
            TOTP
}
