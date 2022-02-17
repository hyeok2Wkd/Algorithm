package P_2842_집배원한상덕;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Info{
	int height;
	char what;
}

public class Main {
	
	static int N;
	static Info [][] map;
	static boolean [][]visited;
	static int result = 1000000;
	static int [] dx = {-1,1,0,0,-1,-1,1,1};
	static int [] dy = {0,0,-1,1,-1,1,-1,1};
	static int totalHouse = 0;
	static int INF = 1000000;
	static int [] heightList;
	static int minHeight, maxHeight;
	static boolean suc;
	static int houseCount;
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("src/P_2842_집배원한상덕/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		map = new Info[N][N];
		visited = new boolean[N][N];
		heightList = new int[N*N];
		
		int startX = 0;
		int startY = 0;
		
		for(int i = 0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			for(int j = 0;j<N;j++) {
				map[i][j] = new Info();
				map[i][j].what = str.charAt(j);
				if(map[i][j].what == 'P') {
					startX = i;
					startY = j;
				}
				else if(map[i][j].what == 'K') {
					totalHouse++;
				}
			}
			
		}
		
		int cnt = 0;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j].height = Integer.parseInt(st.nextToken());
				heightList[cnt] = map[i][j].height;
				cnt++;
			}
		}
		
		Arrays.sort(heightList);
		
		int left = 0;
		int right = 0;
		

		
		
		while(left <= right && right < heightList.length) {
			
			minHeight = heightList[left];
			maxHeight = heightList[right];
			
			suc = false;
			
			houseCount = totalHouse;
			
			if(isHeighTrue(map[startX][startY].height)) {
				
				DFS(startX, startY);
				if(suc) {
					result = Math.min(result, maxHeight - minHeight);
					left++;
				}
				else {
					right++;
				}
			}
			else {
				right++;
			}
			
			for(int i = 0;i<N;i++) {
				Arrays.fill(visited[i], false);
			}
			
			
		}
		
		System.out.println(result);
		
	}
	
	static void DFS(int x, int y) {
		
		//1. 체크인
		visited[x][y] = true;
		
		//2. 목적지니?
		if(houseCount == 0) {
			suc = true;
			return;
		}
		
		//3. 순회
		for(int i = 0;i<8;i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//4. 갈수있니 ?
			if(isTrue(nx,ny) && !visited[nx][ny] && isHeighTrue(map[nx][ny].height)) {
				
				//5. 간다.
				if(map[nx][ny].what == 'K') {
					houseCount--;
					DFS(nx,ny);
				}
				else {
					DFS(nx,ny);
				}
				
			}
			
		}
		
		//6. 체크아웃
		
	}
	
	static boolean isTrue(int x,int y) {
		if(x > -1 && x < N && y > -1 && y < N) {
			return true;
		}
		else return false;
	}
	
	static boolean isHeighTrue(int height) {
		if(height >= minHeight && height <= maxHeight) return true;
		return false;
	}
}
