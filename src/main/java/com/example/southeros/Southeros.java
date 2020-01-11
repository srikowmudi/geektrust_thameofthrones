package com.example.southeros;

import java.util.HashMap;
import java.util.Map;

public class Southeros {

    private static Southeros instance = null;

    Map<String, Kingdom> southerosKingdoms = new HashMap();

    private Southeros(){
    }

    public static Southeros getInstance(){
        if (instance == null)
            instance = new Southeros();
        return instance;
    }

    public void registerKingdom(Kingdom kingdom) {
        southerosKingdoms.put(kingdom.getName(), kingdom);
    }

    public Kingdom getKingdom(String kingdomName) {
        return southerosKingdoms.get(kingdomName);
    }

    public int getKingdomCount() {
        return southerosKingdoms.size();
    }

    public void deleteKingdom(String kingdomName) {
        southerosKingdoms.remove(kingdomName);
    }

}
