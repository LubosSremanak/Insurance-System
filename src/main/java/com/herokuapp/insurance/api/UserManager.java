package com.herokuapp.insurance.api;


import com.herokuapp.insurance.contract.Contract;
import com.herokuapp.insurance.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@Service
public class UserManager {

    private Map<Long, User> users;
    private Map<Long, Contract> contracts;

    public UserManager() {
        this.users = new TreeMap<Long, User>();
        this.contracts = new TreeMap<Long, Contract>();
    }

    public void addUser(User user) {
        user.isEverythingSet();
        users.put(user.getId(), user);
    }

    public User editUser(long id) {
        users.get(id).isEverythingSet();
        return users.get(id);
    }

    public void deleteUser(long id) {
        this.users.remove(id);

    }

    public void deleteContract(long contractid) {
        this.contracts.remove(contractid);

    }

    public Map<Long, Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Map<Long, Contract> contracts) {
        this.contracts = contracts;
    }

    private User getUser(long id) {
        return users.get(id);
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    public void printUser(long id) {
        System.out.println(getUser(id));
    }

    public void createContract(long userId, Contract contract) {
        contracts.put(contract.getContractNumber(), contract);
        editUser(userId).createContract(contract);
    }

    public Contract getContract(long contractNumber) {
        return this.contracts.get(contractNumber);
    }

    public Contract editContract(long userId, long contractNumber) {
        return getUser(userId).getContractByContractNumber(contractNumber);
    }

    public List<Contract> getContracts(long id) {
        return getUser(id).getContracts();
    }


}