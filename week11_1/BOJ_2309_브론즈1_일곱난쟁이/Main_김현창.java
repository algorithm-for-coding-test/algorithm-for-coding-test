package week11_1.BOJ_2309_브론즈1_일곱난쟁이;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int[] h = new int[9];
		int total = 0;
		for (int i = 0; i < 9; ++i) {
			total += h[i] = Integer.parseInt(br.readLine());
		}

		List<Integer> result = new ArrayList<>(7);
		for (int i = 0; i < 9; ++i) {
			for (int j = i + 1; j < 9; ++j) {
				if (total - h[i] - h[j] == 100) {
					for (int k = 0; k < 9; ++k) {
						if (i == k || j == k)
							continue;
						result.add(h[k]);
					}
					i = 9999;
					break;
				}
			}
		}

		result.sort((o1, o2) -> Integer.compare(o1, o2));
		StringBuilder sb = new StringBuilder();
		for (int x: result) {
			sb.append(x).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}
}

