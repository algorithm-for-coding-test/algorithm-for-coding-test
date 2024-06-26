package week1.BOJ_1697_실버1_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int K;
	static int arr[] = new int[100001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);
		System.out.println(arr[K]);
	}

	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);

		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == K)
				return;
			if(now-1>=0 && arr[now-1] == 0) {
				arr[now-1] = arr[now]+1;
				queue.add(now-1);
			}
			if(now+1<=100000 && arr[now+1] == 0) {
				arr[now+1] = arr[now]+1;
				queue.add(now+1);
			}
			if(now*2<=100000 && arr[now*2] == 0) {
				arr[now*2] = arr[now]+1;
				queue.add(now*2);
			}
		}
	}
}