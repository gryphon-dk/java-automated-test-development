package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {
    UUID dummyId;
    Client dummyClient;
    double dummyAmount;

    @Before
    public void initDummies() {
        dummyId = UUID.randomUUID();
        dummyClient =  new Client(UUID.randomUUID(), "dummy client name");
        dummyAmount = 12.23;
    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        UUID stubId = UUID.randomUUID();
        UUID stubClientId = UUID.randomUUID();
        Client stubClient =  new Client(stubClientId, "dummy client name");
        double stubAmount = 12.23;

        SavingAccount sut = new SavingAccount(stubId, stubClient, stubAmount);

        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));

        assertThat(sut.getClient(),
                allOf(
                        equalTo(stubClient),
                        notNullValue()
                ));

        assertThat(sut.getAmount(),
                allOf(
                        equalTo(stubAmount),
                        notNullValue()
                ));

        assertThat(sut.getClientId(),
                allOf(
                        equalTo(stubClientId),
                        notNullValue()
                ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetErrorWhenCreatedWithNullId() {
        new SavingAccount(null, dummyClient, dummyAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetErrorWhenCreatedWithNullClient() {
        new SavingAccount(dummyId, null, dummyAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetErrorWhenCreatedWithLessThanZeroAmount() {
        new SavingAccount(dummyId, dummyClient, -1);
    }
}
