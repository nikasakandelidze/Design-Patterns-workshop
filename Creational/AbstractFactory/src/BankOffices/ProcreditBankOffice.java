package BankOffices;

public class ProcreditBankOffice extends AbstractBankOffice {

    private String location = "Procredit Bank location";

    @Override
    String bankLocation() {
        return location;
    }
}
