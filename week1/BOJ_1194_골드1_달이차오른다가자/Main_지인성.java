package week1.BOJ_1194_골드1_달이차오른다가자;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_지인성 {
  
  static boolean [][][] visited;
  static char[][] map;
  static int N,M;
  static int key;
  static int move;
  static int[] dr = { 0, 1, 0, -1 };
  static int[] dc=  { 1, 0, -1, 0 };
  static Queue<Node> queue = new ArrayDeque<Node>();
  static Node start;
  static class Node {
    int r;
    int c;
    int m;
    int k;
    
    public Node(int r, int c, int m, int k) {
      super();
      this.r = r;
      this.c = c;
      this.m = m;
      this.k = k; 
    }
  }
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N][M][1<<6];
    map = new char[N][M];
    move = 0;
    
    for(int i=0; i<N; i++)
    {
      String str = br.readLine();
      for(int j=0; j<M; j++)
      {
        map[i][j] = str.charAt(j);
        if(map[i][j] == '0')
          queue.add(new Node(i,j,0,0));
      }
    }
    bfs();
    
  }
  
  static void bfs() {
    while(!queue.isEmpty())
    {
      Node node = queue.poll();
      if(map[node.r][node.c] == '1')
      {
        System.out.println(node.m);
        return;
      }
      
      if(visited[node.r][node.c][node.k])//이미 방문했다면
      {
          continue;
      }
      
      visited[node.r][node.c][node.k] = true;
      
      for(int i=0;i<4;i++)
      {
          int nr =  node.r+dr[i];
          int nc =  node.c+dc[i];
          
          if( nr<0 || nr>=N || nc<0 || nc>=M ) // 경계를 벗어난 경우  
          {
              continue;
          }
          
          if(map[nr][nc]=='#')  //벽인경우   
          {
              continue;
          }
          
          if(map[nr][nc]=='.'||map[nr][nc]=='0'||   map[nr][nc]=='1')   //빈 칸이거나 목적지인경우 이동 가능  
          {
              move+=1; // 한칸 이동 
              queue.add(new Node(nr,nc,node.m+1,node.k));
          }
          
          if(map[nr][nc] - 'a' >=0 && map[nr][nc]-'a'<=5)   //만약 이동할 위치에 열쇠가 있는 경우라면 
          {
              int bitmask = node.k | (1<< map[nr][nc]-'a');//그 열쇠를 포함시켜준다
              move+=1;
              queue.add(new Node(nr,nc,node.m+1,bitmask));
          }
          if(map[nr][nc] - 'A' >=0 && map[nr][nc] - 'A'<=5) //문을 만났다면
          {
              int bitmask = 1 << map[nr][nc]-'A';
              if(bitmask == (bitmask & node.k))//열쇠를 가지고 있는지 확인
              {
                move+=1;
                  queue.add(new Node(nr,nc,node.m+1, node.k));
              }
          }
      }
      
      
      
      
      
      
    }
    System.out.println(-1);
    return;

    
    
    
  }
}
