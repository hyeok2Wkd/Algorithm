package P16926_배열돌리기1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][][] arr;
	static int now;
	static int row_start;
	static int row_end;
	static int col_start;
	static int col_end;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[2][N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {

				arr[0][i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int r = 0; r < R; r++) {
			row_start = 0;
			row_end = N;
			col_start = 0;
			col_end = M;
			while (row_start+1 < row_end && col_start+1 < col_end) {

				int next = 1 - now;

				// 1
				for (int i = row_start + 1; i < row_end; i++) {
					arr[next][i][col_start] = arr[now][i - 1][col_start];
				}

				// 2
				for (int j = col_start + 1; j < col_end; j++) {
					arr[next][row_end - 1][j] = arr[now][row_end - 1][j - 1];
				}

				// 3
				for (int i = row_end - 1 - 1; i >= row_start; i--) {
					arr[next][i][col_end - 1] = arr[now][i + 1][col_end - 1];
				}

				// 4
				for (int j = col_end - 1 - 1; j >= col_start; j--) {
					arr[next][row_start][j] = arr[now][row_start][j + 1];
				}

				row_start++;
				row_end--;
				col_start++;
				col_end--;
			}
			now = 1-now;
		}

		for (int i = 0; i < N; i++) {
			for(int j = 0;j<M;j++) {
				sb.append(arr[now][i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
