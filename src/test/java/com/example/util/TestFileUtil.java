package com.example.util;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestFileUtil {

    FileUtil _fileUtil = new FileUtil();
    @Test
    public void readFileTest() throws Exception {
      List<String> res = new ArrayList<>();
      res.add("air rozo");
      res.add("air rozo");
      res.add("air rozo");
      List<String> output =  _fileUtil.readFile("src/test/resources/sample.txt");
      Assertions.assertEquals(res,output);
    }

    @Test
    void readFileTestException() {

        Assertions.assertThrows(IOException.class, () -> {
            _fileUtil.readFile("src/test/resources/sample2.txt");
        });

    }
}
