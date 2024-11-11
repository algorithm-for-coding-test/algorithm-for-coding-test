package week11_2.BOJ_1337_실버4_올바른배열;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> nums = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			set.add(num);
			for (int a = -2; a <= 2; ++a) {
				nums.add(num + a);
			}
		}
		eraseDuplicate(nums);
		nums.sort((o1, o2) -> Integer.compare(o1, o2));

		int left = 0;
		int right = 0;
		int notContains = 0;
		for (; right < 5; ++right) {
			int num = nums.get(right);
			if (!set.contains(num)) {
				++notContains;
			}
		}

		int answer = notContains;

		for (int end = nums.size(); right < end;) {
			int r = nums.get(right++);
			if (!set.contains(r)) ++notContains;
			int l = nums.get(left++);
			if (!set.contains(l)) --notContains;
			answer = Math.min(answer, notContains);
		}
		System.out.println(answer);
		br.close();
	}

	private static void eraseDuplicate(List<Integer> list) {
		Set<Integer> set = new HashSet<>(list);
		list.clear();
		list.addAll(set);
	}
}
