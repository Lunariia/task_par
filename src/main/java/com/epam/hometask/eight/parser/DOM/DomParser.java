package com.epam.hometask.eight.parser.DOM;

import com.epam.hometask.eight.enam.DepositType;
import com.epam.hometask.eight.enam.PersentageType;
import com.epam.hometask.eight.exception.ParserException;
import com.epam.hometask.eight.model.*;
import com.epam.hometask.eight.parser.AbstractParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser extends AbstractParser {

    public DomParser() {
    }


    @Override
    public List<AbstractBank> parse(String file) throws ParserException {
        List<AbstractBank> banks = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element root = document.getDocumentElement();

            NodeList bankNodes = root.getChildNodes();
            for (int i = 0; i < bankNodes.getLength(); i++) {
                if (bankNodes.item(i) instanceof Element) {
                    Element bankElement = (Element) bankNodes.item(i);
                    AbstractBank bank = buildBank(bankElement);
                    banks.add(bank);
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            throw new ParserException(e.getMessage(), e);
        }
        return banks;
    }

    private AbstractBank buildBank(Element bankElement) {

        String bankName = bankElement.getNodeName();
        AbstractBank bank = AbstractParser.createBank(bankName);
        String id = bankElement.getAttribute(ID);
        bank.setId(id);
        String name = bankElement.getAttribute(NAME);
        if (name != null) {
            bank.setName(name);
        }
        bank.setType(DepositType.valueOf(getElementContent(bankElement, DEPOSIT_TYPE)));

        String depositor = getElementContent(bankElement, DEPOSITOR);
        String accountID = getElementContent(bankElement, ACCOUNT_ID);
        String timeConstraints = getElementContent(bankElement, TIME_CONSTRAINTS);
        PersentageType type = PersentageType.valueOf(getElementContent(bankElement, PERSENTAGE_TYPE));

        bank.setDeposit(new Deposit(depositor,accountID,timeConstraints,type));

        if (STATE_BANK.equals(bankName)) {
            buildStateBank(bankElement, (StateBank) bank);
        } else if (PRIVATE_BANK.equals(bankName)) {
            buildPrivateBank(bankElement, (PrivateBank) bank);
        } else if (CENTRAL_BANK.equals(bankName)) {
            buildCentralBank(bankElement, (CentralBank) bank);
        }
        return bank;
    }

    private String getElementContent(Element element, String elementName) {
        NodeList nodes = element.getElementsByTagName(elementName);
        Node node = nodes.item(0);
        return node.getTextContent();
    }

    private void buildStateBank(Element bankElement, StateBank bank) {
        String content = getElementContent(bankElement, COUNTRY);
        bank.setCountry(content);
    }

    private void buildPrivateBank(Element bankElement, PrivateBank bank) {
        String content = getElementContent(bankElement, BANK_OWNER);
        bank.setBankOwner(content);
    }

    private void buildCentralBank(Element bankElement, CentralBank bank) {
        String content = getElementContent(bankElement, RIGHTS);
        bank.setRigths(content);
    }


}
