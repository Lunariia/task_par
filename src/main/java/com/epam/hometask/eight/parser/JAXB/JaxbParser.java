package com.epam.hometask.eight.parser.JAXB;

import com.epam.hometask.eight.exception.ParserException;
import com.epam.hometask.eight.model.AbstractBank;
import com.epam.hometask.eight.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JaxbParser extends AbstractParser {

    private final static Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    @Override
    public List<AbstractBank> parse(String file) throws ParserException {
        FileReader reader = null;

        try {

            JAXBContext context = JAXBContext.newInstance(Banks.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new FileReader(file);
            Banks banks = (Banks) unmarshaller.unmarshal(reader);
            return banks.getBanks();

        } catch (JAXBException | FileNotFoundException e) {
            throw new ParserException(e.getMessage(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}
