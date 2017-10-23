package com.github.xenteros.controller;

import com.github.xenteros.dto.CurrencyExchangeResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/currency-exchange")
public class CurrencyExchangeController {

    @GetMapping("eur-to-pln/{eur}")
    public CurrencyExchangeResultDto eurToPln(@PathVariable String eur) {

        CurrencyExchangeResultDto result = new CurrencyExchangeResultDto();
        result.setFrom("EUR");
        result.setTo("PLN");
        BigDecimal fromValue = new BigDecimal(eur);
        BigDecimal toValue = fromValue.multiply(new BigDecimal("4.223265"));

        result.setFromValue(fromValue);
        result.setResult(toValue);

        return result;

    }

}
