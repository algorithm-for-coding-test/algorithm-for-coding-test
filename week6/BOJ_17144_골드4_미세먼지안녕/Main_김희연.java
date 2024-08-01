package week6.BOJ_17144_골드4_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	static int[][] arr;
	static int r, c, t;
	static int x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		arr = new int[r][c];

		for(int i=0; i<r; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1){
					x = i;
				}
			}
		}

		for(int i=0; i<t; i++){
			spread(); 	//1. 미세먼지 확산
			operate();	//2. 공기청정기 작동
		}

		int sum = 0;
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				sum += arr[i][j];
			}
		}

		System.out.println(sum + 2);
	}

	public static void spread(){
		int[][] dust = new int[r][c];

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				int amount = arr[i][j]/5;
				if(arr[i][j] > 0){
					for(int k=0; k<4; k++){
						int nx = i + dx[k];
						int ny = j + dy[k];

						if(nx < 0 || nx >= r || ny < 0 || ny >= c || arr[nx][ny] == -1)
							continue;

						dust[nx][ny] += amount;
						dust[i][j] -= amount;
					}
				}
			}
		}

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				arr[i][j] += dust[i][j];
			}
		}
	}

	public static void operate(){

		//반시계
		for(int i=x-1; i>0; i--)
			arr[i][0] = arr[i-1][0];
		for(int i=0; i<c-1; i++)
			arr[0][i] = arr[0][i+1];
		for(int i=0; i<x-1; i++)
			arr[i][c-1] = arr[i+1][c-1];
		for(int i=c-1; i>0; i--)
			arr[x-1][i] = arr[x-1][i-1];

		//시계
		for(int i=x; i<r-1; i++)
			arr[i][0] = arr[i+1][0];
		for(int i=0; i<c-1; i++)
			arr[r-1][i] = arr[r-1][i+1];
		for(int i=r-1; i>x; i--)
			arr[i][c-1] = arr[i-1][c-1];
		for(int i=c-1; i>0; i--)
			arr[x][i] = arr[x][i-1];

		arr[x-1][1] = 0;
		arr[x][1] = 0;
		arr[x-1][0] = -1;
		arr[x][0] = -1;
	}
}
