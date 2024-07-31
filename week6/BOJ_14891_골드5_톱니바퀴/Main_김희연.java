package week6.BOJ_14891_골드5_톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int[][] gear = new int[5][8];
	static int[] dir; //톱니바퀴 회전방향 정보

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=1; i<=4 ;i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(br.readLine());

		for(int i=0; i<k; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dir = new int[5];
			dir[a] = b;
			checkDir(a);
			move();
		}

		int answer =0;
		if(gear[1][0] == 1) answer+=1;
		if(gear[2][0] == 1) answer+=2;
		if(gear[3][0] == 1) answer+=4;
		if(gear[4][0] == 1) answer+=8;

		System.out.println(answer);
	}

	public static void checkDir(int a){
		for(int i=a; i>1; i--) { //왼쪽 톱니바퀴
			if (gear[i][6] != gear[i-1][2]) { //극이 다르면 반대방향 회전
				dir[i-1] = -dir[i];
			} else { //회전하지 않으면 옆 톱니바퀴도 회전하지 않음
				break;
			}
		}

		for(int i=a; i<4; i++){ //오른쪽 톱니바퀴
			if(gear[i][2] != gear[i+1][6]){
				dir[i+1] = -dir[i];
			} else{
				break;
			}
		}
	}

	public static void move(){
		int temp;

		for(int i=1; i<=4; i++){
			if(dir[i] == 1){ //시계방향
				temp = gear[i][7];
				for(int j=7; j>0; j--){
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			} else if(dir[i] == -1){ //반시계방향
				temp = gear[i][0];
				for(int j=0; j<7; j++){
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
			}
		}
	}
}
