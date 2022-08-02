package D2_1974_스도쿠검증;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {

			int[][] arr = new int[9][9];

			// init
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] isExist = new boolean[10];
			boolean isFail = false;

			for (int i = 0; i < 9; i++) {

				isExist = new boolean[10];

				// 가로 체크
				for (int j = 0; j < 9; j++) {

					int idx = arr[i][j];

					if (!isExist[idx]) {
						isExist[idx] = true;
					} else {
						isFail = true;
						break;
					}

				}

				if (isFail) {
					break;
				}
					

				isExist = new boolean[10];

				// 세로 체크
				if (i == 0) {

					isExist = new boolean[10];

					for (int j = 0; j < 9; j++) {
						isExist = new boolean[10];
						for (int row = 0; row < 9; row++) {

							int idx = arr[row][j];
							if (!isExist[idx]) {
								isExist[idx] = true;
							} else {
								isFail = true;
								break;
							}

						}
						if (isFail)
							break;
					}
				}

				if (i == 0 || i == 3 || i == 6) {
					// 3x3 check
					for (int j = 0; j < 9; j+=3) {

						isExist = new boolean[10];

						for (int k = 0; k < 3; k++) {
							for (int l = 0; l < 3; l++) {
								int idx = arr[i+k][j+l];
								if (!isExist[idx]) {
									isExist[idx] = true;
								} else {
									isFail = true;
									break;
								}
							}
							if (isFail)
								break;
						}

					}
					
				}
			}

			if (isFail)
				sb.append("#" + (t+1) + " " +0 + "\n");
			else
				sb.append("#" + (t+1) + " " +1 + "\n");

		}

		System.out.println(sb);

	}

}
