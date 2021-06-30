package com.mercadolivre.codigomorse.controllers;

import com.mercadolivre.codigomorse.dtos.RequestDTO;
import com.mercadolivre.codigomorse.dtos.ResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/morse")
public interface MorseController {

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @RequestMapping("/decode")
    @ResponseBody
    public ResponseDTO decodeMorse(@RequestBody RequestDTO morse);
}
