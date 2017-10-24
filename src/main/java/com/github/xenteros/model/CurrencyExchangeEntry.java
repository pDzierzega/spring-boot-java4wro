package com.github.xenteros.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class CurrencyExchangeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "curremcy_from", nullable = false)
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal valueFrom;
    private BigDecimal valueTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(BigDecimal valueFrom) {
        this.valueFrom = valueFrom;
    }

    public BigDecimal getValueTo() {
        return valueTo;
    }

    public void setValueTo(BigDecimal valueTo) {
        this.valueTo = valueTo;
    }
}
