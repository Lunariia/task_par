package com.epam.hometask.eight.model;

import com.epam.hometask.eight.enam.DepositType;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractBank")
@XmlSeeAlso({
        PrivateBank.class,
        StateBank.class,
        CentralBank.class
})

public abstract class AbstractBank {
    @XmlAttribute(required = true)
    @XmlID
    private String id;
    @XmlAttribute
    private String name;
    @XmlElement(namespace = "http://www.example.com/banks", required = true)
    private Deposit deposit;
    @XmlElement(name = "deposit-type", namespace = "http://www.example.com/banks", required = true)
    private DepositType type;

    public AbstractBank() {
    }

    public AbstractBank(String id, String name, Deposit deposit, DepositType type) {
        this.id = id;
        this.name = name;
        this.deposit = deposit;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public DepositType getType() {
        return type;
    }

    public void setType(DepositType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractBank that = (AbstractBank) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(deposit, that.deposit) &&
                type == that.type;
    }

//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
//        result = 31 * result + (type != null ? type.hashCode() : 0);
//        return result;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deposit, type);
    }

    @Override
    public String
    toString() {
        return "AbstractBank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", deposit=" + deposit +
                ", type=" + type +
                '}';
    }
}
