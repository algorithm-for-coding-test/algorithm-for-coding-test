package week1.BOJ_14442_골드3_벽부수고이동하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//거리 값을 map에 채워가면서 풀었더니 오류가 발생하더라..
public class Main_이상학 {
	
	static class Node {
		
		int x, y, distance, breakCount;
		
		public Node(int x, int y, int distance, int breakCount) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.breakCount = breakCount;
		}
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static boolean[][][] visit;
	static int N, M, K;
	static int[][] map;
	static int minDistance = -1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[K+1][N][M];
		for(int i=0; i<N; i++) {
			
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(new Node(0, 0, 1, 0));
		System.out.println(minDistance);			
	}
	
	static void bfs(Node start) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		visit[0][start.y][start.x] = true;
		
		while(!q.isEmpty()) {
			
			start = q.poll();
			
			if(start.x == M-1 && start.y == N-1) {
				minDistance = start.distance;
				break;
			}
			
			for(int i=0; i<4; i++) {
				
				int x = start.x + dx[i];
				int y = start.y + dy[i];
				
				if(x < 0 || x >= M || y < 0 || y >= N) {
					continue;
				}
				
				if(map[y][x] == 0 && !visit[start.breakCount][y][x]) {
					
					visit[start.breakCount][y][x] = true;
					q.add(new Node(x, y, start.distance + 1, start.breakCount));
				}
				else if(start.breakCount < K && map[y][x] == 1 && !visit[start.breakCount+1][y][x]) {
					
					visit[start.breakCount+1][y][x] = true;
					q.add(new Node(x, y, start.distance + 1, start.breakCount + 1));
				}
			}
		}
	}
}
