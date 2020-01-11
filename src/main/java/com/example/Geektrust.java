package com.example;

import com.example.southeros.Kingdom;
import com.example.southeros.Southeros;
import com.example.southeros.SoutherosCrown;
import com.example.util.FileUtil;

import java.util.List;

public class Geektrust
{
   Southeros southeros;
   SoutherosCrown goldenCrown;

   static String[] Kingdoms = {"space","land","water","ice","air","fire"};
   static String[] Kingdoms_emblems = {"gorilla","panda","octopus","mammoth","owl","dragon"};
   static String kingToBeRuler = "space";

    public static void main(String args[]) throws Exception {

        Geektrust _geektrust = new Geektrust();
        _geektrust.initSoutheros();
        _geektrust.goldenCrown = new SoutherosCrown(_geektrust.southeros.getKingdom(kingToBeRuler));

        String _filePath = args[0];
        List<String> messages = new FileUtil().readFile(_filePath);

        _geektrust.goldenCrown.startWar(messages);

        _geektrust.printOutput(_geektrust.goldenCrown.isKingTheRuler());
    }

    private void printOutput(int isKingTheRuler) {
        if(isKingTheRuler == 1) {
            System.out.print(kingToBeRuler.toUpperCase() + " ");
            southeros.getKingdom(kingToBeRuler).getSupportedKingdoms().stream().forEach(k -> System.out.print(k.toUpperCase() + " "));
            System.out.println();
        }
        else
            System.out.println("NONE");
    }

    private void initSoutheros() {
        southeros = Southeros.getInstance();

        for(int i = 0; i < Kingdoms.length; i++)
            southeros.registerKingdom(new Kingdom(Kingdoms[i],Kingdoms_emblems[i]));
    }
}
