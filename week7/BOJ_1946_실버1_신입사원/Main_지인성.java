package week7.BOJ_1946_실버1_신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_지인성 {
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;
  StringBuilder sb = new StringBuilder();
  int T = Integer.parseInt(br.readLine());
  int[][] candidate;
  for(int test_case=1; test_case<=T; test_case++)
  {
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    candidate = new int[N][];
    int target = 0;
    for(int i=0; i<N; i++)
    {
      st = new StringTokenizer(br.readLine());
      int dscore = Integer.parseInt(st.nextToken());
      int iscore = Integer.parseInt(st.nextToken());
      candidate[i] = new int[] {dscore, iscore};
    }
    

    Arrays.sort(candidate, (o1,o2)-> {
      return (o1[0]-o2[0]);
    });
    

    int minline = candidate[0][1]; // 최저합격등수 
    for(int[] score : candidate)
    {
      if(score[1] <= minline)
      {
        minline = score[1];
        answer++;
      }
    }
    
    
    sb.append(answer).append("\n");
//    System.out.println(answer);
}
  System.out.println(sb);
}}