package InMemoryStorage;


import entities.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
    Accounts map holder class.
    This class holds the state of all the accounts
 */
public class AccountsStorage {
    private static Map<String, Account> accounts = new HashMap<>();

    /*
        So no one can mess with creating instances of it.
     */
    private AccountsStorage(){
    }

    public static void putAccount(Account account){
        accounts.put(account.getId(), account);
    }

    public static Account getAccountById(String accountId){
        return Optional.of(accountId)
                .map(accounts::get)
                .map(Account::copy)
                .orElse(null);
    }

    public static void resetState(){
        accounts.clear();
    }
}
