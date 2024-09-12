package week2.BOJ_26091_실버1_현대모비스소프트웨어아카데미;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_현민수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        int start = 0;
        int ans = 0;
        int end = N-1;
        while(start<end) {
        	if(num[start]+num[end]>=M) {
        		ans++;
        		start++;
        		end--;
        	}else {
        		start++;
        	}
        }
        System.out.println(ans);
    }
}