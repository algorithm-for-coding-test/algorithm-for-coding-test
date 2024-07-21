package week5.BOJ_3078_골드4_좋은친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_지인성 {
  static ArrayList<Integer> queue;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, K;
  static long answer;
  static int[] data;
  
public static void main(String[] args) throws IOException {
  queue = new ArrayList<>();
  StringTokenizer st = new StringTokenizer(br.readLine());
  N = Integer.parseInt(st.nextToken());
  K = Integer.parseInt(st.nextToken());
  data = new int [21]; 
  // 0~K까지의 배열이 담긴 데이터배열, 0번인덱스는 사용하지 말고 i+1~K까지정보가 담기도록 매번갱신해주자
  // 최대길이는 20까지들어오니까!
  
  for(int i=0; i<N; i++)
  {
    queue.add(br.readLine().length());
  }
  
  
  for(int i=0; i<K; i++)
  {
    data[queue.get(i)] +=1;
  }
  
  for(int i=0; i<N; i++)
  {
    int target = queue.get(i);
    data[target] -=1;
    if(i+K < N) // 오버플로우가 발생하지 않는다면
    {
      data[queue.get(i+K)] +=1;
    }
    answer += data[target];
  }
  
  System.out.print(answer);
  

  
  
}
}