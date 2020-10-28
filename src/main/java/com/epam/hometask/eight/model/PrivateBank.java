package com.epam.hometask.eight.model;

import com.epam.hometask.eight.enam.DepositType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "private-bank")

public class PrivateBank extends AbstractBank {

    @XmlElement(name = "bank-owner", namespace = "http://www.example.com/banks", required = true)
    private String bankOwner;

    public PrivateBank() {
    }

    public PrivateBank(String id, String name,DepositType type, Deposit deposit, String bankOwner) {
        super(id, name, deposit, type);
        this.bankOwner = bankOwner;
    }

    public String getBankOwner() {
        return bankOwner;
    }

    public void setBankOwner(String bankOwner) {
        this.bankOwner = bankOwner;
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
        PrivateBank that = (PrivateBank) o;
        return Objects.equals(bankOwner, that.bankOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bankOwner);
    }

    @Override
    public String toString() {
        return "PrivateBank{" +
                "bankOwner='" + bankOwner + '\'' +
                '}';
    }
}
