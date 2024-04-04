package ru.below.bank.servises;

import ru.below.bank.entities.Accounts;

public interface AccountsService {

    Accounts createAccounts(Accounts accounts);
    Accounts getAccountsById(Long id);
    Accounts updateAccounts(Accounts supply);
    void deleteAccountsById(Long id);
    Accounts addMoney(Long id);
    Accounts takeMoney(Long id);
}
