package com.blacknall.JavAES.controller;

import com.blacknall.JavAES.model.Postcard;
import com.blacknall.JavAES.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CardService cardService;

    @PostMapping("/postcard")
    public String sendCard(@RequestBody @Valid Postcard postcard) {
        return cardService.saveCard(postcard);
    }
}
