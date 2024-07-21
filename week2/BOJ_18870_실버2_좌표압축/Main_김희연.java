package week2.BOJ_18870_실버2_좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			num[i] = Integer.parseInt(st.nextToken());
			arr[i] = num[i];
		}

		Arrays.sort(arr);

		Map<Integer, Integer> map = new HashMap<>();

		int rank = 0;
		for(int i=0; i<N; i++){
			if(map.containsKey(arr[i]))
				continue;

			map.put(arr[i], rank++);
		}

		for(int i=0; i<N; i++){
			sb.append(map.get(num[i]) + " ");
		}

		System.out.println(sb);
	}
}