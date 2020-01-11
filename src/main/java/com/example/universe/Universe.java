package com.example.universe;

import java.util.HashMap;
import java.util.Map;

public class Universe {

    private static Universe instance = null;

    public static String name;
    Map<String, Kingdom> kingdoms = new HashMap();

    private Universe(){
    }

    public static Universe getInstance(){
        if (instance == null)
            instance = new Universe();
        return instance;
    }

    public void registerKingdom(Kingdom kingdom) {
        kingdoms.put(kingdom.getName(), kingdom);
    }

    public Kingdom getKingdom(String kingdomName) {
        return kingdoms.get(kingdomName);
    }

    public int getKingdomCount() {
        return kingdoms.size();
    }

    public void deleteKingdom(String kingdomName) {
        kingdoms.remove(kingdomName);
    }

}
