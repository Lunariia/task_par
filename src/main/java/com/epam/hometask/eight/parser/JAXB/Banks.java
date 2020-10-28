package com.epam.hometask.eight.parser.JAXB;

import com.epam.hometask.eight.model.AbstractBank;
import com.epam.hometask.eight.model.CentralBank;
import com.epam.hometask.eight.model.PrivateBank;
import com.epam.hometask.eight.model.StateBank;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "banks", namespace = "http://www.example.com/banks")
public class Banks {

    @XmlElements({
            @XmlElement(name = "state-bank",
                    namespace = "http://www.example.com/banks",
                    type = StateBank.class),
            @XmlElement(name = "private-bank",
                    namespace = "http://www.example.com/banks",
                    type = PrivateBank.class),
            @XmlElement(name = "central-bank",
                    namespace = "http://www.example.com/banks",
                    type = CentralBank.class)})

    private List<AbstractBank> banks = new ArrayList<>();

    public Banks() {
    }

    public void addDevice(AbstractBank bank) {
        banks.add(bank);
    }

    public void setBanks(List<AbstractBank> banks) {
        this.banks = banks;
    }

    @XmlTransient
    public List<AbstractBank> getBanks() {
        return banks;
    }

    @Override
    public String toString() {
        return "Banks{" +
                "banks=" + banks +
                '}';
    }
}
