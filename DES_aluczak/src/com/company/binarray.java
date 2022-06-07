package com.company;

public class binarray {
    char znak;

    public void setZnak(char znak) {
        this.znak = znak;
    }

    public String getBin(int dlugosc){
        int zamiana = (int)this.znak;
        char zero = '0';
        StringBuilder jedynkowa = new StringBuilder(Integer.toBinaryString(zamiana));

        while(jedynkowa.length() < dlugosc){
            jedynkowa.insert(0, zero);
        }
        return jedynkowa.toString();
    }
}
