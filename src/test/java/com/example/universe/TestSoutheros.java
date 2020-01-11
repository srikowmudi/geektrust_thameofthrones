package com.example.universe;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.*;

public class TestSoutheros {

    static Universe southeros;
    static String[] Kingdoms = {"space","land","water","ice","air","fire"};
    static String[] Kingdoms_emblems = {"gorilla","panda","octopus","mammoth","owl","dragon"};

    private static void initSoutheros() {
        southeros = Universe.getInstance();

        for(int i = 0; i < Kingdoms.length; i++)
            southeros.registerKingdom(new Kingdom(Kingdoms[i],Kingdoms_emblems[i]));
    }

    @BeforeAll
    public static void init() {
        initSoutheros();
    }
    @Test
    public void registerKingdomTest() {
        Assertions.assertEquals(6,southeros.getKingdomCount());
    }
    @Test
    public void getKingdomTest() {
        Assertions.assertTrue(southeros.kingdoms.containsKey("space") && southeros.kingdoms.get("space") != null);
    }



}
