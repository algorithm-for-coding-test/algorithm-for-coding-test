package week14_1.BOJ_32531_실버1_래환이의수강신청대작전;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] bm = new int[M + 1];
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int countOfStudents = Integer.parseInt(st.nextToken());
			for (int j = 0; j < countOfStudents; ++j) {
				int x = Integer.parseInt(st.nextToken());
				bm[x] |= (1 << i);
			}
		}

		Map<Integer, Integer> counter = getCounter(bm, 1, M + 1);
		long answer = 1;
		for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
			if (entry.getValue() > 2 || (entry.getKey() == 0 && entry.getValue() > 1)) {
				answer = 0;
				break;
			} else if (entry.getKey() != 0) {
				answer <<= 1;
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static Map<Integer, Integer> getCounter(int[] array, int fromIndex, int toIndex) {
		Map<Integer, Integer> counter = new HashMap<>();
		for (int i = fromIndex; i < toIndex; ++i) {
			counter.put(array[i], counter.getOrDefault(array[i], 0) + 1);
		}
		return counter;
	}
}
