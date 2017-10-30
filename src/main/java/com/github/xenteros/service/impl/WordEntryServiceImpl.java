package com.github.xenteros.service.impl;

import com.github.xenteros.model.User;
import com.github.xenteros.model.WordEntry;
import com.github.xenteros.repositories.UserRepository;
import com.github.xenteros.repositories.WordEntryRepository;
import com.github.xenteros.service.WordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WordEntryServiceImpl implements WordEntryService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WordEntryRepository wordEntryRepository;

    @Override
    public void addWord(String word) {
        WordEntry wordEntry = new WordEntry();
        wordEntry.setWord(word);
        wordEntry.setDateTime(LocalDateTime.now());

        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = userRepository.findOneByUsername(userDetails.getUsername());
        wordEntry.setAuthor(user);

        wordEntryRepository.save(wordEntry);
    }

    @Override
    public List<WordEntry> findAll() {
        return wordEntryRepository.findAll();
    }
}
