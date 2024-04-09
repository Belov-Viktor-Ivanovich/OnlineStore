package ru.below.bank.servises.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.below.bank.dto.RequestBank;
import ru.below.bank.entities.Accounts;
import ru.below.bank.repositories.AccountsRepositories;
import ru.below.bank.servises.AccountsService;
@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {
    private final AccountsRepositories repositories;

    @Override
    public Accounts createAccounts(Accounts accounts) {
        return repositories.save(accounts);
    }

    @Override
    public Accounts getAccountsById(Long id) {
        return repositories.getById(id);
    }

    @Override
    public Accounts updateAccounts(Accounts accounts) {

        return repositories.save(accounts);
    }

    @Override
    public void deleteAccountsById(Long id) {
        repositories.deleteById(id);

    }

    @Override
    public Accounts changeMoney(Accounts accounts) {
        return repositories.save(accounts);
    }

}
