package com.epam.hometask.eight.data;

import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {

    private final static String XML = "BanksXML.xml";
    private final static String XML_INVALID = "BankIncorrectXML.xml";
    private final static String XSD = "BanksXSD.xsd";

    @Test
    public void testShouldReturnTrueWhenDataValid(){
        //given
        XmlValidator validator = new XmlValidator(XSD);
        //when
        boolean actual  = validator.valid(XML);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testShouldReturnTrueWhenDataInValid(){
        //given
        XmlValidator validator = new XmlValidator(XSD);
        //when
        boolean actual  = validator.valid(XML_INVALID);
        //then
        Assert.assertFalse(actual);
    }
}
