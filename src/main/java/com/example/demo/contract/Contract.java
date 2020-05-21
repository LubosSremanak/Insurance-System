package com.example.demo.contract;


import com.example.demo.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public abstract class Contract {

    @Min(0)
    protected double monthlyPayment, indemnity;
    protected long contractNumber;
    protected User insurer;// nezadávam ale nastavujem aktualny dátum preto chyba validácia

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    protected LocalDate formation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    protected LocalDate beginInsurance, endInsurance;

    public Contract() {

    }

    public Contract(long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getIndemnity() {
        return indemnity;
    }

    public void setIndemnity(double indemnity) {
        this.indemnity = indemnity;
    }

    public User getInsurer() {
        return insurer;
    }

    public void setInsurer(User insurer) {
        isNull(insurer, "Not null");
        this.insurer = insurer;
    }

    public LocalDate getFormation() {
        return formation;
    }

    public void setFormation(LocalDate formation) {
        isNull(formation, "Not null");
        if (beginInsurance != null && formation.isAfter(beginInsurance))
            throw new IllegalArgumentException("Formation date must be smaller or same as begin insurance date !");
        this.formation = formation;
    }

    public LocalDate getBeginInsurance() {
        return beginInsurance;
    }

    public void setBeginInsurance(LocalDate beginInsurance) {
        isNull(beginInsurance, "Not null");
        if (endInsurance != null && beginInsurance.isAfter(endInsurance) || beginInsurance.equals(endInsurance))
            throw new IllegalArgumentException("Begin insurance date must be smaller as end insurance date !");
        this.beginInsurance = beginInsurance;
    }

    public LocalDate getEndInsurance() {
        return endInsurance;
    }

    public void setEndInsurance(LocalDate endInsurance) {
        isNull(endInsurance, "Not null");
        if (beginInsurance != null && !endInsurance.isAfter(beginInsurance))
            throw new IllegalArgumentException("End insurance date must be smaller as begin insurance date !");
        this.endInsurance = endInsurance;
    }

    public String getName() {
        return "";
    }

    public void copy(Contract contract) {
        contractNumber = contract.getContractNumber();
        indemnity = contract.getIndemnity();
        monthlyPayment = contract.getMonthlyPayment();
        insurer = contract.getInsurer();
        beginInsurance = contract.getBeginInsurance();
        endInsurance = contract.getEndInsurance();
    }

    @Override
    public String toString() {
        return "Contract{" +
                "indemnity=" + indemnity +
                ", monthlyPayment=" + monthlyPayment +
                ", contractNumber='" + contractNumber + '\'' +
                ", insurer=" + insurer.getIdentification().getLastName() +
                ", formation=" + formation +
                ", beginInsurance=" + beginInsurance +
                ", endInsurance=" + endInsurance +
                '}';
    }

    protected void isNull(Object object, String exception) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException(exception);
        }

    }
}
