package P_5582_공통부분문자열;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static String str1;
	static String str2;
	
	static int [][] DP;
	static int result = 0;
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("src/P_5582_공통부분문자열/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		str1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		str2 = st.nextToken();
		
		DP = new int[str1.length()+1][str2.length()+1];
		
		for(int i = 1;i<=str1.length();i++) {
			for(int j = 1;j<=str2.length();j++) {
				
				//두 문자가 같은 경우
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					DP[i][j] = DP[i-1][j-1] + 1;
					result = Math.max(DP[i][j], result);
				}
			}
		}
		
		System.out.println(result);
		
	}
}
