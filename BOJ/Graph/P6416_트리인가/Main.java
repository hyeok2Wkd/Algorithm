package P6416_트리인가;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static HashMap<String, Integer> hm;
	static int idx;
	static List<List<Integer>> graph;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> inOrder;
	static boolean isTree;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		
		
		T = 1;

		while(true) {
			
			String str = br.readLine();
			
			if(str.equals("")) continue;
			else {
				if(!init(str)) break;
			}
			// 트리 초기화
			
			isTree = true;

			int root = 0;
			int cnt = 0;
			for (int i = 0; i < inOrder.size(); i++) {
				if (inOrder.get(i) == 0) {
					root = i;
					cnt++;
				}

				if (inOrder.get(i) >= 2) {
					isTree = false;
				}
			}


			// 트리X
			if (cnt == 0 || cnt > 1) {
				isTree = false;
			}
			
			visited = new boolean[inOrder.size()];

			if (isTree) {

				// 탐색해야함
				Queue<Integer> q = new LinkedList<>();
				q.add(root);

				while (!q.isEmpty()) {

					int node = q.remove();
					visited[node] = true;

					for (int i = 0; i < graph.get(node).size(); i++) {
						int next = graph.get(node).get(i);

						if (!visited[next]) {
							q.add(next);
						}

					}

				}

				for (int i = 0; i < visited.length; i++) {
					if (!visited[i])
						isTree = false;
				}

			}

			if (isTree || inOrder.size() == 0) {
				sb.append("Case ").append(T).append(" is a tree.\n");
			} else {
				sb.append("Case ").append(T).append(" is not a tree.\n");
			}
			T++;
		}
		
		System.out.println(sb);
		

	}

	static boolean init(String str) throws Exception {
		idx = 0;
		hm = new HashMap<>();
		graph = new ArrayList();
		inOrder = new ArrayList();

		ex: while (true) {

			if (!str.equals("")) {
				st = new StringTokenizer(str, " ");

				while (true) {
					try {
						String a = st.nextToken();
						String b = st.nextToken();

						if (a.charAt(0) == '0' && b.charAt(0) == '0')
							return true;
						if(Long.parseLong(a) < 0 && Long.parseLong(b) < 0) return false;

						if (!hm.containsKey(a)) {
							hm.put(a, idx++);
							graph.add(new ArrayList());
							inOrder.add(0);
						}

						if (!hm.containsKey(b)) {
							hm.put(b, idx++);
							graph.add(new ArrayList());
							inOrder.add(0);
						}

						int aIdx = hm.get(a);
						int bIdx = hm.get(b);
						graph.get(aIdx).add(bIdx);
						inOrder.set(bIdx, inOrder.get(bIdx) + 1);

					} catch (Exception e) {
						st = new StringTokenizer(br.readLine(), " ");
					}

				}

			} else {
				continue;
			}

		}


	}

}
