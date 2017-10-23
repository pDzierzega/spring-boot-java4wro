package com.github.xenteros.dto;

import java.math.BigDecimal;

public class CurrencyExchangeResultDto {

    private String from;
    private BigDecimal fromValue;
    private String to;
    private BigDecimal result;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public BigDecimal getFromValue() {
        return fromValue;
    }

    public void setFromValue(BigDecimal fromValue) {
        this.fromValue = fromValue;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
