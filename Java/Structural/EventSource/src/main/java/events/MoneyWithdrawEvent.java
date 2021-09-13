package events;

import entities.Account;
import InMemoryStorage.AccountsStorage;

import java.math.BigDecimal;
import java.util.Optional;

public class MoneyWithdrawEvent extends Event {
    private final BigDecimal money;
    private final int accountId;

    public MoneyWithdrawEvent(int eventId, long eventCreationTime, String eventClassName, int accountId,
            BigDecimal money) {
        super(eventId, eventCreationTime, eventClassName);
        this.accountId = accountId;
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public void process() {
        Account accountById = Optional.ofNullable(AccountsStorage.getAccountById(accountId + ""))
                                        .orElseThrow(()->new RuntimeException("No such account find"));
        accountById.handleMoneyWithdraw(this);
    }
}
