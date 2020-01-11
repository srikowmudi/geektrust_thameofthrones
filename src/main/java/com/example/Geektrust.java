package com.example;

import com.example.universe.Kingdom;
import com.example.universe.Universe;
import com.example.universe.UniverseCrown;
import com.example.util.FileUtil;

import java.util.List;

public class Geektrust
{
    Universe universe;
    UniverseCrown crown;

    static String universeName = "Southeros";
    static String[] Kingdoms = {"space","land","water","ice","air","fire"};
    static String[] Kingdoms_emblems = {"gorilla","panda","octopus","mammoth","owl","dragon"};
    static String kingToBeRuler = "space";

    public static void main(String args[]) throws Exception {

        Geektrust _geektrust = new Geektrust();
        _geektrust.initUniverse(universeName);
        _geektrust.crown = new UniverseCrown(_geektrust.universe.getKingdom(kingToBeRuler));

        String _filePath = args[0];
        List<String> messages = new FileUtil().readFile(_filePath);

        _geektrust.crown.startWar(messages);

        _geektrust.printOutput(_geektrust.crown.isKingTheRuler());
    }

    private void printOutput(int isKingTheRuler) {
        if(isKingTheRuler == 1) {
            System.out.print(kingToBeRuler.toUpperCase() + " ");
            universe.getKingdom(kingToBeRuler).getSupportedKingdoms().stream().forEach(k -> System.out.print(k.toUpperCase() + " "));
            System.out.println();
        }
        else
            System.out.println("NONE");
    }

    private void initUniverse(String universeName) {
        Universe.name = universeName;
        universe = Universe.getInstance();

        for(int i = 0; i < Kingdoms.length; i++)
            universe.registerKingdom(new Kingdom(Kingdoms[i],Kingdoms_emblems[i]));
    }
}
