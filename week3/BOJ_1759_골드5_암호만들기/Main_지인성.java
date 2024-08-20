package week3.BOJ_1759_골드5_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_지인성 {
  static int L,C;
  static char[] words, selected;
  static StringBuilder sb = new StringBuilder();
public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  
  L = Integer.parseInt(st.nextToken());
  C = Integer.parseInt(st.nextToken());
  words = new char[C];
  selected = new char[L];
  
  st = new StringTokenizer(br.readLine());
  for(int i=0; i<C; i++)
  {
    words[i] = st.nextToken().charAt(0);
  }

  Arrays.sort(words);
  
  
  combi(0,0,0);
  System.out.println(sb);
  

} 
static void combi(int cnt, int start, int moum)
{
  if(cnt == L)
  {
    // 자음이 2개, 모음이 1개인지 체크 
   if(moum >=1 && L-moum >=2)
   {
     for(int i=0; i<L; i++)
       sb.append(selected[i]);
     sb.append("\n");
   }
   return;
  }
  
  for(int i=start; i<C; i++)
  {
    char target = words[i];
    selected[cnt] = target;
    if(target == 'a' || target =='e' || target =='i' || target=='o' || target=='u')
      combi(cnt+1, i+1, moum+1);
    else
      combi(cnt+1, i+1, moum);
    
  }
}

}
