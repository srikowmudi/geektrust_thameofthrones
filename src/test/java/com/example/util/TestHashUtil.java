package com.example.util;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;


public class TestHashUtil {

    HashUtil _hashUtil;

    HashMap<Character,Integer> testObj = new HashMap<>();
    @Test
    public void formCharCountHashTest() {
        testObj.put('h',1);
        testObj.put('i',2);

        _hashUtil = new HashUtil();
        HashMap<Character,Integer> output = _hashUtil.formCharCountHash("hii");
        System.out.println(output.size());
        Assertions.assertEquals(testObj,output);

    }

}
