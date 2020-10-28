package com.epam.hometask.eight.model;

import com.epam.hometask.eight.enam.PersentageType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deposit")
public class Deposit {

    @XmlElement(name = "depositor", namespace = "http://www.example.com/banks", required = true)
    private String depositor;
    @XmlElement(name = "account-id", namespace = "http://www.example.com/banks", required = true)
    private String accountId;
    @XmlElement(name = "time-constraints", namespace = "http://www.example.com/banks", required = true)
    private String timeConstraints;
    @XmlElement(name = "persentage-type", namespace = "http://www.example.com/banks", required = true)
    private PersentageType persentageType;

    public Deposit() {
    }

    public Deposit(String depositor, String accountId, String timeConstraints, PersentageType persentageType) {
        this.depositor = depositor;
        this.accountId = accountId;
        this.timeConstraints = timeConstraints;
        this.persentageType = persentageType;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(String timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    public PersentageType getPersentageType() {
        return persentageType;
    }

    public void setPersentageType(PersentageType persentageType) {
        this.persentageType = persentageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Deposit deposit = (Deposit) o;
        return Objects.equals(depositor, deposit.depositor) &&
                Objects.equals(accountId, deposit.accountId) &&
                Objects.equals(timeConstraints, deposit.timeConstraints) &&
                Objects.equals(persentageType, deposit.persentageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depositor, accountId, timeConstraints, persentageType);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "depositor='" + depositor + '\'' +
                ", accountId='" + accountId + '\'' +
                ", timeConstraints='" + timeConstraints + '\'' +
                ", persentageType='" + persentageType + '\'' +
                '}';
    }
}
