package com.github.xenteros.controller;

import com.github.xenteros.dto.CurrencyExchangeResultDto;
import com.github.xenteros.dto.FixerResponseDto;
import com.github.xenteros.model.CurrencyExchangeEntry;
import com.github.xenteros.repositories.CurrencyExchangeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeEntryRepository currencyExchangeEntryRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PutMapping
    public CurrencyExchangeEntry addCurrencyExchangeEntry(@RequestBody CurrencyExchangeEntry currencyExchangeEntry) {
        return currencyExchangeEntryRepository.save(currencyExchangeEntry);
    }

    @GetMapping("/{cur1}/{amount}/{cur2}")
    public CurrencyExchangeResultDto exchangeCurrencies(@PathVariable String cur1, @PathVariable String amount, @PathVariable String cur2){

        CurrencyExchangeResultDto result = new CurrencyExchangeResultDto();
        result.setFrom(cur1);
        result.setTo(cur2);
        BigDecimal fromValue = new BigDecimal(amount);
        result.setFromValue(fromValue);
        FixerResponseDto response = restTemplate.getForEntity("http://api.fixer.io/latest?symbols="+cur1+","+cur2, FixerResponseDto.class).getBody();

        BigDecimal divider = new BigDecimal(response.getRates().get(cur2)).divide(new BigDecimal(response.getRates().get(cur1)),5);

        BigDecimal toValue = fromValue.multiply(divider);
        result.setResult(toValue);
        return result;




    }
}
