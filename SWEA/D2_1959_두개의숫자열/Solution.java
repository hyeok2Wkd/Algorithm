package D2_1959_두개의숫자열;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("./src/D2_1959_두개의숫자열/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T;

		T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			int N, M;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[] A;
			int[] B;

			// A가 무조건 적은 범위
			if (N <= M) {
				A = new int[N];
				B = new int[M];

				st = new StringTokenizer(br.readLine());

				for (int i = 0; i < A.length; i++) {
					A[i] = Integer.parseInt(st.nextToken());
				}

				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < B.length; i++) {
					B[i] = Integer.parseInt(st.nextToken());
				}

			} else {
				A = new int[M];
				B = new int[N];

				st = new StringTokenizer(br.readLine());

				for (int i = 0; i < B.length; i++) {
					B[i] = Integer.parseInt(st.nextToken());
				}

				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < A.length; i++) {
					A[i] = Integer.parseInt(st.nextToken());
				}
			}

			int maxValue = 0;

			for (int i = 0; i <= B.length - A.length; i++) {

				int now = 0;

				for (int j = 0, k = i; j < A.length; j++, k++) {

					now += A[j] * B[k];

				}

				maxValue = Math.max(maxValue, now);

			}

			sb.append("#" + (t + 1) + " " + maxValue + "\n");

		}

		System.out.println(sb);

	}

}
