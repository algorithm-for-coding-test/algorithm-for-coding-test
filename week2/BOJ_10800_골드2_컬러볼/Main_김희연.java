package week2.BOJ_10800_골드2_컬러볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {

	public static class Ball{
		int idx, color, size;

		public Ball(int idx, int color, int size){
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Ball[] balls = new Ball[N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(i, c, s);
		}

		Arrays.sort(balls, (o1, o2) -> o1.size - o2.size);

		int[] result = new int[N];
		int[] colors = new int[N + 1];
		int num = 0;
		int sum = 0;


		for(int i=0; i<N; i++){
			Ball cur = balls[i];
			while(balls[num].size < cur.size){
				sum += balls[num].size;
				colors[balls[num].color] += balls[num].size;
				num++;
			}
			result[cur.idx] = sum - colors[cur.color];
		}

		for(int i=0; i<N; i++){
			sb.append(result[i] + "\n");
		}

		System.out.println(sb);
	}
}

