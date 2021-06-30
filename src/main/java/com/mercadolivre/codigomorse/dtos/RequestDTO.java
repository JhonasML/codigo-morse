package com.mercadolivre.codigomorse.dtos;

public class RequestDTO {
    private String morse;

    public RequestDTO(String morse) {
        this.morse = morse;
    }

    public RequestDTO() {
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }
}
