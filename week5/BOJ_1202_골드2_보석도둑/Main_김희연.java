package week5.BOJ_1202_골드2_보석도둑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {
	static class Jewelry {
		int mass; // 무게
		int value; // 가격

		Jewelry(int mass, int value) {
			this.mass = mass;
			this.value = value;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Jewelry[] arr = new Jewelry[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[i] = new Jewelry(m, v);
		}

		Arrays.sort(arr, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				if (o1.mass == o2.mass) {
					return Integer.compare(o2.value, o1.value);
				}
				return Integer.compare(o1.mass, o2.mass);
			}

		});

		int[] bags = new int[k];
		for (int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bags);

		Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long answer = 0;
		int index = 0;
		for (int i = 0; i < k; i++) {
			while (index < n && arr[index].mass <= bags[i]) { //현재 보석의 무게가 가방이 들어가는 경우
				pq.offer(arr[index++].value);
			}

			if (!pq.isEmpty()) { //제일 가격이 큰 보석 넣음
				answer += pq.poll();
			}
		}

		System.out.println(answer);
	}
}

