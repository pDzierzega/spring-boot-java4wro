package com.github.xenteros.controller;

import com.github.xenteros.dto.CurrencyExchangeResultDto;
import com.github.xenteros.model.CurrencyExchangeEntry;
import com.github.xenteros.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/{cur1}/{amount}/{cur2}")
    public CurrencyExchangeResultDto exchangeCurrencies(@PathVariable String cur1, @PathVariable String amount, @PathVariable String cur2){


        return currencyExchangeService.getExchangeRate(cur1, cur2, amount);
    }
//    @RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping
    public List<CurrencyExchangeEntry> findAll(){

        return currencyExchangeService.getAll();
    }
}
