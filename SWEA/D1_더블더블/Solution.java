package D1_더블더블;

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
		
		int now = 1;
		sb.append(now+" ");
		for(int i = 1;i<=T;i++) {
			
			now *= 2;
			
			sb.append(now + " ");
		}
		
		System.out.println(sb);
	}

}
