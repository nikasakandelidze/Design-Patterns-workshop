package BankOffices;

public class TBCBankOffice extends AbstractBankOffice {
    private String location = "TBC Bank Location";

    @Override
    String bankLocation() {
        return location;
    }
}
