package com.company;

public class permutacja {
    String jedynkowy;
    int[] kolejnoscSlowo = new int[] {58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
    int[] kolejnoscKlucz1 = new int[] {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36};
    int[] kolejnoscKlucz2 = new int[] {63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
    int[] kolejnoscSubkey = new int[] {14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
    int[] kolejnoscRozszerzona = new int[] {32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};

    public permutacja(String jedynkowy) {
        this.jedynkowy = jedynkowy;
    }

    public void setJedynkowy(String jedynkowy) {
        this.jedynkowy = jedynkowy;
    }

    public String getJedynkowy() {
        return jedynkowy;
    }

    public String getPermutedSlowo(){
        StringBuilder afterPerm = new StringBuilder();
        for (int j : kolejnoscSlowo) {
            afterPerm.append(jedynkowy.charAt(j - 1));
        }
        return afterPerm.toString();
    }

    public String getPermutedKlucz(int polowa){
        StringBuilder afterPerm = new StringBuilder();
        if(polowa == 1){
            for (int j : kolejnoscKlucz1) {
                afterPerm.append(jedynkowy.charAt(j - 1));
            }
        }
        else if(polowa == 2){
            for (int j : kolejnoscKlucz2) {
                afterPerm.append(jedynkowy.charAt(j - 1));
            }
        }
        return afterPerm.toString();
    }

    public String
    getPermutedSubkey(){
        StringBuilder afterPerm = new StringBuilder();
        for (int j : kolejnoscSubkey) {
            afterPerm.append(jedynkowy.charAt(j - 1));
        }
        return afterPerm.toString();
    }

    public String getPermutedRozszerzona(){
        StringBuilder afterPerm = new StringBuilder();
        for (int j : kolejnoscRozszerzona) {
            afterPerm.append(jedynkowy.charAt(j - 1));
        }
        return afterPerm.toString();
    }

}
