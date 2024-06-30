package week1.BOJ_1189_실버1_컴백홈;

import java.util.*;
import java.io.*;

public class Main_김희연 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int r, c, k;
	static String[][] arr;
	static int answer = 0;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new String[r][c];
		visit = new boolean[r][c];

		for(int i=0; i<r; i++){
			arr[i] = br.readLine().split("");
		}

		visit[r-1][0] = true;
		dfs(r-1, 0, 1);
		System.out.println(answer);
	}

	public static void dfs(int x, int y, int cnt){
		if(x == 0 && y == c-1){
			if(cnt == k)
				answer++;
			return;
		}

		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || arr[nx][ny].equals("T"))
				continue;

			visit[nx][ny] = true;
			dfs(nx, ny, cnt+1);
			visit[nx][ny] = false;
		}
	}
}