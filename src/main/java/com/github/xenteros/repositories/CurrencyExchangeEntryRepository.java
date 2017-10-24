package com.github.xenteros.repositories;

import com.github.xenteros.model.CurrencyExchangeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeEntryRepository extends JpaRepository<CurrencyExchangeEntry, Long>{

}
