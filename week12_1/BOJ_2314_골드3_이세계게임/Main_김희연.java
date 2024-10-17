package week12_1.BOJ_2314_골드3_이세계게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main_김희연 {
	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {1, 0, 0, -1};

	public static class State{
		char[][] grid;
		int move;

		public State(char[][] grid, int move){
			this.grid = grid;
			this.move = move;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] startGrid = new char[4][4];
		char[][] targetGrid = new char[4][4];

		for (int i = 0; i < 4; i++) {
			startGrid[i] = br.readLine().toCharArray();
		}

		// 빈 줄 무시
		String str = br.readLine();
		while (str.isEmpty())
			str = br.readLine();
		targetGrid[0] = str.toCharArray();

		// 목표 상태 입력
		for (int i = 1; i < 4; i++) {
			targetGrid[i] = br.readLine().toCharArray();
		}

		// BFS 탐색으로 최소 교체 횟수 구하기
		int result = bfs(startGrid, targetGrid);
		System.out.println(result);
	}

	public static int bfs(char[][] startGrid, char[][] targetGrid){
		Queue<State> queue = new LinkedList<>();
		Set<String> visit = new HashSet<>(); //문자열 형태로 방문 처리
		queue.add(new State(startGrid, 0));
		visit.add(gridToString(startGrid));

		while(!queue.isEmpty()){
			State now = queue.poll();

			if (Arrays.deepEquals(now.grid, targetGrid)) {
				return now.move;
			}

			// 교체 가능한 경우의 수
			for(int i=0; i<4; i++){
				for(int j=0; j<4; j++){
					for(int k=0; k<4; k++){
						int nx = i + dx[k];
						int ny = j + dy[k];

						if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
							continue;

						// 인접한 경우 교체
						char[][] newGrid = copyGrid(now.grid);
						char temp = newGrid[i][j];
						newGrid[i][j] = newGrid[nx][ny];
						newGrid[nx][ny] = temp;
						String gridString = gridToString(newGrid);

						// 새로 생성된 상태가 아직 방문되지 않았다면 큐에 추가
						if (!visit.contains(gridString)) {
							visit.add(gridString);
							queue.add(new State(newGrid, now.move + 1));
						}
					}
				}
			}
		}
		return -1; //불가능한 배치는 없으므로 도달하지 않음
	}

	public static String gridToString(char[][] grid){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<4; i++){
			sb.append(grid[i]);
		}
		return sb.toString();
	}

	public static char[][] copyGrid(char[][] grid) {
		char[][] newGrid = new char[4][4];
		for (int i = 0; i < 4; i++) {
			newGrid[i] = grid[i].clone();
		}
		return newGrid;
	}
}
