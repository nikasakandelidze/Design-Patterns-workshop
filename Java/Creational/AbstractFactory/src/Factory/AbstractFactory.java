package Factory;

import BankOffices.AbstractBankOffice;
import Banks.AbstactBank;

public abstract class AbstractFactory {

    abstract AbstactBank createBank();

    abstract AbstractBankOffice createBankOffice();
}
