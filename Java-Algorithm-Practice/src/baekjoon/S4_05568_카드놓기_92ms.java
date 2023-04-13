package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S4_05568_카드놓기_92ms {
    private static int k;
    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 4 <= n <= 10
        k = Integer.parseInt(br.readLine()); // 2 <= k <= 4
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }
        HashSet<Integer> numberSet = new HashSet<>();
        recur(cards, new int[k], 0, 0, numberSet);
        System.out.println(numberSet.size());
    }

    public static void recur(int[] cards, int[] pickedCards, int r, int bit, HashSet<Integer> numberSet) {
        if (r == k){
            int digit = 1;
            int number = 0;
            for (int i = 0; i < r; i++) {
                number += pickedCards[i] * digit;
                digit *= getDigit(pickedCards[i]);
            }
            numberSet.add(number);
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((bit & 1 << i) == 0) {
                pickedCards[r] = cards[i];
                recur(cards, pickedCards, r + 1, bit | (1 << i), numberSet);
            }
        }
    }

    public static int getDigit(int i) {
        if (i / 10 == 0) return 10;
        else return 100;
    }
}
