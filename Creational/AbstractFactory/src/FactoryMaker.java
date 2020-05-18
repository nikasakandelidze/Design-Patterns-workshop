import Factory.AbstractFactory;
import Factory.ProcreditBankFactory;
import Factory.TBCBankFactory;

public class FactoryMaker {

    public static AbstractFactory factoryMaker(String factoryName){
        switch(factoryName){
            case "TBC":
                return new TBCBankFactory();

            case "Procredit":
                return new ProcreditBankFactory();
            default:
                throw new IllegalArgumentException("No factory named "+factoryName);
        }
    }
}
