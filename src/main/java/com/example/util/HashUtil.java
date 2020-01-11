package com.example.util;

import java.util.HashMap;

public class HashUtil
{
    public HashMap<Character, Integer> formCharCountHash(String text) {
            HashMap<Character, Integer> hash = new HashMap<>();
            try {
                for(char c:text.toLowerCase().toCharArray()) {
                    if(hash.containsKey(c))
                        hash.put(c,hash.get(c)+1);
                    else
                        hash.put(c,1);
                }
            }
            catch(Exception e) {
                System.out.println("Exception e in formCharCountHash "+e.getMessage());
            }
            return hash;
        }
}
