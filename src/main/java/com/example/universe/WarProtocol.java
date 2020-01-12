package com.example.universe;

import com.example.util.HashUtil;
import com.example.util.MessageUtil;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class WarProtocol implements IWarProtocol {
    Kingdom warInitiator;
    Kingdom warFighter;

    public WarProtocol(Kingdom warInitiator,Kingdom warFighter) {
        this.warInitiator = warInitiator;
        this.warFighter = warFighter;
    }
    public void execute(String message) {
        try{
            String decryptedMsg = decryptMessage(message);
            int victory = isEmblemInMsg(decryptedMsg);
            recordVictoryStatus(victory);
        }
        catch(Exception e){
            System.out.println("Exception in warprotocol execute "+e.getMessage());
        }
    }
    @Override
    public String decryptMessage(String message) {
        try{
            int chipherKey =  warFighter.getEmblem().length();
            return new MessageUtil().decryptMessage(message,chipherKey);
        }
        catch(Exception e){
            System.out.println("Exception in warprotocol decryptMessage "+e.getMessage());
            return null;
        }
    }

    @Override
    public int isEmblemInMsg(String message) {
        {
            try {
                HashMap<Character, Integer> decreyptedMsgHash = new HashUtil().formCharCountHash(message);
                HashMap<Character, Integer> warFighterEmblemHash = new HashUtil().formCharCountHash(warFighter.getEmblem());

                for (char key : warFighterEmblemHash.keySet()) {
                    if (!decreyptedMsgHash.containsKey(key) || decreyptedMsgHash.get(key) < warFighterEmblemHash.get(key))
                        return 0;
                }
                return 1;
            }
            catch(Exception e){
                System.out.println("Exception in warprotocol isEmblemInMsg "+e.getMessage());
                return 0;
            }
        }
    }

    @Override
    public void recordVictoryStatus(int victory) {
        try {
            if (victory == 1) {
                LinkedHashSet<String> kingdoms = warInitiator.getSupportedKingdoms();
                if (kingdoms == null)
                    kingdoms = new LinkedHashSet<>();
                kingdoms.add(warFighter.getName());
                warInitiator.setSupportedKingdoms(kingdoms);
            }
        }
        catch(Exception e){
            System.out.println("Exception in warprotocol recordVictoryStatus "+e.getMessage());
        }
    }
}
