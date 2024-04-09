package ru.below.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Balance {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accounts_id",referencedColumnName = "id")
    private Accounts accounts;
    @Setter
    private int rub;
    @Setter
    private int kop;
}
