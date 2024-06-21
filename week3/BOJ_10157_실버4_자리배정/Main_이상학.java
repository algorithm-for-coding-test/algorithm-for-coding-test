package week3.BOJ_10157_실버4_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		if(K > C*R) {
			System.out.println(0);
			return;
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
	    int[][] map = new int[C+1][R+1];

	    int count = 1;
	    int x = 1;
	    int y = 1;
	    int xP = 0;
	    int yP = 0;
	    int dir = 0;
	    while(count != K) {
	    	
    		map[x][y] = count;
	    	xP = x + dx[dir];
	    	yP = y + dy[dir];
	    	if(xP > C || xP < 1 || yP > R || yP < 1 || map[xP][yP] != 0) {
	    		
	    		dir = (dir+1) % 4;
	    		xP = x + dx[dir];
	    		yP = y + dy[dir];
	    	}
	    	
    		x = xP;
    		y = yP;
    		count++;
	    }

	    System.out.println(x + " " + y);
	}
}

/*
 * Java에서 boolean[][] 배열로 상태값을 저장할 때 메모리 초과가 발생했지만 int[][] 배열로 저장할 때는 메모리 초과가 발생하지 않은 이유는 Java의 메모리 관리 방식과 관련이 있습니다.

Java에서 기본 자료형의 배열은 각각의 원소가 기본 자료형의 크기만큼 메모리를 차지합니다. 예를 들어, int는 4바이트(32비트)이고 boolean은 1바이트(8비트)입니다. 따라서 int 배열은 boolean 배열보다 더 많은 메모리를 차지할 것처럼 보이지만 실제로는 그렇지 않습니다.

Java의 메모리 관리에서 boolean[][] 배열은 다음과 같은 방식으로 메모리를 사용합니다:

boolean[][] 배열은 2차원 배열이므로 배열의 배열을 저장하는 구조입니다.
각 배열 참조는 객체로 취급되어 별도의 메모리를 차지합니다.
또한, JVM의 구현에 따라 boolean 배열은 효율성을 위해 내부적으로 1바이트가 아닌 4바이트나 8바이트로 정렬될 수 있습니다.
반면에, int[][] 배열은 다음과 같이 관리됩니다:

int[][] 배열도 2차원 배열이므로 배열의 배열을 저장하는 구조입니다.
각 배열 참조는 객체로 취급되어 메모리를 차지합니다.
int는 항상 4바이트로 정렬되며, JVM은 이를 더 효율적으로 관리할 수 있습니다.
즉, boolean 배열은 메모리 정렬 및 관리 때문에 실제로 예상보다 더 많은 메모리를 사용할 수 있으며, 이로 인해 메모리 초과가 발생할 수 있습니다. 반면, int 배열은 이러한 정렬 문제 없이 일정한 크기의 메모리를 사용하므로 더 큰 배열을 처리할 수 있게 됩니다.

따라서, boolean[][] 배열이 int[][] 배열보다 더 많은 메모리를 사용하는 경우가 발생할 수 있습니다.
 * */

