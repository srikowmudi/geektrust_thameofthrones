package com.example.southeros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Spy;

public class TestIWarProtocol {
    @Spy
    Kingdom warInitiator = new Kingdom("space", "gorilla");
    @Spy
    Kingdom warFighter = new Kingdom("land", "panda");;


    IWarProtocol _interface = new WarProtocol(warInitiator,warFighter);

    @ParameterizedTest
    @CsvSource({ "FDIXXSOKKOFBBMU,aydssnjffjawwhp", "FAIJWJSOOFAMAU,avderenjjavhvp", "OFBBMUFDICCSO,jawwhpaydxxnj" })
    public void decryptMessageTest(String msg,  String res) {
        String output = _interface.decryptMessage(msg.toLowerCase());
        System.out.println(output);
        Assertions.assertEquals(res,output);
    }

    @ParameterizedTest
    @CsvSource({ "aydssnjffjawwhp,1", "avderenjjavhvp,1", "jawwhaydxxnj,0" })
    public void isEmblemInMsgTest(String message, int res)
    {
        int output = _interface.isEmblemInMsg(message.toLowerCase());
        System.out.println(output);
        Assertions.assertEquals(res,output);
    }

}
