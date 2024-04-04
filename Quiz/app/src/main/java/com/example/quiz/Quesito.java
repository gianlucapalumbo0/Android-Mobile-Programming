package com.example.quiz;

public class Quesito {
    private String domanda;
    private boolean risposta;
    private boolean counted;
    private boolean suggerito;

    public Quesito(String domanda, boolean risposta, boolean counted, boolean suggerito) {
        this.domanda = domanda;
        this.risposta = risposta;
        this.counted = counted;
        this.suggerito = suggerito;
    }

    public String getDomanda() {
        return domanda;
    }

    public boolean Risposta() {
        return risposta;
    }

    public boolean isCounted() {
        return counted;
    }

    public boolean isSuggerito() {
        return suggerito;
    }

    public void setCounted(boolean counted) {
        this.counted = counted;
    }

    public void setSuggerito(boolean suggerito) {
        this.suggerito = suggerito;
    }
}
