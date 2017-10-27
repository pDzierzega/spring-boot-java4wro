package com.github.xenteros.service;

import com.github.xenteros.model.WordEntry;

import java.util.List;

public interface WordEntryService {

    List<WordEntry> findAll();
    void addWord(String word);
}
