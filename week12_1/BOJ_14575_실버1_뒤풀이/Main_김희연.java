package week12_1.BOJ_14575_실버1_뒤풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int n, t;
	static int[][] lr;
	static int min = Integer.MAX_VALUE; //모든 사람들 중에 최소 주량
	static int max = Integer.MIN_VALUE; //모든 사람들 중에 최대 주량

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		lr = new int[n][2];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			lr[i][0] = Integer.parseInt(st.nextToken());
			lr[i][1] = Integer.parseInt(st.nextToken());

			min = Math.min(min, lr[i][0]);
			max = Math.max(max, lr[i][1]);
		}

		int result = lowerBound();
		if(cal(result))
			System.out.println(result);
		else
			System.out.println(-1);
	}

	public static int lowerBound(){
		int start = min;
		int end = max + 1;

		while(start < end){
			int mid = (start + end) / 2;

			if (cal(mid)) {
				end = mid; // mid 값이 가능한 경우, 더 작은 값 찾기
			} else {
				start = mid + 1; // mid 값이 불가능한 경우, 더 큰 값 찾기
			}
		}

		return start;
	}

	public static boolean cal(int mid){
		int lSum = 0, rSum = 0;

		for(int i=0; i<n; i++){
			if (lr[i][0] > mid)
				return false;

			lSum += lr[i][0]; //모든 사람의 최소 주량 합
			rSum += Math.min(mid, lr[i][1]); //모든 사람의 최대 주량 합
		}

		return lSum <= t && rSum >= t;
	}
}
