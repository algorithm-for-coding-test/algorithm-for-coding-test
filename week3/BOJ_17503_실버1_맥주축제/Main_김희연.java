package week3.BOJ_17503_실버1_맥주축제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Beer {
	int prefer, alcohol;

	public Beer(int prefer, int alcohol) {
		this.prefer = prefer;
		this.alcohol = alcohol;
	}
}

public class Main_김희연 {
	static int n, m, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Queue<Integer> prefers = new PriorityQueue<>();
		List<Beer> beers = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			beers.add(new Beer(p, a));
		}

		beers.sort((o1, o2) -> {
			if (o1.alcohol == o2.alcohol) {
				return o2.prefer - o1.prefer;
			}
			return o1.alcohol - o2.alcohol;
		});

		int sum = 0;
		int answer = -1;
		for (Beer beer : beers) {
			prefers.add(beer.prefer);
			sum += beer.prefer;

			if (prefers.size() > n) { //n보다 크면 가장 선호도가 낮은 맥주를 빼냄
				sum -= prefers.poll();
			}
			if (prefers.size() == n && sum >= m) {
				answer = beer.alcohol;
				break;
			}
		}
		System.out.print(answer);
	}
}