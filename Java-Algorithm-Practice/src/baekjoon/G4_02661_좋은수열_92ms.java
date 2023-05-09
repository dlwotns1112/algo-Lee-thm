package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_02661_좋은수열_92ms {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        go("", 1);
    }
    public static void go(String s, int r) {
        if (r > N) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i < 4; i++) {
            String ns = s + i;
            if (isGood(ns, r))
                go(ns, r + 1);
        }
    }
    public static boolean isGood(String s, int r) {
        int max = r / 2 + 1;
        for (int i = 1; i < max; i++) {
            if (s.substring(r - i).equals(s.substring(r - 2 * i, r - i))) return false;
        }
        return true;
    }
}