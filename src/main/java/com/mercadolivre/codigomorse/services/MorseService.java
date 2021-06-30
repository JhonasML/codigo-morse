package com.mercadolivre.codigomorse.services;

import com.mercadolivre.codigomorse.dtos.RequestDTO;
import com.mercadolivre.codigomorse.dtos.ResponseDTO;

public interface MorseService {
    public ResponseDTO decode(RequestDTO morse);
}
