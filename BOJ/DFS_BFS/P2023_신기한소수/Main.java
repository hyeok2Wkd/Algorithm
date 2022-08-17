package P2023_신기한소수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] firstNum = { 2, 3, 5, 7 };
	static int[] lastNum = { 1, 3, 5, 7, 9 };
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < firstNum.length; i++) {
			DFS(Integer.toString(firstNum[i]));
		}

		System.out.println(sb);

	}

	static void DFS(String now) {

		// 1.체크인
		// 2.목적지니
		if (now.length() == N) {
			sb.append(now).append("\n");
			return;
		}
		// 3.순회
		for (int i = 0; i < lastNum.length; i++) {

			int num = Integer.parseInt((now + lastNum[i]));
			// 4.갈수있니
			boolean flag = false;
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					flag = true;
					break;
				}
			}
			// 5.간다
			if (!flag) {
				DFS(now + lastNum[i]);
			}
		}

		// 6.체크아웃

	}

}
