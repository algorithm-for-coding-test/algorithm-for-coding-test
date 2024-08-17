package week7.BOJ_11501_실버2_주식;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] num = new int[N+1];
        	long ans = 0;
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++) {
        		num[i] = Integer.parseInt(st.nextToken());

        	}
            int max=0;  
            for (int i=N-1;i>=0;i--) {
            	int n = num[i];
                if (n > max) {
                	max = n;
                	continue;
                }
                ans+=max-n;
            }
        	sb.append(ans).append("\n");  	
        }
        System.out.println(sb);


    }

}
