package D1_스탬프찍기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<size;i++) {
			
			sb.append("#");
			
		}
		
		System.out.println(sb);
		
		
	}

}
