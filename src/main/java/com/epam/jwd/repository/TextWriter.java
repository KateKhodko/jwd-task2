package com.epam.jwd.repository;

import com.epam.jwd.model.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextWriter {

    private static final String DIR_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "output";
    public static final String TEXT_FILENAME = "text.txt";

    public void writeData(Text text, String filename) throws IOException {
        Path directory = Paths.get(DIR_PATH);
        if (!Files.isDirectory(directory)) {
            Files.createDirectory(directory);
        }

        String textStr = text.getText();
        if (!textStr.isEmpty()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DIR_PATH + File.separator + filename));
            writer.write(textStr);
            writer.close();
        }
    }
}
