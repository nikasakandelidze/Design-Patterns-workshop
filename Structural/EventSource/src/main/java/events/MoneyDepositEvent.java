package events;

import InMemoryStorage.AccountsStorage;

import java.math.BigDecimal;
import java.util.Optional;

public class MoneyDepositEvent extends Event {
    private BigDecimal money;
    private int accountNo;

    public MoneyDepositEvent(int eventId, long eventCreationTime, String eventClassName, int accountNo,
            BigDecimal money) {
        super(eventId, eventCreationTime, eventClassName);
        this.accountNo = accountNo;
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }


    public int getAccountNo() {
        return accountNo;
    }

    @Override
    public void process() {
        var account = Optional.ofNullable(AccountsStorage.getAccountById(accountNo + ""))
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.handleMoneyDeposit(this);
    }
}
