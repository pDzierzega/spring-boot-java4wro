package com.github.xenteros.controller;

import com.github.xenteros.dto.CurrencyExchangeResultDto;
import com.github.xenteros.dto.FixerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("eur-to-pln/{eur}")
    public CurrencyExchangeResultDto eurToPln(@PathVariable String eur) {

        CurrencyExchangeResultDto result = new CurrencyExchangeResultDto();
        result.setFrom("EUR");
        result.setTo("PLN");
        BigDecimal fromValue = new BigDecimal(eur);

        //pobieranie kursu euro do pln
        FixerResponseDto response =
restTemplate.getForEntity("http://api.fixer.io/latest?symbols=PLN", FixerResponseDto.class).getBody();

        BigDecimal toValue = fromValue.multiply(new BigDecimal(response.getRates().get("PLN"))); //podstawiamy

        result.setFromValue(fromValue);
        result.setResult(toValue);

        return result;
    }
}
