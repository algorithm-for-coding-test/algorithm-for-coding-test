package week2.BOJ_12847_실버3_꿀아르바이트;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m;
	static long[] T;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		T = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			T[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		for(int i=0; i<m; i++) {
			sum += T[i];
		}
		
		long max = sum;
		for(int i=0; i+m<n; i++) {
			sum -= T[i];
			sum += T[i+m];
			if(max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
