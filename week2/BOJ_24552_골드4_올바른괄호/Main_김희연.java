package week2.BOJ_24552_골드4_올바른괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int size = str.length();
		int[] arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = str.charAt(i) == '(' ? 1 : -1;
		}

		for(int i=0; i<size-1; i++){
			arr[i+1] += arr[i];
		}

		//정확히 하나의 괄호를 지워야하기 때문에 1 or -1일 경우만 확인
		int answer = 0;
		if(arr[size-1] == -1){ //닫는 괄호가 더 많을 경우
			int index = size-1;
			for(int i=0; i<size; i++){
				if(arr[i] == -1){
					index = i;
					break;
				}
			}
			answer = (index) / 2 + 1;
			// for(int i=index; i>=0; i--){
			// 	if(str.charAt(i) == ')')
			// 		answer++;
			// }
		} else if(arr[size-1] == 1){ //여는 괄호가 더 많을 경우
			int index = 0;
			for(int i=size-1; i>=0; i--){
				if(arr[i] == 0){
					index = i;
					break;
				}
			}
			answer = (size - (index+1)) / 2 + 1;
			// for(int i=index; i<size; i++){
			// 	if(str.charAt(i) == '(')
			// 		answer++;
			// }
		}
		System.out.println(answer);
	}
}
