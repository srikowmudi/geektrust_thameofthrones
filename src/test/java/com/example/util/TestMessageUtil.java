package com.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMessageUtil {

    MessageUtil _message = new MessageUtil();
    @ParameterizedTest
    @CsvSource({ "FDIXXSOKKOFBBMU,5,aydssnjffjawwhp", "MOMAMVTMTMHTM,7,fhftfomfmfamf", "SUMMER IS COMING,7,lnffxk3bl3vhfbgz" })
    public void decryptMessageTest(String msg, int key, String res) {
        String output = _message.decryptMessage(msg.toLowerCase(), key);
        System.out.println(output);
        Assertions.assertEquals(res,output);

    }
}
