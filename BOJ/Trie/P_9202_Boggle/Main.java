package P_9202_Boggle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {

	Node[] child;
	boolean isEnd;
	boolean isHit;

	public Node() {
		child = new Node[26];
		for (int i = 0; i < 26; i++) {
			child[i] = null;
		}
		isEnd = false;
		isHit = false;
	}

}

public class Main {

	static int N;
	static int M;
	static Node root;
	static char[][] map;
	static String maxWord;
	static long maxScore;
	static long wordCount;
	static boolean [][]visited;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("자료구조/P_9202_Boggle/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		root = new Node();
		map = new char[4][4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			makeTrie(st.nextToken(), 0, root);
		}

		st = new StringTokenizer(br.readLine());
		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());

		wordCount = 0;
		maxScore = 0;
		maxWord = "";

		for (int m = 0; m < M; m++) {
			
			visited = new boolean[4][4];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < 4; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					int idx = map[i][j] - 'A';

					if (root.child[idx] != null && visited[i][j] == false) {
						String str = "";
						str += map[i][j];
						DFS(i, j, root.child[idx], str);
					}
				}
			}

			isClear(root);

			sb.append(maxScore + " " + maxWord + " " + wordCount+"\n");
			
			wordCount = 0;
			maxScore = 0;
			maxWord = "";

			if (m != M - 1)
				st = new StringTokenizer(br.readLine());
		}
		
		System.out.println(sb);

	}

	static void makeTrie(String str, int now, Node node) {
		// 1. 체크인
		
		
		// 2. 목적지니?
		if (str.length() == now) {
			node.isEnd = true;
			return;
		}
		// 3. 순회
		// 4. 갈수있니?
		int idx = str.charAt(now) - 'A';
		// 존재하지 않는 경우
		if (node.child[idx] == null) {
			node.child[idx] = new Node();
			makeTrie(str, now + 1, node.child[idx]);// 5. 간다
		}
		// 존재하는 경우
		else {
			makeTrie(str, now + 1, node.child[idx]);// 5. 간다
		}

		// 6. 체크아웃

	}

	static int getScore(String str) {
		if (str.length() <= 2)
			return 0;
		else if (str.length() <= 4)
			return 1;
		else if (str.length() == 5)
			return 2;
		else if (str.length() == 6)
			return 3;
		else if (str.length() == 7)
			return 5;
		else
			return 11;
	}

	static void DFS(int x, int y, Node node, String str) {
		// 1.체크인
		visited[x][y] = true;
		
		
		// 2.목적지니?
		if (node.isEnd == true && node.isHit == false) {
			node.isHit = true;

			wordCount++;

			int score = getScore(str);
			maxScore += score;

			if (maxWord.length() < str.length()) {
				maxWord = str;
			} else if (maxWord.length() == str.length()) {
				int comp = str.compareTo(maxWord);
				if (comp < 0) {
					maxWord = str;
				}
			}
		}
		// 3.순회
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 4.갈수있니?
			if (isTrue(nx, ny) && visited[nx][ny] == false) {
				int idx = map[nx][ny] - 'A';
				if (node.child[idx] != null) {
					// 5.간다
					DFS(nx, ny, node.child[idx], str + map[nx][ny]);
				}
			}
		}

		// 6.체크아웃
		visited[x][y] =false;

	}

	static void isClear(Node node) {

		node.isHit = false;

		for (int i = 0; i < 26; i++) {

			if (node.child[i] != null) {
				isClear(node.child[i]);
			}

		}

	}

	static boolean isTrue(int x, int y) {
		if (x > -1 && x < 4 && y > -1 && y < 4)
			return true;
		else
			return false;
	}
}
