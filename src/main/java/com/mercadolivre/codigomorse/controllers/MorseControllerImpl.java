package com.mercadolivre.codigomorse.controllers;

import com.mercadolivre.codigomorse.dtos.RequestDTO;
import com.mercadolivre.codigomorse.dtos.ResponseDTO;
import com.mercadolivre.codigomorse.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MorseControllerImpl implements MorseController {

    private MorseService morseService;

    @Autowired
    public MorseControllerImpl(MorseService morseService) {
        this.morseService = morseService;
    }

    @Override
    public ResponseDTO decodeMorse(RequestDTO morse) {
        return morseService.decode(morse);
    }
}
