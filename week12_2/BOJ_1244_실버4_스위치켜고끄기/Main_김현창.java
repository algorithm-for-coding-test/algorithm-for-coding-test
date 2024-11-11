package week12_2.BOJ_1244_실버4_스위치켜고끄기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int countOfSwitches = Integer.parseInt(br.readLine());
		int[] state = new int[countOfSwitches + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= countOfSwitches; ++i) {
			state[i] = Integer.parseInt(st.nextToken());
		}

		int countOfStudents = Integer.parseInt(br.readLine());
		for (int i = 0; i < countOfStudents; ++i) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for (int j = number; j <= countOfSwitches; j += number) {
					state[j] = 1 - state[j];
				}
			} else {
				state[number] = 1 - state[number];
				for (int j = 1; number - j > 0 && number + j <= countOfSwitches; ++j) {
					if (state[number - j] == state[number + j]) {
						state[number - j] = 1 - state[number - j];
						state[number + j] = 1 - state[number + j];
					} else break;
				}
			}
		}
		printArray(state, 1, countOfSwitches + 1, 20);
		br.close();
	}

	private static void printArray(int[] array, int fromIndex, int toIndex, int line) {
		StringBuilder sb = new StringBuilder();
		for (int i = fromIndex; i < toIndex; ++i) {
			sb.append(array[i]).append(" ");
			if (i % line == 0)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}