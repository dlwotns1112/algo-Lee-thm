package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S4_05568_카드놓기_96ms {
    private static int k;
    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 4 <= n <= 10
        k = Integer.parseInt(br.readLine()); // 2 <= k <= 4
        String[] cards = new String[n];
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }
        HashSet<String> numberSet = new HashSet<>();
        recur(cards, new String[k], 0, 0, numberSet);
        System.out.println(numberSet.size());
    }

    public static void recur(String[] cards, String[] pickedCards, int r, int bit, HashSet<String> numberSet) {
        if (r == k){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(pickedCards[i]);
            }
            numberSet.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((bit & 1 << i) == 0) {
                pickedCards[r] = cards[i];
                recur(cards, pickedCards, r + 1, bit | (1 << i), numberSet);
            }
        }
    }
}
