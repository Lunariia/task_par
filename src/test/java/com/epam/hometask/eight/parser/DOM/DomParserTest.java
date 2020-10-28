package com.epam.hometask.eight.parser.DOM;

import com.epam.hometask.eight.parser.AbstractParser;
import com.epam.hometask.eight.parser.AbstractParserTest;

public class DomParserTest extends AbstractParserTest {

    @Override
    public AbstractParser createParser() {
        return new DomParser();
    }
}
