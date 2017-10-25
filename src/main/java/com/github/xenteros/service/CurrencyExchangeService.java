package com.github.xenteros.service;

import com.github.xenteros.dto.CurrencyExchangeResultDto;
import com.github.xenteros.model.CurrencyExchangeEntry;

import java.util.List;

public interface CurrencyExchangeService {

    List<CurrencyExchangeEntry> getAll();
    CurrencyExchangeResultDto getExchangeRate(String from, String to, String amount);
}
