package week7.BOJ_1946_실버1_신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n+1];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b; //동석차가 없어서 순위를 인덱스로 사용
            }

            int cnt = 1;
            int min = arr[1]; //1등의 면접 성적
            for(int i=2; i<=n; i++){
                if(arr[i] < min){
                    min = arr[i];
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
