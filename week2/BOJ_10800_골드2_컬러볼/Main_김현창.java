package week2.BOJ_10800_골드2_컬러볼;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int MAX_COLOR_COUNT = 2024;
	private static final int MAX_BALL_COUNT = 200024;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball[N];
		int[] accumulatedSize = new int[MAX_COLOR_COUNT];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(i, C, S);
			accumulatedSize[S] += S;
		}
		for (int i = 1; i < MAX_COLOR_COUNT; ++i) {
			accumulatedSize[i] += accumulatedSize[i - 1];
		}
		Arrays.sort(balls, (o1, o2) -> {
			if (o1.size != o2.size)
				return Integer.compare(o1.size, o2.size);
			return Integer.compare(o1.index, o2.index);
		});

		int[] result = new int[N];
		int[] accumulatedSizeByColor = new int[MAX_BALL_COUNT];
		for (int i = 0, j; i < N; i = j) {
			int currentSize = balls[i].size;
			List<Ball> temp = new ArrayList<>();
			for (j = i; j < N && balls[j].size == currentSize; ++j) {
				Ball ball = balls[j];
				result[ball.index] = accumulatedSize[currentSize - 1] - accumulatedSizeByColor[ball.color];
				temp.add(ball);
			}
			for (Ball ball: temp) {
				accumulatedSizeByColor[ball.color] += ball.size;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int x: result) {
			sb.append(x).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static class Ball {
		int index, color, size;

		Ball(int index, int color, int size) {
			this.index = index;
			this.color = color;
			this.size = size;
		}
	}
}
