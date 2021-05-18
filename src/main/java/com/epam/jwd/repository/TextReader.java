package com.epam.jwd.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextReader {

    private static final Logger LOGGER = LogManager.getLogger(TextReader.class);

    public final static String FILE_NAME = "test.txt";
    public final static String INPUT_DIR = "input";

    public List<String> read() throws IOException {
        return read(FILE_NAME, INPUT_DIR);
    }

    public List<String> read(String fileName, String inputDir) throws IOException {
        List<String> text = new ArrayList<>();
        try (InputStream inputStream = getFileFromResourceAsStream(inputDir + File.separator + fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.add(line);
            }
        }
        return text;
    }

    private InputStream getFileFromResourceAsStream(String path) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            LOGGER.error("file not found! " + path);
            throw new IllegalArgumentException("file not found! " + path);
        } else {
            return inputStream;
        }
    }
}
