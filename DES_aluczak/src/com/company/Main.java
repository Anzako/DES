package com.company;

import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static BitSet fromByteArray(byte[] bytes) {
        BitSet bits = new BitSet();
        for (int i = 0; i < bytes.length * 8; i++) {
            if ((bytes[bytes.length - i / 8 - 1] & (1 << (i % 8))) > 0) {
                bits.set(64 - i);
            }
        }
        return bits;
    }


    public static void main(String[] args) {






        Scanner scanner = new Scanner(System.in);
        binarray konwerter = new binarray();

        String slowo = "IEOFIT#1"; // 8 bajtow
        char[] slowoZnak = slowo.toCharArray();
        String klucz = "IEOFIT#1";
        char[] kluczZnak = klucz.toCharArray();

        final byte[] b = slowo.getBytes();
        System.out.println(b[0]);
        BitSet bitowo = fromByteArray(b);
        System.out.println(bitowo);
        System.out.println(bitowo.get(1, 8));

//        final BitSet set = BitSet.valueOf(new byte[] { b });
//        for(int i = 0; i<7; i++){
//            System.out.println(set.get(i));
//        }

        //System.out.println(set.get(0));
//        System.out.println(set.length());
//        BitSet zapisBitowy = new BitSet();



        StringBuilder jedynkowoSlowo = new StringBuilder();
        StringBuilder jedynkowoKlucz = new StringBuilder();

        for(int i = 0; i < 8; i++){
            konwerter.setZnak(slowoZnak[i]);
            jedynkowoSlowo.append(konwerter.getBin(8));
            konwerter.setZnak(kluczZnak[i]);
            jedynkowoKlucz.append(konwerter.getBin(8));
        }
        System.out.println(jedynkowoSlowo);

        permutacja permuted = new permutacja(jedynkowoSlowo.toString());
        String permutedSlowo = permuted.getPermutedSlowo();

        permuted.setJedynkowy(jedynkowoKlucz.toString());
        String klucz1 = permuted.getPermutedKlucz(1);
        String klucz2 = permuted.getPermutedKlucz(2);
        String leftSlowo = permutedSlowo.substring(0, permutedSlowo.length()/2);
        String rightSlowo = permutedSlowo.substring(permutedSlowo.length()/2, permutedSlowo.length());
        //System.out.println(leftSlowo);
        System.out.println(rightSlowo);

        Integer[] shiftNumber = new Integer[] {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
        StringBuilder preSubkey = new StringBuilder();
        leftShift shifted = new leftShift();
        Shrink shrinking = new Shrink();

        for(int i = 0; i < 1; i++){
            // Subkeys
            preSubkey.setLength(0);

            shifted.setKlucz(klucz1);
            shifted.getShiftedKey(shiftNumber[i]);
            klucz1 = shifted.getKlucz();
            preSubkey.append(klucz1);

            shifted.setKlucz(klucz2);
            shifted.getShiftedKey(shiftNumber[i]);
            klucz2 = shifted.getKlucz();
            preSubkey.append(klucz2);

            permuted.setJedynkowy(preSubkey.toString());
            String subkey = permuted.getPermutedSubkey();
            //System.out.println(subkey);

            // Expand and XOR with subkey
            permuted.setJedynkowy(rightSlowo);
            String right48B = permuted.getPermutedRozszerzona();
            Xor alternatywa = new Xor(right48B, subkey);
            String permutedSubkey = alternatywa.result();
            //System.out.println(permutedSubkey);

            // Shrinking
            shrinking.setPermutedSubkey(permutedSubkey);
            System.out.println("Subkey wynosi " + shrinking.getPermutedSubkey());
            //System.out.println(shrinking.getShrinked());
            shrinking.getShrinked();
        }
    }
}
