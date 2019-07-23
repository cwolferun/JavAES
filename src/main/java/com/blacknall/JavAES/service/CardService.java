package com.blacknall.JavAES.service;

import com.blacknall.JavAES.model.Postcard;
import com.blacknall.JavAES.repository.CardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepo cardRepo;

    public String saveCard(Postcard postcard) {
        return cardRepo.save(postcard).getId().toString();
    }
}
