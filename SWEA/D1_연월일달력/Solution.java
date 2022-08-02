package D1_연월일달력;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int [] endDay = {0,31,28,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
		
			st = new StringTokenizer(br.readLine());
			
			String days = st.nextToken();

			
			String year = days.substring(0, 4);
			String month = days.substring(4, 4+2);
			String day = days.substring(4+2, 4+2+2);
			
			int monthIndex=Integer.parseInt(month); 
			
			if(endDay[monthIndex] >= Integer.parseInt(day)  && 
					Integer.parseInt(day) >= 1) {
				sb.append("#"+t+" "+year+"/"+month+"/"+day+"\n");
			}else {
				sb.append("#"+t+" "+-1+"\n");
			}
			
		}
		
		System.out.println(sb);
		
		
	}

}
