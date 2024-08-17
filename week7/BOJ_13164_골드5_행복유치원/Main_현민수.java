package week7.BOJ_13164_골드5_행복유치원;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] key = new int[N-1];
        for(int i=0;i<N-1;i++){
            key[i] = num[i+1] - num[i];
        }
        Arrays.sort(key);
        int ans = 0;
        for(int i=0;i<N-K;i++){
            ans += key[i];
        }
        System.out.println(ans);
    }

}
