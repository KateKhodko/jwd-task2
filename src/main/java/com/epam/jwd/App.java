package com.epam.jwd;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.Text;
import com.epam.jwd.parser.ParserChain;
import com.epam.jwd.repository.TextReader;
import com.epam.jwd.repository.TextWriter;
import com.epam.jwd.sort.SortStrategy;
import com.epam.jwd.sort.SortType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public void start() throws IOException, ParseException {
        List<String> lines = readText();
        Text text = parseText(lines);
        writeText(text, TextWriter.TEXT_FILENAME);
        Text sortedText = sortText(text, SortType.PARAGRAPHS_BY_COUNT_SENTENCES);
        LOGGER.info("text sorted");
        System.out.println(sortedText.getText());
    }

    public List<String> readText() throws IOException {
        TextReader textReader = new TextReader();
        return textReader.read();
    }

    private Text parseText(List<String> lines) throws ParseException {
        Text text = new Text();
        String[] textStr = new String[lines.size()];
        lines.toArray(textStr);
        ParserChain.instance.parse(text, textStr);
        return text;
    }

    private void writeText(Text text, String filename) throws IOException {
        TextWriter textWriter = new TextWriter();
        textWriter.writeData(text, filename);
    }

    private Text sortText(Text text, SortType sortType) {
        return SortStrategy.getInstance().sort(text, sortType);
    }
}
