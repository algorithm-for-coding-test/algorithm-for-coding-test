package week11_1.BOJ_1497_실버1_기타콘서트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int n, m;
	static long[] bit;
	static long max = Long.MIN_VALUE;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		bit = new long[n];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String str = st.nextToken();
			for(int j=0; j<m; j++){
				if(str.charAt(j) == 'Y')
					bit[i] |= 1L << j;
			}
		}

		dfs(0, 0L, 0);
		if (answer == 0)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	public static void dfs(int depth, long guitar, int cnt){
		int bitCount = Long.bitCount(guitar); //long을 bit 형식으로 바꿔서 1의 개수 카운트

		//현재보다 더 많이 칠 수 있을 때
		if(max < bitCount){
			max = bitCount;
			answer = cnt;
		} else if(max == bitCount) //현재보다 같으면 사용한 기타 수가 더 적은 걸로
			answer = Math.min(answer, cnt);

		if(depth == n || cnt > answer)
			return;

		//현재 기타 사용할 때
		dfs(depth+1, guitar | bit[depth], cnt+1);

		//현재 기타 사용안 할 때
		dfs(depth+1, guitar, cnt);
	}
}
