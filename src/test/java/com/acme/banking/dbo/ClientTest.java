package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientTest {
    UUID dummyId;
    String dummyName;

    @Before
    public void initDummies() {
        dummyId = UUID.randomUUID();
        dummyName = "dummy client name";
    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();
        String stubName = "stub client name";
        //endregion

        //region when
        Client sut = new Client(stubId, stubName);
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        assertThat(sut.getName(),
                allOf(
                        equalTo(stubName),
                        notNullValue()
                ));
        //endregion
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetErrorWhenCreatedWithNullId() {
        new Client(null, dummyName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetErrorWhenCreatedWithNullName() {
        new Client(dummyId, null);
    }
}
