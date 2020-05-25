package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private Collection<SavingAccount> accounts = new ArrayList<>(); //TODO

    public Client(UUID id, String name) {
        if (id == null) throw new IllegalArgumentException("Creation with NULL ID");
        if (name == null) throw new IllegalArgumentException("Creation (id="+ id + ") with NULL Name");

        this.id = id;
        this.name = name;
    }

    public void createAccount(UUID id, double amount) {
        accounts.add(new SavingAccount(id, this, amount));
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<SavingAccount> getAccounts() {
        return accounts;
    }
}
