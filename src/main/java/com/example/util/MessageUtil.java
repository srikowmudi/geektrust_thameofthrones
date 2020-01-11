package com.example.util;

public class MessageUtil
{
    public String decryptMessage( String msg, int cipherKey) {
        StringBuilder decreptedMsg = new StringBuilder();
        try{
            for(char c : msg.toCharArray()) {
                int decryptedVal = c - cipherKey;
                int ranOverVal;
                if(decryptedVal > (int)('z')){ // char val exceeds 'z' ascii value
                    ranOverVal = decryptedVal - (int)'z'; decryptedVal = (int)'a' + (ranOverVal - 1);
                }
                else if(decryptedVal < (int)'a') {  // char val exceeds 'a' ascii value in circular pattern
                    ranOverVal = (int)'a' - decryptedVal; decryptedVal = (int)'z' - (ranOverVal - 1);
                }
                decreptedMsg.append((char)decryptedVal);
            }
        }
        catch(Exception e) {
            System.out.println("Exception in decryptMsg "+e.getMessage());
        }
        return decreptedMsg.toString();
    }
}
