package com.epam.hometask.eight.parser.SAX;

import com.epam.hometask.eight.enam.DepositType;
import com.epam.hometask.eight.enam.PersentageType;
import com.epam.hometask.eight.model.*;
import com.epam.hometask.eight.parser.AbstractParser;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epam.hometask.eight.parser.AbstractParser.*;


public class BanksHandler extends DefaultHandler {

    private final static List<String> FIELD_VALUES = Arrays.asList(
            DEPOSIT_TYPE, DEPOSITOR, ACCOUNT_ID, DEPOSIT,
            TIME_CONSTRAINTS, PERSENTAGE_TYPE, BANK_OWNER, COUNTRY, RIGHTS);

    private final List<AbstractBank> banks = new ArrayList<>();

    private AbstractBank bank = null;
    private String currentField = null;
    private Deposit deposit = null;

    public BanksHandler() {
    }

    public List<AbstractBank> getBanks() {
        return banks;
    }

    //-----------------

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (STATE_BANK.equals(localName) || PRIVATE_BANK.equals(localName) || CENTRAL_BANK.equals(localName)) {
            bank = AbstractParser.createBank(localName);
            String id = attributes.getValue(ID);
            bank.setId(id);
            bank.setDeposit(deposit);
            if (attributes.getLength() == 2) {
                String name = attributes.getValue(NAME);
                bank.setName(name);
            }
        } else if (FIELD_VALUES.contains(localName)) {
            currentField = localName;

            if (DEPOSIT.equals(currentField)) {
                deposit = new Deposit();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (STATE_BANK.equals(localName) || PRIVATE_BANK.equals(localName) || CENTRAL_BANK.equals(localName)) {
            banks.add(bank);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        String value = new String(ch, start, length);
        value = value.trim();

        if (currentField != null) {
            switch (currentField) {
                case DEPOSIT_TYPE:
                    DepositType type = DepositType.valueOf(value);
                    bank.setType(type);
                    break;

                case DEPOSITOR:
                    deposit.setDepositor(value);
                    break;
                case ACCOUNT_ID:
                    deposit.setAccountId(value);
                    break;
                case TIME_CONSTRAINTS:
                    deposit.setTimeConstraints(value);
                    break;
                case PERSENTAGE_TYPE:
                    PersentageType persentageType = PersentageType.valueOf(value);
                    deposit.setPersentageType(persentageType);
                    break;

                case BANK_OWNER:
                    ((PrivateBank)bank).setBankOwner(value);
                    break;
                case COUNTRY:
                    ((StateBank)bank).setCountry(value);
                    break;
                case RIGHTS:
                    ((CentralBank)bank).setRigths(value);
                    break;
                case DEPOSIT:
                    if (bank instanceof PrivateBank) {
                        ((PrivateBank)bank).setDeposit(deposit);
                    }
                    if (bank instanceof StateBank) {
                        ((StateBank)bank).setDeposit(deposit);
                    }
                    if (bank instanceof CentralBank) {
                        ((CentralBank)bank).setDeposit(deposit);
                    }
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Field %s not exist in sequence", currentField));
            }
            currentField = null;
        }
    }
}
