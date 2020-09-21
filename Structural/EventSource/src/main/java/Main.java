import events.AccountCreateEvent;
import events.MoneyDepositEvent;
import events.MoneyWithdrawEvent;
import processors.DomainEventProcessor;
import InMemoryStorage.AccountsStorage;

import java.math.BigDecimal;
import java.util.Date;

public class Main {
    private static int eventCounter = 1;
    private static int accountsCounter = 1;

    public static void main(String[] args) {

        var eventProcessor = new DomainEventProcessor();

        //process new event
        eventProcessor.process(
                new AccountCreateEvent(eventCounter++, new Date().getTime(), "Account Creation",
                        accountsCounter++, "Nika"));

        //process new event
        eventProcessor.process(
                new MoneyDepositEvent(eventCounter++, new Date().getTime(), "Money withdrawal", accountsCounter,
                        BigDecimal.valueOf(1000)));

        //process new event
        eventProcessor.process(
                new MoneyWithdrawEvent(eventCounter++, new Date().getTime(), "Money withdrawal", accountsCounter,
                        BigDecimal.valueOf(100)));

        //Clear in memory state
        AccountsStorage.resetState();

        /*
            recover from persistent storage.
            This will replicate all previous steps and we will end up with same state of AccountsAggregate object.

         */
        eventProcessor.recover();

        /*
            Now if we see the state of AccountsAggregate it will be exactly the same like it was before resetState().
         */

    }
}
