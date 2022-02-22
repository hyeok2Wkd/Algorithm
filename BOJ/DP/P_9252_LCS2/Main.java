package P_9252_LCS2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static String str1;
	static String str2;
	static int [][] dp;
	static char [][]dir;
	
	public static void main(String[] args) throws Exception {
	
		System.setIn(new FileInputStream("src/P_9252_LCS2/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine());
		str1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		str2 = st.nextToken();
		
		dp = new int[str1.length()+1][str2.length()+1];
		dir = new char[str1.length()+1][str2.length()+1];
		
		for(int i = 1;i<=str1.length();i++) {
			for(int j = 1;j<=str2.length();j++) {
				
				//왼쪽이 크거나 같은 경우
				if(dp[i][j-1] >= dp[i-1][j]) {
					dp[i][j] = dp[i][j-1];
					dir[i][j] = 'L';
				}
				//위쪽이 큰 경우
				else {
					dp[i][j] = dp[i-1][j];
					dir[i][j] = 'U';
				}
				
				//str1 == str2
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					if(dp[i][j] < (dp[i-1][j-1] + 1)) {
						dp[i][j] = dp[i-1][j-1] + 1;
						dir[i][j] = 'C';
					}
				}
			}
		}
		
		
		int x = str1.length();
		int y = str2.length();
		
		ArrayList<Character> list = new ArrayList();
		
		while(x != 0 && y != 0) {
			
			//대각선이라면
			if(dir[x][y] == 'C') {
				list.add(str1.charAt(x-1));
				x--;
				y--;
			}
			else if(dir[x][y] == 'L'){
				y--;
			}
			else {
				x--;
			}
			
		}
		int count = list.size();
		for(int i = list.size()-1;i>=0;i--) {
			sb.append(list.get(i));
		}
		System.out.println(count);
		System.out.println(sb);
		
		
		
	}
	
}
