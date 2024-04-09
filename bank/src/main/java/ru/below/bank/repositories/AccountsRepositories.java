package ru.below.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.below.bank.entities.Accounts;
@Repository
public interface AccountsRepositories extends JpaRepository<Accounts,Long> {
    Accounts findByAccountNumber(String accountNumber);
}
