package com.example.universe;

import com.example.util.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import java.util.List;

public class TestSoutherosCrown {
    @Spy
    Universe southeros;

    FileUtil fileUtil = new FileUtil();

    static String[] Kingdoms = {"space","land","water","ice","air","fire"};
    static String[] Kingdoms_emblems = {"gorilla","panda","octopus","mammoth","owl","dragon"};

    private void initSoutheros() {
        southeros = Universe.getInstance();

        for(int i = 0; i < Kingdoms.length; i++)
            southeros.registerKingdom(new Kingdom(Kingdoms[i],Kingdoms_emblems[i]));
    }

    @Test
    public void startWarTest() throws Exception {
        List<String> messages = fileUtil.readFile("src/test/resources/sample1.txt");
        initSoutheros();
        UniverseCrown crown = Mockito.spy(new UniverseCrown(southeros.getKingdom("space")));
        crown.startWar(messages);
        int output = crown.isKingTheRuler();
        verify(crown,times(1)).isKingTheRuler();
        Assertions.assertEquals(1,output);
    }
}
