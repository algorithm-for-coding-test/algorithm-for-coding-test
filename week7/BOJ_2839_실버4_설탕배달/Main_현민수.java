package week7.BOJ_2839_실버4_설탕배달;

import java.io.*;
import java.util.*;

public class Main_현민수 {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans=0;
		while(n>0)
		{
			if(n%5==0)
			{
				n-=5;
				ans+=1;
				continue;
			}
			n-=3;
			ans+=1;
		}
		if(n<0)
			System.out.println(-1);
		else
			System.out.println(ans);

	}
}
