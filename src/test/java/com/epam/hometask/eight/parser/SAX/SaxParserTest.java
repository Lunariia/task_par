package com.epam.hometask.eight.parser.SAX;

import com.epam.hometask.eight.parser.AbstractParser;
import com.epam.hometask.eight.parser.AbstractParserTest;

public class SaxParserTest extends AbstractParserTest {

    @Override
    public AbstractParser createParser() {
        return new SaxParser();
    }
}
