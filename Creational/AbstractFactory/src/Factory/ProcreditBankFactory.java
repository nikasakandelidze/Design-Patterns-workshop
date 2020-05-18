package Factory;

import BankOffices.AbstractBankOffice;
import BankOffices.ProcreditBankOffice;
import Banks.AbstactBank;
import Banks.ProcreditBank;

public class ProcreditBankFactory extends AbstractFactory{
    @Override
    AbstactBank createBank() {
        return new ProcreditBank();
    }

    @Override
    AbstractBankOffice createBankOffice() {
        return new ProcreditBankOffice();
    }
}
