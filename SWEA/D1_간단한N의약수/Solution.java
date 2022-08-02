package D1_간단한N의약수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1;i<=T;i++) {
			
			if(T % i == 0) {
				sb.append(i+" ");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
