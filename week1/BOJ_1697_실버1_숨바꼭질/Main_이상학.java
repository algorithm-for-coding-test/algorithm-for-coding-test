package week1.BOJ_1697_실버1_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 136ms
public class Main_이상학 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	static boolean[] visit = new boolean[100001];
	static int[] map = new int[100001];

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		System.out.println(map[K]);
	}
	
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			
			start = q.poll();
			if(start == K) {
				break;
			}
			
			if(start-1 >= 0 && !visit[start-1]) {
				q.add(start-1);
				map[start-1] = map[start] + 1;
				visit[start-1] = true;
			}
			if(start+1 < 100001 && !visit[start+1]) {
				q.add(start+1);
				map[start+1] = map[start] + 1;
				visit[start+1] = true;
			}
			if(start*2 < 100001 && !visit[start*2]) {
				q.add(start*2);
				map[start*2] = map[start] + 1;
				visit[start*2] = true;
			}
		}
	}
}
