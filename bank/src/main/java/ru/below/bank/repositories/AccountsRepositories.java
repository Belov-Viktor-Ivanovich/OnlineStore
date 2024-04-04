package ru.below.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.below.bank.entities.Accounts;

public interface AccountsRepositories extends JpaRepository<Accounts,Long> {
}
