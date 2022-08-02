package D1_자릿수더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String input = st.nextToken();
		
		int result = 0;
		
		for(int i = 0;i<input.length();i++) {
			result += input.charAt(i) -'0';
		}

		System.out.println(result);
	}

}
