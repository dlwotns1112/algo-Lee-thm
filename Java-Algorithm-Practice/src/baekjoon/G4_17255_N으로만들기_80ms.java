package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class G4_17255_N으로만들기_80ms {
    static char[] arr;
    static int len;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr =br.readLine().toCharArray();
        len = arr.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            dfs(i, i, arr[i]+"", arr[i]+"", 1, set);
        }
        System.out.println(set.size());
    }
    static void dfs(int L, int R, String cur, String path, int r, Set<String> set){
        if (r == len) {
            set.add(path);
            return;
        }
        if (L > 0) {
            String temp = arr[L - 1] + cur;
            dfs(L - 1, R, temp, path + temp, r + 1, set);
        }
        if (++R < len) {
            String temp = cur + arr[R];
            dfs(L, R, temp, path + temp, r + 1, set);
        }
    }
}
