package week12_2.BOJ_2922_골드4_즐거운단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_김희연 {
	static long answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		char[] arr = str.toCharArray();

		func(0, arr, false, 1, 1, 0, 0);  //(인덱스, arr, L 포함 여부, 모음 개수, 자음 개수, 모음 연속, 자음 연속)

		System.out.println(answer);
	}

	public static void func(int index, char[] arr, boolean haveL, long vowelLine, long constantLine, int cnt1, int cnt2){
		if(cnt1 >= 3 || cnt2 >= 3)
			return;

		if(index == arr.length){
			if(haveL)
				answer += (vowelLine * constantLine);
			return;
		}

		if(arr[index] == '_') {
			//모음
			func(index + 1, arr, haveL, vowelLine * 5, constantLine, cnt1+1, 0);
			//자음
			func(index + 1, arr, haveL, vowelLine, constantLine * 20, 0, cnt2+1);
			//L
			func(index + 1, arr, true, vowelLine, constantLine, 0, cnt2+1);
		} else {
			if(isVowel(arr[index])){
				func(index+1, arr, haveL, vowelLine, constantLine, cnt1+1, 0);
			} else{
				func(index+1, arr, haveL || arr[index] == 'L', vowelLine, constantLine, 0, cnt2+1);
			}
		}
	}

	// 모음 체크 함수
	public static boolean isVowel(char c) {
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}