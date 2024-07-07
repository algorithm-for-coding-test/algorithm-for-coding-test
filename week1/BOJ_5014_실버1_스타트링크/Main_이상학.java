package week1.BOJ_5014_실버1_스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이상학 {

	static int[] map;
	static int F, S, G, U, D;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[F+1];
		visit = new boolean[F+1];
		bfs(S);
		
		if(S != G && map[G] == 0) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(map[G]);
		}
	}
	
	static void bfs(int start) {
		
		if(S == G) {
			map[start] = 0;
			return;
		}
	
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);
		map[start] = 0;
		
		while(!q.isEmpty()) {
			
			start = q.poll();
			
			if(start == G) {
				break;
			}
			
			if(start+U <= F && start-D > 0 && visit[start+U] && visit[start-D]) {
				continue;
			}
			if(start+U > F && start-D < 1) {
				continue;
			}

			if(start+U <= F && !visit[start+U]) {
				map[start+U] = map[start] + 1;
				q.add(start+U);
				visit[start+U] = true;
			}
			if(start-D >= 1 && !visit[start-D]) {
				map[start-D] = map[start] + 1;
				q.add(start-D);
				visit[start-D] = true;
			}
		}
	}
}
