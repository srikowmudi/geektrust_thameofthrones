package com.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileUtil
{
    public List<String> readFile(String filePath) throws Exception {

        List<String> lines = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (Stream<String> stream = Files.lines( path )) {
            lines = stream.map(line->line.toLowerCase()).collect(Collectors.toList());
//            lines.forEach(System.out::println);
        }
        catch (IOException e) {
            System.out.println("Exception in readFile "+e.getMessage());
            throw new IOException("IOException encountered");
        }
        return lines;
    }
}
