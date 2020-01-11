package com.example.universe;

import java.util.Set;

public class Kingdom {

    private String name;
    private String emblem;
    private Set<String> supportedKingdoms;


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

    public Set<String> getSupportedKingdoms() {
        return supportedKingdoms;
    }

    public void setSupportedKingdoms(Set<String> supportedKingdoms) {
        this.supportedKingdoms = supportedKingdoms;
    }
}
