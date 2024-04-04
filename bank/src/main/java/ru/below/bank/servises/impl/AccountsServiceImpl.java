package ru.below.bank.servises.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.below.bank.entities.Accounts;
import ru.below.bank.repositories.AccountsRepositories;
import ru.below.bank.servises.AccountsService;
@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {
    private final AccountsRepositories repositories;

    @Override
    public Accounts createAccounts(Accounts accounts) {
        return null;
    }

    @Override
    public Accounts getAccountsById(Long id) {
        return null;
    }

    @Override
    public Accounts updateAccounts(Accounts supply) {
        return null;
    }

    @Override
    public void deleteAccountsById(Long id) {

    }

    @Override
    public Accounts addMoney(Long id) {
        return null;
    }

    @Override
    public Accounts takeMoney(Long id) {
        return null;
    }
}
