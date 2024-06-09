package week1.BOJ_18126_실버2_너구리구구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_이상학 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static List<int[]>[] adjList;
	static int N;
	static boolean[] visit;
	static Long maxDistance;
	static final int START = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N+1];
		adjList = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adjList[A].add(new int[] {B, C});
			adjList[B].add(new int[] {A, C});
		}
		
		maxDistance = 0L;
		dfs(START, 0L);
		System.out.println(maxDistance);
	}
	
	static void dfs(int start, Long distance) {
		
		if(maxDistance < distance) {
			maxDistance = distance;
		}
		visit[start] = true;
		
		for(int[] d : adjList[start]) {
			if(!visit[d[0]]) {
				dfs(d[0], distance + d[1]);
			}
		}
	}
}
