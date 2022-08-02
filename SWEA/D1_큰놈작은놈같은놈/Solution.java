package D1_큰놈작은놈같은놈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			if(left < right) {
				sb.append("#"+(t+1) + " <\n");
			}else if(left > right) {
				sb.append("#"+(t+1) + " >\n");
			}else {
				sb.append("#"+(t+1) + " =\n");
			}
			
			
		}
		System.out.println(sb);
	}
	
}
