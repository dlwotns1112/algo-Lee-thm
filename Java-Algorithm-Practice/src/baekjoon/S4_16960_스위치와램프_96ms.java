package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_16960_스위치와램프_96ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] switchArr = new int[++N];
        int[] lampArr = new int[M+1];
        while (N-- > 1) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            switchArr[N] = r;
            while (r-- > 0) {
                int lampNo = Integer.parseInt(st.nextToken());
                if (lampArr[lampNo] == 0) {
                    lampArr[lampNo] = N;
                }
                else if (lampArr[lampNo] == -1) {
                    switchArr[N]--;
                }
                else {
                    switchArr[N]--;
                    switchArr[lampArr[lampNo]]--;
                    lampArr[lampNo] = -1;
                }
            }
            if (switchArr[N] == 0) {
                System.out.println(1);
                return;
            }
        }
        for (int i = 1; i < switchArr.length; i++) {
            if (switchArr[i] == 0){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
