package com.finance.api.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financeiro")
public class Finance extends BaseEntity{

    @Column(name = "data_referencia")
    private LocalDate referenceDate;

    @Column(name = "saldo_anterior")
    private BigDecimal previousBalance;

    @Column(name = "salario")
    private BigDecimal salary;

    @Column(name = "outras_entradas")
    private BigDecimal otherEntries;
}
