package week1.BOJ_1987_골드4_알파벳;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_지인성 {
  static int answer;
  static int[] dr = {0,1,0,-1};
  static int[] dc = {1,0,-1,0};
  static boolean[] alphabet;
  static int[][] maps;
  static int R,C;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    alphabet = new boolean[26];
    maps = new int[R][C];
    
    
    for(int i=0; i<R; i++)
    {
      String input = br.readLine();
      for(int j=0; j<C; j++)
      {
        maps[i][j] = input.charAt(j)-'A';
      }
    }    
    alphabet[maps[0][0]] = true;
    dfs(0,0,1);
    System.out.println(answer);

  }
  
  static void dfs(int r, int c, int count) 
  {
    if (answer < count)
      answer = count;
    
    for(int i =0; i< 4; i++)
    {
      if(r+dr[i] >=0 && c+dc[i]>=0 && r+dr[i] <R && c+dc[i] < C && !alphabet[maps[r+dr[i]][c+dc[i]]])
      {
        alphabet[maps[r+dr[i]][c+dc[i]]] = true;
        dfs(r+dr[i], c+dc[i], count+1);
        alphabet[maps[r+dr[i]][c+dc[i]]] = false;
      }
    }   
  }
  

}
