package ru.below.bank.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.below.bank.dto.RequestBank;
import ru.below.bank.entities.Accounts;
import ru.below.bank.entities.Balance;
import ru.below.bank.repositories.AccountsRepositories;
import ru.below.bank.servises.AccountsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountsController {
    private final AccountsService accountsService;

    @GetMapping("/{id}")
    public Accounts findById(@PathVariable Long id) {
        return accountsService.getAccountsById(id);
    }
    @PostMapping
    public Accounts create(@RequestBody Accounts accounts) {
        return accountsService.createAccounts(accounts);
    }
    @PutMapping
    public Accounts update(@RequestBody RequestBank requestBank) {
        Accounts accounts = accountsRepositories.findByAccountNumber(requestBank.getAccount_number());
        accounts.setName(requestBank.getName());
        if(accounts.getBalance()==null)
            accounts.setBalance(new Balance());
        accounts.getBalance().setKop(requestBank.getKop());
        accounts.getBalance().setRub(requestBank.getRub());
        return accountsService.updateAccounts(accounts);
    }

    @PutMapping("/changeMoney")
    public Accounts changeMoney(@RequestBody RequestBank requestBank) {
        Accounts accounts = accountsRepositories.findByAccountNumber(requestBank.getAccount_number());
        accounts.setName(requestBank.getName());
        if(accounts.getBalance()==null)
            accounts.setBalance(new Balance());
        accounts.getBalance().setKop(requestBank.getKop());
        accounts.getBalance().setRub(requestBank.getRub());
        return accountsService.changeMoney(accounts);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountsService.deleteAccountsById(id);
    }
}
