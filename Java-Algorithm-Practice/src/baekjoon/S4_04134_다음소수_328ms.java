package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_04134_다음소수_328ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            long n = Long.parseLong(br.readLine());
            while (!isPrime(n)){
                n++;
            }
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }

    public static boolean isPrime(long num) {
        if (num < 2) return false;
        int end = (int) Math.pow(num, 0.5);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
