package com.mercadolivre.codigomorse.dtos;

public class ResponseDTO {
    private String decodedMorse;

    public ResponseDTO() {
    }

    public ResponseDTO(String decodeMorse) {
        this.decodedMorse = decodeMorse;
    }

    public String getDecodedMorse() {
        return decodedMorse;
    }

    public void setDecodedMorse(String decodedMorse) {
        this.decodedMorse = decodedMorse;
    }
}
