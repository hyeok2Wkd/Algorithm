package P_1516_게임개발;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static int N;
	static ArrayList<Integer> [] graph;
	static int [] time;
	static int [] inOrder;
	static int [] totalTime;
	
	public static void main(String [] args) throws Exception{
		
		System.setIn(new FileInputStream("src/P_1516_게임개발/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		
		for(int i = 1;i<=N;i++) {
			graph[i] = new ArrayList();
		}
		
		time = new int[N+1];
		inOrder = new int[N+1];
		
		totalTime = new int[N+1];
		Arrays.fill(totalTime, -1);
		
		for(int i = 1;i<=N;i++) {
			
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				graph[num].add(i);
				inOrder[i]++;
			}
			
		}
		
		Queue<Integer> q = new LinkedList<>();
		//진입차수 0인 노드 찾기
		for(int i = 1;i<=N;i++) {
			if(inOrder[i] == 0) {
				q.add(i);
				totalTime[i] = time[i];
			}
		}
		
		
		while(!q.isEmpty()) {
			
			int now = q.remove();
			
			for(int i = 0;i<graph[now].size();i++) {
				
				int next = graph[now].get(i);
				
				inOrder[next]--;
				totalTime[next] = Math.max(totalTime[next], totalTime[now]);
				
				if(inOrder[next] == 0) {
					totalTime[next] += time[next];
					q.add(next);
				}
				
			}
		}
		
		for(int i = 1;i<=N;i++) {
			System.out.println(totalTime[i]);
		}
		
		
		
		
	}
}