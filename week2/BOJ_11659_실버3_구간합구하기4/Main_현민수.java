package week2.BOJ_11659_실버3_구간합구하기4;

import java.util.Scanner;

public class Main_현민수 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] num = new int[n];
		int[] sum = new int[n+1];

		int temp = 0;
		for(int i=0;i<n;i++)
		{	
			num[i]=sc.nextInt();
			temp+=num[i];
			sum[i+1]=temp;
		}
		
		for(int i=0;i<m;i++)
		{

			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(sum[end]-sum[start-1]);

		}
		
	}

}