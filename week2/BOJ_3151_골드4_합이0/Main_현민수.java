package week2.BOJ_3151_골드4_합이0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_현민수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] st = new int[N];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            st[i] = Integer.parseInt(stz.nextToken());
        }
        Arrays.sort(st);
        long ans = 0;

        for (int idx = 0; idx < N - 2; idx++) {
            int target = -st[idx];
            int start = idx + 1;
            int end = N - 1;
            while (start < end) {
                int cur = st[start] + st[end];
                if (cur == target) {
                    int curl = st[start];
                    int curr = st[end];
                    if (curl == curr) {
                        ans += (end - start + 1) * (end - start) / 2;
                        break;
                    } 
                    else {
                        int left = 0, right = 0;
                        while (start < end && st[start] == curl) {
                        	left++;
                        	start++;
                        }
                        while (start <= end && st[end] == curr) {
                        	right++;
                        	end--;
                        }
                        ans += left * right;
                    }
                } else if (cur < target) {
                	start++;
                } else {
                	end--;
                }
            }
        }
        System.out.println(ans);
    }
}