package events;

import entities.Account;
import InMemoryStorage.AccountsStorage;

import java.math.BigDecimal;

public class AccountCreateEvent extends Event {
    private int accountNumber;
    private String accountOwner;

    public AccountCreateEvent(int eventId, long eventCreationTime, String eventClassName, int accountNumber,
            String owner) {
        super(eventId, eventCreationTime, eventClassName);
        this.accountNumber = accountNumber;
        this.accountOwner = owner;
    }


    @Override
    public void process() {
        var accountById = AccountsStorage.getAccountById(accountNumber + "");
        if (accountById == null) {
            Account newAccount = new Account(accountNumber + "", accountOwner, BigDecimal.ZERO);
            newAccount.handleAccountCreation(this);
        } else {
            throw new RuntimeException("Account already exists");
        }
    }
}
