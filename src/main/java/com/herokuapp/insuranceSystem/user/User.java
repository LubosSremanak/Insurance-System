package com.herokuapp.insuranceSystem.user;

import com.herokuapp.insuranceSystem.contract.Contract;
import com.herokuapp.insuranceSystem.user.personalInformation.Contact;
import com.herokuapp.insuranceSystem.user.personalInformation.Identification;
import com.herokuapp.insuranceSystem.user.personalInformation.Address;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class User {


    private long id;
    private Identification identification;
    private Contact contact;
    @NotNull
    private Address address;
    private Address correspondenceAddress;
    private List<Contract> contracts;


    public User() {
        this.contracts = new ArrayList<>();
    }

    public User(long id) {
        this.id = id;
        this.contracts = new ArrayList<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        isNull(identification, "Not null");
        this.identification = identification;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        isNull(contact, "Not null");
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        isNull(address, "Not null");
        this.address = address;
    }

    public Address getCorrespondenceAddress() {

        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(Address correspondenceAddress) {
        isNull(correspondenceAddress, "Not null");

        try {
            correspondenceAddress.isEverythingSet();
            this.correspondenceAddress = correspondenceAddress;
        } catch (NullPointerException e) {
            try {
                address.isEverythingSet();
                this.correspondenceAddress = new Address(this.address);
            } catch (NullPointerException e1) {
                this.correspondenceAddress = correspondenceAddress;
            }
        }

    }

    public void createContract(Contract contract) {
        isNull(contract, "Not null");
        this.contracts.add(contract);
    }

    public void addContract(Contract contract) {
        isNull(contract, "Not null");
        this.contracts.add(contract);
    }

    public Contract getContractByContractNumber(long contractNumber) {
        for (Contract wantedContract : this.contracts) {
            if (wantedContract.getContractNumber() == contractNumber) {
                return wantedContract;
            }

        }
        throw new NullPointerException();
    }

    public List<Contract> getContracts() {
        return contracts;
    }


    public void setContracts(List<Contract> contracts) {
        isNull(contracts, "Not null");
        this.contracts = contracts;
    }

    public String contractsToString() {
        String contracts = "";
        for (Contract wantedContract : this.contracts) {
            contracts += wantedContract;
        }
        return contracts;
    }

    public void isEverythingSet() {
        //isNull(this.id, "Not null");
        isNull(this.contact, "Contact not null");
        //isNull(this.contracts, "Not null");
        isNull(this.address, "Address not null");
        isNull(this.correspondenceAddress, "Correspondence address not null");
        isNull(this.identification, "Identification not null");
    }

    public void copy(User copyUser) {
        setId(copyUser.getId());
        setIdentification(copyUser.getIdentification());
        setContact(copyUser.getContact());
        setAddress(copyUser.getAddress());
        setCorrespondenceAddress(copyUser.getCorrespondenceAddress());


    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", identification=" + identification +
                ", contact=" + contact +
                ", address=" + address +
                ", correspondenceAddress=" + correspondenceAddress +
                ", contracts=" + contractsToString() +
                '}';
    }

    private void isNull(Object object, String exception) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException(exception);
        }

    }

}
