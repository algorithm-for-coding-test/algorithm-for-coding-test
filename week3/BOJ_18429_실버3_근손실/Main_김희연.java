package week3.BOJ_18429_실버3_근손실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int n, k;
	static int[] arr;
	static boolean[] visit;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visit = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(500, 0);
		System.out.println(answer);
	}

	public static void dfs(int sum, int idx){
		if(idx == n){
			answer++;
			return;
		}

		for(int i=0; i<n; i++){
			if(visit[i] || (sum + arr[i] - k) < 500)
				continue;
			visit[i] = true;
			dfs(sum + arr[i] - k, idx + 1);
			visit[i] = false;
		}
	}
}
