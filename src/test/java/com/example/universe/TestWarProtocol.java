package com.example.universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Spy;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;


public class TestWarProtocol {

    @Spy
    Kingdom warInitiator = new Kingdom("space", "gorilla");
    @Spy
    Kingdom warFighter = new Kingdom("land", "panda");;

    WarProtocol _warProtocol = null;

    @ParameterizedTest
    @CsvSource({ "FDIXXSOKKOFBBMU,aydssnjffjawwhp,1", "FAIJWJSOOFAMAU,avderenjjavhvp,1"})
    public void executeTest(String msg, String decryptedMsg, int res){
        _warProtocol = Mockito.spy(new WarProtocol(warInitiator,warFighter));
        _warProtocol.execute(msg.toLowerCase());
        verify( _warProtocol,times(1)).decryptMessage(msg.toLowerCase());
        verify( _warProtocol,times(1)).isEmblemInMsg(decryptedMsg);
        verify( _warProtocol,times(1)).recordVictoryStatus(res);
        System.out.println(warInitiator.getSupportedKingdoms().size());
        Assertions.assertEquals(res, warInitiator.getSupportedKingdoms().size());
    }
}
