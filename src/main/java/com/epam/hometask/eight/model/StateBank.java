package com.epam.hometask.eight.model;

import com.epam.hometask.eight.enam.DepositType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "state-bank")

public class StateBank extends AbstractBank {

    @XmlElement(name = "country", namespace = "http://www.example.com/banks", required = true)
    private String country;


    public StateBank() {
    }

    public StateBank(String id, String name,DepositType type, Deposit deposit, String country) {
        super(id, name, deposit, type);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) return false;
        StateBank stateBank = (StateBank) o;
        return Objects.equals(country, stateBank.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country);
    }

    @Override
    public String toString() {
        return "StateBank{" +
                "country='" + country + '\'' +
                '}';
    }
}
