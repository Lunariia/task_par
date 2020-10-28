package com.epam.hometask.eight.model;

import com.epam.hometask.eight.enam.DepositType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "central-bank")

public class CentralBank extends AbstractBank {

    @XmlElement(name = "rights", namespace = "http://www.example.com/banks", required = true)
    private String rights;

    public CentralBank() {
    }

    public CentralBank(String id, String name, DepositType type, Deposit deposit, String rigths) {
        super(id, name, deposit, type);
        this.rights = rigths;
    }

    public void setRigths(String rigths) {
        this.rights = rigths;
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
        CentralBank that = (CentralBank) o;
        return Objects.equals(rights, that.rights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rights);
    }

    @Override
    public String toString() {
        return "CentralBank{" +
                "rigths='" + rights + '\'' +
                '}';
    }
}
