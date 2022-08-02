package D1_평균값구하기;

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

			int[] arr = new int[10];

			st = new StringTokenizer(br.readLine());

			double avg = 0;

			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				avg += arr[i];
			}
			
			avg /= 10;
			
			String result = String.format("%d %.0f\n", (t+1), avg);

			sb.append("#").append(result);

		}
		System.out.println(sb);
	}
	
}
