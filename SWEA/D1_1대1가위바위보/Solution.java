package D1_1대1가위바위보;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int A,B;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int nextA = getNext(A);
		int nextB = getNext(B);
		
		if(A == nextB) {
			System.out.println("A");
		}
		else {
			System.out.println("B");
		}
		
		
		
	}
	
	static int getNext(int now) {
		return (now+1) == 4? 1 : (now+1); 
	}

}
