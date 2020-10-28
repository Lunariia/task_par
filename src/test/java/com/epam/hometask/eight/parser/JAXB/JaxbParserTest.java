package com.epam.hometask.eight.parser.JAXB;

import com.epam.hometask.eight.parser.AbstractParser;
import com.epam.hometask.eight.parser.AbstractParserTest;

public class JaxbParserTest extends AbstractParserTest {

    @Override
    public AbstractParser createParser() {
        return new JaxbParser();
    }
}
