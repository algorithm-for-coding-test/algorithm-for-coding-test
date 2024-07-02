package week1.BOJ_3184_실버1_양;

import java.io.*;
import java.util.*;

public class Main_김희연 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int r, c;
	static String[][] arr;
	static boolean[][] visit;
	static int total_sheep=0, total_wolf=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new String[r][c];
		visit = new boolean[r][c];

		for(int i=0; i<r; i++){
			arr[i] = br.readLine().split("");
		}

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(!arr[i][j].equals("#") && !visit[i][j]) {
					visit[i][j] = true;
					bfs(i, j);
				}
			}
		}
		System.out.println(total_sheep + " " + total_wolf);
	}

	public static void bfs(int x, int y){
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{x, y});

		int sheep = 0;
		int wolf = 0;

		if(arr[x][y].equals("o"))
			sheep++;
		else if(arr[x][y].equals("v"))
			wolf++;

		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0; i<size; i++){
				int[] now = queue.poll();

				for(int j=0; j<4; j++){
					int nx = now[0] + dx[j];
					int ny = now[1] + dy[j];

					if(nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || arr[nx][ny].equals("#")){
						continue;
					}

					visit[nx][ny] = true;

					if(arr[nx][ny].equals("o"))
						sheep++;
					else if(arr[nx][ny].equals("v"))
						wolf++;

					queue.add(new int[]{nx, ny});
				}
			}
		}

		if(sheep <= wolf)
			total_wolf += wolf;
		else
			total_sheep += sheep;
	}
}