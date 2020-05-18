package Factory;

import BankOffices.AbstractBankOffice;
import BankOffices.TBCBankOffice;
import Banks.AbstactBank;
import Banks.TBCBank;

public class TBCBankFactory extends AbstractFactory{
    @Override
    AbstactBank createBank() {
        return new TBCBank();
    }

    @Override
    AbstractBankOffice createBankOffice() {
        return new TBCBankOffice();
    }
}
