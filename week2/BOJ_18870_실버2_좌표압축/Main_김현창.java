package week2.BOJ_18870_실버2_좌표압축;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		coordinateCompression(arr, N);

		StringBuilder sb = new StringBuilder();
		for (int x: arr)
			sb.append(x).append(" ");
		System.out.println(sb.toString());
	    br.close();
	}

	private static void coordinateCompression(int[] arr, int size) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int x: arr)
			map.put(x, 0);

		int keyCount = map.size();
		int[] sorted = new int[keyCount];
		int idx = 0;
		for (int x: map.keySet()) {
			sorted[idx++] = x;
		}
		Arrays.sort(sorted);

		idx = 0;
		for (int key: sorted) {
			map.put(key, idx++);
		}

		for (int i = 0; i < size; ++i)
			arr[i] = map.get(arr[i]);
	}
}
