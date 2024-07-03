package week1.BOJ_3184_실버1_스타트링크;

import java.io.*;
import java.util.*;

//bfs
public class Main_김희연 {
	static int dir[];

	static int f, s, g, u, d;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		dir = new int[]{u, -d};
		visit = new boolean[f+1];

		int cnt = bfs(s);

		if(cnt == -1)
			System.out.println("use the stairs");
		else
			System.out.println(cnt);
	}

	public static int bfs(int x){
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{x, 0});
		visit[x] = true;

		while(!queue.isEmpty()){
			int[] now = queue.poll();

			if(now[0] == g){
				return now[1];
			}

			for(int j=0; j<2; j++) {
				int floor = now[0] + dir[j];

				if (floor > f || floor < 1)
					continue;

				if (visit[floor]) {
					continue;
				}

				visit[floor] = true;
				queue.add(new int[]{floor, now[1] + 1});
			}
		}
		return -1;
	}
}