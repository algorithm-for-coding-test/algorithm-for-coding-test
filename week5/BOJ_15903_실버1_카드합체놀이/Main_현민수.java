package week5.BOJ_15903_실버1_카드합체놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_현민수 {

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> que = new PriorityQueue<Long>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	que.add(Long.parseLong(st.nextToken()));
        }
        
        for(int i=0;i<M;i++) {
        	long a = que.poll();
        	long b = que.poll();
        	que.add(a+b);
        	que.add(a+b);
        }
        long ans = 0;
        while(!que.isEmpty()) {
        	ans += que.poll();
        }
        System.out.println(ans);
    }

    


    
}