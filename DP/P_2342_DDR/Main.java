package P_2342_DDR;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> steps;
	static int [][][]DP;
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/P_2342_DDR/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		steps = new ArrayList();
		
		for(int i = 0;;) {
			int step = Integer.parseInt(st.nextToken());
			if(step == 0) break;
			steps.add(step);
		}
		
		DP = new int[steps.size()][5][5];
		
		int step = steps.get(0);
		DP[0][0][step] = 2;
		DP[0][step][0] = 2;
		
		
		//DP
		for(int n = 1;n<steps.size();n++) {
			
			//´ÙÀ½ ½ºÅÜ
			int next = steps.get(n);
			
			for(int i = 0;i<5;i++) {
				for(int j = 0;j<5;j++) {
					
					//¹âÀº °æ¿ì°¡ ¾øÀ½
					if(DP[n-1][i][j] == 0) continue;
					
					
					if(DP[n-1][i][j] > 0) {
						
						//¿Þ¹ß·Î ¹â±â
						int addScore = getScore(i, next);
						
						if(DP[n][next][j] == 0) {
							DP[n][next][j] = DP[n-1][i][j] + addScore;
						}
						else {
							DP[n][next][j] = Math.min(DP[n][next][j], DP[n-1][i][j] + addScore); 
						}
						
						//¿À¸¥¹ß·Î ¹â±â
						addScore = getScore(j, next);

						if(DP[n][i][next] == 0) {
							DP[n][i][next] = DP[n-1][i][j] + addScore;
						}
						else {
							DP[n][i][next] = Math.min(DP[n][i][next], DP[n-1][i][j] + addScore); 
						}
					}
					
					
				}
			}
			
		}
		
		int result = Integer.MAX_VALUE;
		
		//ÃÖÁ¾Á¡¼ö 
		for(int i = 0;i<5;i++) {
			if(DP[steps.size()-1][steps.get(steps.size()-1)][i] > 0) {
				result = Math.min(result, DP[steps.size()-1][steps.get(steps.size()-1)][i]);
			}
			
			if(DP[steps.size()-1][i][steps.get(steps.size()-1)] > 0) {
				result = Math.min(result, DP[steps.size()-1][i][steps.get(steps.size()-1)]);
			}
		}
		
		System.out.println(result);
		
		
		
	}
	
	static int getScore(int now, int next) {
		if(now == next) return 1;
		else if(now == 0) return 2;
		else if(Math.abs(now-next) == 2) return 4;
		else return 3;
	}
}
