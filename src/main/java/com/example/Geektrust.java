package com.example;

import com.example.universe.Kingdom;
import com.example.universe.Universe;
import com.example.universe.UniverseCrown;
import com.example.util.FileUtil;

import java.util.List;

public class Geektrust
{
   Universe universeSoutheros;
   UniverseCrown goldenCrown;

   static String[] Kingdoms = {"space","land","water","ice","air","fire"};
   static String[] Kingdoms_emblems = {"gorilla","panda","octopus","mammoth","owl","dragon"};
   static String kingToBeRuler = "space";

    public static void main(String args[]) throws Exception {

        Geektrust _geektrust = new Geektrust();
        _geektrust.initSoutheros();
        _geektrust.goldenCrown = new UniverseCrown(_geektrust.universeSoutheros.getKingdom(kingToBeRuler));

        String _filePath = args[0];
        List<String> messages = new FileUtil().readFile(_filePath);

        _geektrust.goldenCrown.startWar(messages);

        _geektrust.printOutput(_geektrust.goldenCrown.isKingTheRuler());
    }

    private void printOutput(int isKingTheRuler) {
        if(isKingTheRuler == 1) {
            System.out.print(kingToBeRuler.toUpperCase() + " ");
            universeSoutheros.getKingdom(kingToBeRuler).getSupportedKingdoms().stream().forEach(k -> System.out.print(k.toUpperCase() + " "));
            System.out.println();
        }
        else
            System.out.println("NONE");
    }

    private void initSoutheros() {
        Universe.name = "Southeros";
        universeSoutheros = Universe.getInstance();

        for(int i = 0; i < Kingdoms.length; i++)
            universeSoutheros.registerKingdom(new Kingdom(Kingdoms[i],Kingdoms_emblems[i]));
    }
}
