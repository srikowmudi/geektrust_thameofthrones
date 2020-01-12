package com.example.universe;

import java.util.LinkedHashSet;

public class Kingdom {

    private String name;
    private String emblem;
    private LinkedHashSet<String> supportedKingdoms;


    public Kingdom(String kingdomName, String emblem) {
        this.name = kingdomName;
        this.emblem = emblem;
    }

    public String getName() {
        return name;
    }

    public String getEmblem() {
        return emblem;
    }

    public LinkedHashSet<String> getSupportedKingdoms() {
        return supportedKingdoms;
    }

    public void setSupportedKingdoms(LinkedHashSet<String> supportedKingdoms) {
        this.supportedKingdoms = supportedKingdoms;
    }
}
