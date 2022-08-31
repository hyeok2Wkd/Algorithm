package P9251_LCS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static String str1;
	static String str2;
	static int [][] dp;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine();
		str2 = br.readLine();
		
		dp = new int[str2.length()+1][str1.length()+1];
		
		for(int i = 1;i<str2.length()+1;i++) {
			for(int j = 1;j<str1.length()+1;j++) {
				if(str1.charAt(j-1) == str2.charAt(i-1)) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
				}
			}
		}
		
		System.out.println(dp[str2.length()][str1.length()]);

	}

}
