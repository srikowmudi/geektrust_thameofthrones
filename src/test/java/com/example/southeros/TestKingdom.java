package com.example.southeros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Spy;


public class TestKingdom {
    @Spy
    Kingdom kingdom;

    @Test
    public void getKingdomTest()
    {
        kingdom = new Kingdom("space","gorilla");
        Assertions.assertEquals("space",kingdom.getName());
        Assertions.assertEquals("gorilla",kingdom.getEmblem());
    }
}
