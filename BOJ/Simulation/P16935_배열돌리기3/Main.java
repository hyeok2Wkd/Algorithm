package P16935_배열돌리기3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][][] arr;
	static int now;
	static boolean isTrasnfrom;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[2][100][100];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				arr[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}

		String str = br.readLine();

		for (int i = 0; i < str.length(); i += 2) {

			switch (str.charAt(i)) {
			case '1':
				upDown();
				break;
			case '2':
				leftRight();
				break;
			case '3':
				right90();
				break;
			case '4':
				left90();
				break;
			case '5':
				rightRotate();
				break;
			case '6':
				leftRotate();
				break;
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(arr[now][i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	private static void leftRotate() {
		int next = 1 - now;
		
		//1 --> 4
		for(int i = 0;i<N/2;i++) {
			for(int j = 0;j<M/2;j++) {
				arr[next][i+N/2][j] = arr[now][i][j];
			}
		}
		
		//2 --> 1
		for(int i = 0;i<N/2;i++) {
			for(int j = M/2;j<M;j++) {
				arr[next][i][j-M/2] = arr[now][i][j];
			}
		}
		
		//3 --> 2
		for(int i = N/2;i<N;i++) {
			for(int j = M/2;j<M;j++) {
				arr[next][i-N/2][j] = arr[now][i][j];
			}
		}
		
		
		//4 --> 3
		for(int i = N/2;i<N;i++) {
			for(int j = 0;j<M/2;j++) {
				arr[next][i][j+M/2] = arr[now][i][j];
			}
		}
		
		
		now = next;
	}

	private static void left90() {
		int next = 1 - now;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[next][M - 1 - j][i] = arr[now][i][j];
			}
		}

		int temp = N;
		N = M;
		M = temp;

		now = next;
	}

	private static void rightRotate() {
		int next = 1 - now;

		// 1 --> 2
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[next][i][j + M / 2] = arr[now][i][j];
			}
		}

		// 2 --> 3
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				arr[next][i + N / 2][j] = arr[now][i][j];
			}
		}

		// 3 --> 4
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				arr[next][i][j - M / 2] = arr[now][i][j];
			}
		}

		// 4 --> 1
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[next][i - N / 2][j] = arr[now][i][j];
			}
		}

		now = next;
	}

	private static void right90() {
		int next = 1 - now;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[next][j][N - 1 - i] = arr[now][i][j];
			}
		}

		isTrasnfrom = !isTrasnfrom;
		int temp = N;
		N = M;
		M = temp;

		now = next;
	}

	private static void leftRight() {
		int next = 1 - now;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[next][i][M-1-j] = arr[now][i][j];
				arr[next][i][j] = arr[now][i][M-1-j];
			}

		}

		now = next;
	}

	private static void upDown() {

		int next = 1 - now;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				arr[next][N-1-i][j] = arr[now][i][j];
				arr[next][i][j] = arr[now][N-1-i][j];
			}

		}

		now = next;

	}

}
