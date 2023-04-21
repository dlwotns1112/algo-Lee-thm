package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_16434_드래곤앤던전_360ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        long[] map = new long[N];// 잃거나 얻는 HP

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int tempATK = Integer.parseInt(st.nextToken());
            int tempHP = Integer.parseInt(st.nextToken());
            switch (type) {
                case 1 :
                    long times = tempHP / atk - (tempHP % atk == 0 ? 1 : 0);
                    map[i] = (long) -tempATK * times;
                    break;
                case 2 :
                    atk += tempATK;
                    map[i] = tempHP;
                    break;
            }
        }
        long answer = 0;
        long temp = 0;
        for (int i = 0; i < N; i++) {
            if (map[i] > 0) {
                if (answer > temp) answer = temp;
            }
            temp = map[i] + temp > 0 ? 0 : map[i] + temp;
        }
        if (answer > temp) answer = temp;
        System.out.println(-answer + 1L);
    }
}
