package D1_최대수구하기;

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

			int maxValue = 0;

			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] > maxValue) {
					maxValue = arr[i];
				}
			}

			sb.append("#" + (t + 1) + " " + maxValue + "\n");

		}
		System.out.println(sb);
	}
	
}
