package com.company;

public class leftShift {
    String klucz;

    public leftShift() {
    }

    public void setKlucz(String klucz) {
        this.klucz = klucz;
    }

    public String getKlucz() {
        return klucz;
    }

    public void getShiftedKey(Integer shiftNumber){
        StringBuilder newKlucz = new StringBuilder();
        newKlucz.setLength(this.klucz.length());

        for(int j = 0; j < shiftNumber; j++){
            for(int i = 0; i < this.klucz.length() - 1; i++){
                newKlucz.setCharAt(i, this.klucz.charAt(i+1));
            }
            newKlucz.setCharAt(this.klucz.length() - 1, this.klucz.charAt(0));
            setKlucz(newKlucz.toString());
        }
    }
}
