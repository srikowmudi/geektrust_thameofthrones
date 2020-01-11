package com.example.universe;

import java.util.List;

public class UniverseCrown {
    Universe universe;
    Kingdom toBeRuler;
    WarProtocol warProtocol;

    public UniverseCrown(Kingdom toBeRuler) {
        this.universe = Universe.getInstance();
        this.toBeRuler = toBeRuler;
    }

    public void startWar(List<String> messages) {
        try {
            for (String msg : messages) {
                String[] msgInput = msg.split(" ", 2);
                warProtocol = new WarProtocol(toBeRuler, universe.getKingdom(msgInput[0]));
                warProtocol.execute(msgInput[1]);
            }
        }
        catch(Exception e){
            System.out.println("Exception in SoutherosCrown startWar "+e.getMessage());
        }
    }
    public int isKingTheRuler() {
        if(toBeRuler.getSupportedKingdoms().size() >= 3)
            return 1;
        return 0;
    }
}
