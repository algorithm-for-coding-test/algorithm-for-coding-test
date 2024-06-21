package week3.BOJ_2512_실버2_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int arr[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for(int i=0 ; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int start = 0;
		int end = arr[N-1];
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2; //내야할 세금
			long budget = 0; //모든 지방 세금 합
			for(int i=0; i<N; i++) {
				if(arr[i] >= mid)
					budget += mid; //요청한 예산액이 더 크면 상한액만 배정
				else
					budget += arr[i]; //요청한 예산액보다 작으면 해당 값만 배정
			}
			if(budget > M) //다 배정한 값이 국가예산보다 넘으면 내야할 세금을 다시 수정
				end = mid - 1;
			else {
				start = mid + 1; //작으면 범위를 크게해서 다시 계산
				answer = Math.max(answer, mid);
			}
		}

		System.out.println(answer);
	}
}
