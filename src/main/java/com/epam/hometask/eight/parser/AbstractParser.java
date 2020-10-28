package com.epam.hometask.eight.parser;

import com.epam.hometask.eight.exception.ParserException;
import com.epam.hometask.eight.model.AbstractBank;
import com.epam.hometask.eight.model.CentralBank;
import com.epam.hometask.eight.model.PrivateBank;
import com.epam.hometask.eight.model.StateBank;

import java.util.List;

public abstract class AbstractParser {

    public final static String STATE_BANK = "state-bank";
    public final static String PRIVATE_BANK = "private-bank";
    public final static String CENTRAL_BANK = "central-bank";

    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String DEPOSIT_TYPE = "deposit-type";
    public final static String DEPOSITOR = "depositor";
    public final static String DEPOSIT = "deposit";
    public final static String ACCOUNT_ID = "account-id";
    public final static String TIME_CONSTRAINTS = "time-constraints";
    public final static String PERSENTAGE_TYPE = "persentage-type";
    public final static String BANK_OWNER = "bank-owner";
    public final static String COUNTRY = "country";
    public final static String RIGHTS = "rights";

    public abstract List<AbstractBank> parse(String file) throws ParserException;

    public static AbstractBank createBank(String key) {
        AbstractBank bank;
        switch (key) {
            case STATE_BANK:
                bank = new StateBank();
                break;
            case PRIVATE_BANK:
                bank = new PrivateBank();
                break;
            case CENTRAL_BANK:
                bank = new CentralBank();
                break;
            default:
                throw new IllegalArgumentException(String.format("Not exist element %s", key));
        }
        return bank;
    }



}
