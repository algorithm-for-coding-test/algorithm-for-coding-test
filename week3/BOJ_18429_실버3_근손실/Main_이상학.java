package week3.BOJ_18429_실버3_근손실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {
	
	static boolean[] visit;
	static int[] kitList;
	static int[] correctList;
	static int count;
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		kitList = new int[N];
		correctList = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			kitList[i] = Integer.parseInt(st.nextToken());
		}
		
		visit = new boolean[N];
		count = 0;
		int status = 500;
		
		getCount(0, status);
		
		System.out.println(count);
	}
	
	static void getCount(int depth, int status) {
		
		if(status < 500) {
			return;
		}
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				correctList[depth] = i;
				visit[i] = true;
				getCount(depth+1, status + kitList[i] - K);
				visit[i] = false;
			}
		}
	}
}
