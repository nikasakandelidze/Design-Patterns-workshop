package entities;

import events.AccountCreateEvent;
import events.MoneyDepositEvent;
import events.MoneyWithdrawEvent;
import InMemoryStorage.AccountsStorage;

import java.math.BigDecimal;

/**
    Base entity, for this project of EventSourcing.
 */
public class Account {
    private String id;
    private String ownerName;
    private BigDecimal money;

    public Account(String id, String ownerName, BigDecimal money) {
        this.id = id;
        this.ownerName = ownerName;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", money=" + money +
                '}';
    }

    public Account copy() {
        var money = new BigDecimal(this.money.intValue());
        return new Account(this.id, this.ownerName, money);
    }

    public void handleAccountCreation(AccountCreateEvent createEvent){
        AccountsStorage.putAccount(this);
        System.out.println(String.format("Event number: %d processed",createEvent.getEventId()));
    }

    public void handleMoneyDeposit(MoneyDepositEvent event){
        this.money.add(event.getMoney());
    }

    public void handleMoneyWithdraw(MoneyWithdrawEvent event){
        this.money.subtract(event.getMoney());
    }
}
