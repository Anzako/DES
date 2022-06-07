package com.company;

public class Xor {
    String right = "";
    String subkey = "";

    public Xor(String right, String subkey) {
        this.right = right;
        this.subkey = subkey;
    }

    public String getRight() {
        return right;
    }

    public String getSubkey() {
        return subkey;
    }

    public String result() {
        StringBuilder wynik = new StringBuilder();
        for(int i = 0; i < this.right.length(); i++) {
            if (this.right.charAt(i) == this.subkey.charAt(i)) {
                wynik.append("0");
            } else wynik.append("1");
        }
        return wynik.toString();
    }
}
