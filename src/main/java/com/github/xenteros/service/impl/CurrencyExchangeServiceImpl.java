package com.github.xenteros.service.impl;

import com.github.xenteros.dto.CurrencyExchangeResultDto;
import com.github.xenteros.dto.FixerResponseDto;
import com.github.xenteros.model.CurrencyExchangeEntry;
import com.github.xenteros.repositories.CurrencyExchangeEntryRepository;
import com.github.xenteros.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeEntryRepository currencyExchangeEntryRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CurrencyExchangeEntry> getAll() {
        return currencyExchangeEntryRepository.findAll();
    }

    @Override
    public CurrencyExchangeResultDto getExchangeRate(String from, String to, String amount) {
        CurrencyExchangeResultDto result = new CurrencyExchangeResultDto();
        result.setFrom(from);
        result.setTo(to);
        BigDecimal fromValue = new BigDecimal(amount);
        result.setFromValue(fromValue);
        FixerResponseDto response = restTemplate.getForEntity("http://api.fixer.io/latest?symbols="+from+","+to, FixerResponseDto.class).getBody();

        BigDecimal divider = new BigDecimal(response.getRates().get(to)).divide(new BigDecimal(response.getRates().get(from)),5);

        BigDecimal toValue = fromValue.multiply(divider);
        result.setResult(toValue);

        CurrencyExchangeEntry currencyExchangeEntry = new CurrencyExchangeEntry();
        currencyExchangeEntry.setCurrencyFrom(from);
        currencyExchangeEntry.setCurrencyTo(to);
        currencyExchangeEntry.setValueFrom(fromValue);
        currencyExchangeEntry.setValueTo(toValue);
        currencyExchangeEntry.setExchangeRate(divider);

        currencyExchangeEntryRepository.save(currencyExchangeEntry);

        return result;
    }


    @Override
    public Page <CurrencyExchangeEntry> getPage(Pageable page){
        return currencyExchangeEntryRepository.findAll(page);
    }

}
