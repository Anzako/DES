package com.company;

public class Shrink {
    String permutedSubkey = "";

    int[][] sblok1 = {
            {14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
            {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
            {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}
        };

    int[][] sblok2 = {
            {15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
            {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
            {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}
    };

    public Shrink() {
    }

    public void setPermutedSubkey(String subkey) {
        this.permutedSubkey = subkey;
    }

    public String getPermutedSubkey() {
        return permutedSubkey;
    }

    public String getShrinked() {
        String result = "";
        String bloczek;
        int poczatek = 0;
        String kolumna;
        StringBuilder wiersz = new StringBuilder();
        int wartosc;
        binarray konwerter = new binarray();

        for(int i = 0; i < 8; i++) {
            wiersz.setLength(0);
            bloczek = this.permutedSubkey.substring(poczatek, poczatek+6);
            poczatek += 6;

            wiersz.append(bloczek.charAt(0));
            wiersz.append(bloczek.charAt(5));
            kolumna = bloczek.substring(1, 5);


            wartosc = sblok1[Integer.parseInt(wiersz.toString(),2)][Integer.parseInt(kolumna,2)];
            konwerter.setZnak((char)wartosc);
            System.out.println(Integer.parseInt(wiersz.toString(),2));
            System.out.println(Integer.parseInt(kolumna,2));
            result += (konwerter.getBin(4));
        }
        return result;
    }


}
