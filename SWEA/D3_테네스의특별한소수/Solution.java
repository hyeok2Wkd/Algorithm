package D3_테네스의특별한소수;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static boolean [] isNotPrime;
	static int D,A,B;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine()," ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			D = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			answer = 0;
			isNotPrime = new boolean[B+1];
			
			isNotPrime[1] = true;
			
			for(int i = 2;i<=B;i++) {
				
				if(isNotPrime[i]) {
					continue;
				}
				
				for(int j = i+i;j<=B;j+=i) {
					
					isNotPrime[j] = true;
					
				}
			}
			
			char DtoChar = Integer.toString(D).charAt(0);
			
			for(int i = A;i<=B;i++) {
				
				if(isNotPrime[i]) continue;
				
				String temp = Integer.toString(i);
				
				char [] numArr = temp.toCharArray();
				
				for(int j = 0;j<numArr.length;j++) {
					if(numArr[j] == DtoChar) {
						answer++;
						break;
					}
				}
				
				
			}
			
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}//end of testCase
		System.out.println(sb);
	
	}//end of main

}
