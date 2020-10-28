package com.epam.hometask.eight.parser.SAX;

import com.epam.hometask.eight.exception.ParserException;
import com.epam.hometask.eight.model.AbstractBank;
import com.epam.hometask.eight.parser.AbstractParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser extends AbstractParser {

    @Override
    public List<AbstractBank> parse(String file) throws ParserException {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            BanksHandler handler = new BanksHandler();
            reader.setContentHandler(handler);
            reader.parse(file);

            return handler.getBanks();
            
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new ParserException(e.getMessage(), e);
        }
    }
}
