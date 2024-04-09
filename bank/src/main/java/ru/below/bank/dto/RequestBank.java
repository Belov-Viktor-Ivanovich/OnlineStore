package ru.below.bank.dto;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
public class RequestBank {
    private String account_number;
    private int rub;
    private int kop;
    private String name;
}
