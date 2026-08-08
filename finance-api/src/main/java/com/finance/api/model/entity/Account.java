package com.finance.api.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Column(name = "NAME", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "BALANCE", nullable = false, precision = 10, scale = 2)
    private BigDecimal balance;

}
