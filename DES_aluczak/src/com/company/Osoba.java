package com.company;

public class Osoba {
    private String imie;
    private Integer wiek;
    public Osoba(String imie, Integer wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Integer getWiek() {
        return wiek;
    }
}
