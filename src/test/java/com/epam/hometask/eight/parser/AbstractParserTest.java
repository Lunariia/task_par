package com.epam.hometask.eight.parser;

import com.epam.hometask.eight.enam.DepositType;
import com.epam.hometask.eight.enam.PersentageType;
import com.epam.hometask.eight.exception.ParserException;
import com.epam.hometask.eight.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParserTest {

    private final static String XML = "BanksXML.xml";
    private final static String XML_INVALID = "BankIncorrectXML.xml";

    private final static List<AbstractBank> EXPECTED_BANKS = Arrays.asList(
            new PrivateBank("ID-1","BelVeb",DepositType.SAVING,
            new Deposit("Mr.Poul","42302","365", PersentageType.YEAR),"VebCompany"),
            new PrivateBank("ID-2","TechnoBank",DepositType.DEMAND,
            new Deposit("Mr.Steve","42303","91", PersentageType.MONTH),"Techno"),
            new StateBank("ID-3","BelarusBank",DepositType.METAL,
            new Deposit("Person","42304","14", PersentageType.DAY),"Belarus"),
            new StateBank("ID-4","WelfareBank",DepositType.URGENT,
            new Deposit("Mr.Mark","42303","92", PersentageType.MONTH),"Belarus"),
            new CentralBank("ID-5","CentralBank",DepositType.SAVING,
            new Deposit("Person","42304","14", PersentageType.DAY),"Money"),
            new CentralBank("ID-6","CentralTmpBank",DepositType.URGENT,
            new Deposit("Mr.Mark","42303","92", PersentageType.MONTH),"Money")
    );

    @Test
    public void testParseShouldReturnListWhenDataIsCorrect() throws ParserException {
        //when
        AbstractParser parser = createParser();
        List<AbstractBank> currentBank = parser.parse(XML);
        //then
        Assert.assertEquals(EXPECTED_BANKS, currentBank);
    }

    @Test(expected = ParserException.class)//then
    public void testParseShouldReturnExceptionWhenFileNotExist() throws ParserException {
        //when
        AbstractParser parser = createParser();
        parser.parse(XML_INVALID);
    }

    public abstract AbstractParser createParser();
}
