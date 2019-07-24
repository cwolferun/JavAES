package com.blacknall.JavAES.controller;

import com.blacknall.JavAES.model.Postcard;
import com.blacknall.JavAES.service.CardService;
import com.blacknall.JavAES.util.EncryptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.crypto.KeyGenerator;
import javax.validation.Valid;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CardService cardService;
    private static Key key;

    @PostConstruct
    public void init() throws Exception{
        key = KeyGenerator.getInstance("AES").generateKey();
    }
    @PostMapping("/postcard")
    public String sendCard(@RequestBody @Valid Postcard postcard) {
        return cardService.saveCard(postcard);
    }

    @PostMapping("/postcard2")
    public Postcard sendCard2(@RequestBody @Valid Postcard postcard) {

        postcard.setMessage(Base64.getEncoder().encodeToString((EncryptionUtil.encrypt(postcard.getMessage(),key))));
        return postcard;
    }

    @PostMapping("/postcard3")
    public Postcard sendCard3(@RequestBody @Valid Postcard postcard) {

        postcard.setMessage(String.valueOf((EncryptionUtil.decrypt(Base64.getDecoder().decode(postcard.getMessage()),key))));
        return postcard;
    }



}
