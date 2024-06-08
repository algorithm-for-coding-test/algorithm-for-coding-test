package week2.BOJ_14572_플래티넘5_스터디그룹;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		Student[] students = new Student[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] algorithm = new int[M];
			for (int j = 0; j < M; ++j) {
				algorithm[j] = Integer.parseInt(st.nextToken()) - 1;
			}
			students[i] = new Student(d, algorithm);
		}
		Arrays.sort(students, Comparator.comparingInt(o -> o.skill));

		int answer = 0;
		int left = 0;
		int[] counter = new int[K];
		for (int right = 0; right < N; ++right) {
			add(counter, students[right].algorithm);

			while ((students[right].skill - students[left].skill) > D) {
				subtract(counter, students[left].algorithm);
				++left;
			}
			int members = right - left + 1;
			int allAlgorithm = countGe(counter, 1);
			int allKnows = countGe(counter, members);
			int efficiency = (allAlgorithm - allKnows) * members;
			answer = Math.max(answer, efficiency);
		}
		System.out.println(answer);
		br.close();
	}

	private static void add(int[] target, int[] indices) {
		for (int index: indices) {
			++target[index];
		}
	}

	private static void subtract(int[] target, int[] indices) {
		for (int index: indices) {
			--target[index];
		}
	}

	private static int countGe(int[] array, int value) {
		int count = 0;
		for (int x: array) {
			if (x >= value)
				++count;
		}
		return count;
	}

	private static class Student {
		int skill;
		int[] algorithm;

		Student(int skill, int[] algorithm) {
			this.skill = skill;
			this.algorithm = algorithm;
		}
	}
}
