package week3.BOJ_1561_골드1_놀이공원;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] runningTime = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			runningTime[i] = Integer.parseInt(st.nextToken());
		}

		if (N <= (long) M) {
			System.out.println(N);
		} else {
			/**
			 * binary search
			 */
			long left = 0;
			long right = N * 30;
			while (left <= right) {
				long mid = (left + right) >> 1;
				long child = getChildCount(runningTime, mid);
				if (child >= N) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			long t = right + 1;

			long count = M;
			for (int i = 0; i < M; ++i) {
				count += (t - 1) / runningTime[i];
			}

			for (int i = 0; i < M; ++i) {
				if (t % runningTime[i] == 0)
					++count;

				if (count == N) {
					System.out.println(i + 1);
					break;
				}
			}
		}
	    br.close();
	}
	
	private static long getChildCount(int[] runningTime, long time) {
		long count = runningTime.length;
		for (int t: runningTime) {
			count += time / t;
		}
		return count;
	} 
}
