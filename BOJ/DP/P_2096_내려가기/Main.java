package P_2096_내려가기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] minDP;
	static int[][] maxDP;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("src/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());

		arr = new int[N][3];
		minDP = new int[N][3];
		maxDP = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxDP[0][0] = arr[0][0];
		maxDP[0][1] = arr[0][1];
		maxDP[0][2] = arr[0][2];

		// max채우기
		for (int i = 1; i < N; i++) {

			for (int j = 0; j < 3; j++) {

				if (j == 0) {
					maxDP[i][j] = Math.max(maxDP[i - 1][j], maxDP[i - 1][j + 1]) + arr[i][j];
				} else if (j == 1) {
					maxDP[i][j] = Math.max(maxDP[i - 1][j - 1], maxDP[i - 1][j]);
					maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i - 1][j + 1]) + arr[i][j];
				} else {
					maxDP[i][j] = Math.max(maxDP[i - 1][j - 1], maxDP[i - 1][j]) + arr[i][j];
				}
			}
		}

		int result = maxDP[N - 1][0];
		for (int i = 1; i < 3; i++) {
			result = Math.max(maxDP[N - 1][i], result);
		}
		sb.append(result + " ");
		
		
		minDP[0][0] = arr[0][0];
		minDP[0][1] = arr[0][1];
		minDP[0][2] = arr[0][2];

		// min채우기
		for (int i = 1; i < N; i++) {

			for (int j = 0; j < 3; j++) {

				if (j == 0) {
					minDP[i][j] = Math.min(minDP[i - 1][j], minDP[i - 1][j + 1]) + arr[i][j];
				} else if (j == 1) {
					minDP[i][j] = Math.min(minDP[i - 1][j - 1], minDP[i - 1][j]);
					minDP[i][j] = Math.min(minDP[i][j], minDP[i - 1][j + 1]) + arr[i][j];
				} else {
					minDP[i][j] = Math.min(minDP[i - 1][j - 1], minDP[i - 1][j]) + arr[i][j];
				}
			}
		}

		
		result = minDP[N-1][0];
		for (int i = 1; i < 3; i++) {
			result = Math.min(minDP[N - 1][i], result);
		}
		sb.append(result + " ");
		
		System.out.println(sb);
		

	}
}